/*
 * This file defines an abstract class named Bag.
 * In this exercise, you will be writing a larger class according to
 * the TODOs we have left you. You may find the readings in chapter
 * 1. Introduction to Java helpful.
 */

public abstract class Bag {
    /*
     * [Done]TODO: Create the following private instance variables
     *       - a String named color
     *       - an int named numberOfContents
     *       - an int named capacity
     *       - an array of Strings named contents
     */
    private String color;
    private int numberOfContents;
    private int capacity;
    private String[] contents;

    /*
     * TODO[Done]: Create a constructor that takes two arguments:
     *       - a String representing the Bag's colour
     *       - an int representing the Bag's capacity
     *
     * The other attributes (private instance variables) should
     * be empty (e.g. numberOfContents is 0 and an empty String array for
     * its contents.)
     */
    public Bag(String col, int cap){
        this.color = col;
        this.capacity = cap;
        this.contents = new String[this.capacity];
    }

    /*
     * [Done]TODO: Create a variety of 'getter' functions.
     *       These should be named:
     *           - getColor
     *           - getNumberOfContents
     *           - getCapacity
     */
    public String getColor(){
        return this.color;
    }

    public int getNumberOfContents(){
        return this.numberOfContents;
    }

    public int getCapacity(){
        return this.capacity;
    }

    /*
     * [Done]TODO: Create a setter function called setColor which sets the
     *       color of this bag to the given color.
     */
    public void setColor(String col){
        this.color = col;
    }

    /*
     * [Done]TODO: Create a method called addItem that takes in a String
     *       representing an item in the Bag.
     *       The item is added into the Bag if the number of items
     *       in the bag is < the capacity of the Bag.
     *       Remember to modify numberOfContents accordingly.
     *
     *       This method should return true if the item was added
     *       and false otherwise.
     */
    public boolean addItem(String item){
        int n = this.numberOfContents;
        if (n < this.capacity){
            this.contents[n] = item;
            this.numberOfContents ++;
            return true;
        }else{
            return false;
        }
    }

    /**
     * [Done]TODO: Create a method called popItem that returns a String.
     *       The string should be the last item added to this Bag
     *       and the item should be removed from this Bag.
     *       Remember to modify numberOfContents accordingly.
     *
     * If there are no items in this Bag, return null.
     *
     * @return
     */
    public String popItem(){
        int n = this.numberOfContents;
        if (n == 0){
            return null;
        }else if (n == 1){
            String thing = this.contents[0];
            String[] new_array = new String[this.capacity];
            this.contents = new_array;
            this.numberOfContents -= 1;
            return thing;
        }else{
            String thing = this.contents[n-1];
            String[] new_array = new String[this.capacity];
            for (int i = 0; i < n-1; i++){
                new_array[i] = this.contents[i];
            }
            this.contents = new_array;
            this.numberOfContents -= 1;
            return thing;
        }
    }

    /**
     * Increase this bag's capacity by n.
     *
     * @param n the amount to increase this Bag's capacity by
     */
    public void increaseCapacity(int n) {
        // [Done]TODO: Implement this method.
        this.capacity = this.capacity + n;
        String[] new_array = new String[this.capacity];
        for (int i = 0; i < this.numberOfContents; i++){
            new_array[i] = this.contents[i];
        }
        this.contents = new_array;
    }

    /**
     * Return the details of this Bag.
     * This method requires you to have created the private
     * instance variables mentioned above.
     *
     * @return
     */
    @Override
    public String toString() {
        return this.color + " Bag (" + this.numberOfContents + " / " +
                this.capacity + ")";
    }

    /*
     * Below we have defined an abstract method.
     * This method takes no arguments and does not return anything.
     * It increases the capacity of this Bag.
     *
     * You will need to implement this method in
     * HandBag.java and CrossbodyBag.java.
     *
     * We recommend you look at HandBag.java first.
     */
    public abstract void enhance();
}