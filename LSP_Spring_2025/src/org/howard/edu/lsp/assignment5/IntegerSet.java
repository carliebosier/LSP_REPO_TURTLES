package org.howard.edu.lsp.assignment5;
//Carlie Bosier

import java.util.ArrayList;
import java.util.List;

/**
 * IntegerSet represents a set of unique integers.
 * It provides methods to add, remove, and perform set operations like union, intersection, difference, and complement.
 */
public class IntegerSet {
    // Store the set elements in an ArrayList
    private List<Integer> set = new ArrayList<Integer>();

    /**
     * Default Constructor to create an empty IntegerSet.
     */
    public IntegerSet() {
    }

    /**
     * Constructor to initialize the IntegerSet with a given list of integers.
     *
     * @param set The list of integers to initialize the set.
     */
    public IntegerSet(ArrayList<Integer> set) {
        this.set = set;
    }

    /**
     * Clears the internal representation of the set, removing all elements.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set.
     *
     * @return the size of the set.
     */
    public int length() {
        return set.size();
    }

    /**
     * Compares this IntegerSet with another object to determine if they are equal.
     * Two IntegerSets are considered equal if they contain the same elements,
     * regardless of the order, and have the same size.
     * websites used: https://coderanch.com/t/742961/java/implementation-equals and https://stackoverflow.com/questions/596462/any-reason-to-prefer-getclass-over-instanceof-when-generating-equals
     * @param o The object to compare this IntegerSet to.
     * @return true if the two IntegerSets are equal, false otherwise.
     */
    public boolean equals(Object o) {
        if (o == this) {
            return true; 
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false; 
        }

        IntegerSet other = (IntegerSet) o;

        if (this.set.size() != other.set.size()) {
            return false; 
        }

        for (int i = 0; i < this.set.size(); i++) {
            boolean match = false;
            for (int j = 0; j < other.set.size(); j++) {
                if (this.set.get(i).equals(other.set.get(j))) {
                    match = true;
                    break; 
                }
            }
            if (!match) {
                return false; 
            }
        }

        return true; 
    }

    /**
     * Returns true if the set contains the specified value.
     *
     * @param value The value to check for.
     * @return true if the set contains the value, false otherwise.
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest item in the set.
     * wesbites used: https://stackoverflow.com/questions/12788182/finding-the-largest-value-in-an-arraylist and https://www.geeksforgeeks.org/finding-maximum-element-of-java-arraylist/ and https://www.codecademy.com/resources/docs/java/collections/max and https://www.geeksforgeeks.org/arraylist-contains-java/
     * @return the largest item in the set, or -1 if the set is empty.
     */
    public int largest() {
        if (set.isEmpty()) {
            return -1;
        }
        int largest = set.get(0);
        for (int i = 1; i < set.size(); i++) {
            if (set.get(i) > largest) {
                largest = set.get(i);
            }
        }
        return largest;
    }

    /**
     * Returns the smallest item in the set.
     * websites used: https://www.geeksforgeeks.org/finding-the-minimum-or-maximum-value-in-java-arraylist/ and https://www.tutorialspoint.com/find-minimum-element-of-arraylist-with-java-collections and https://www.baeldung.com/java-collection-min-max
     * @return the smallest item in the set, or -1 if the set is empty.
     */
    public int smallest() {
        if (set.isEmpty()) {
            return -1;
        }
        int smallest = set.get(0);
        for (int i = 1; i < set.size(); i++) {
            if (set.get(i) < smallest) {
                smallest = set.get(i);
            }
        }
        return smallest;
    }

    /**
     * Adds the specified item to the set if it is not already present.
     *
     * @param item The item to add.
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes the specified item from the set if it is present.
     *
     * @param item The item to remove.
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item)); 
    }

    /**
     * Performs the union of this set and another IntegerSet. The union will contain all elements
     * from both sets without duplicates.
     * websites used: https://www.geeksforgeeks.org/sets-union-function-guava-java/ and https://docs.oracle.com/javase/8/docs/api/java/util/Set.html
     * @param intSetb The other IntegerSet to perform the union with.
     */
    public void union(IntegerSet intSetb) {
        for (int i = 0; i < intSetb.set.size(); i++) {
            int value = intSetb.set.get(i);
            if (!set.contains(value)) {
                set.add(value);
            }
        }
    }

    /**
     * Performs the intersection of this set and another IntegerSet. The intersection will
     * contain only the elements that are present in both sets.
     * websites used: https://www.geeksforgeeks.org/sets-intersection-function-guava-java/ and https://stackoverflow.com/questions/8882097/how-to-calculate-the-intersection-of-two-sets
     * @param intSetb The other IntegerSet to perform the intersection with.
     */
    public void intersect(IntegerSet intSetb) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < this.set.size(); i++) {
            int value = this.set.get(i);
            if (intSetb.set.contains(value)) {
                result.add(value);
            }
        }
        set = result;
    }

    /**
     * Performs the difference of this set and another IntegerSet. The difference will
     * contain the elements from this set that are not present in the other set.
     * websites used: https://www.geeksforgeeks.org/sets-difference-function-guava-java/ and https://docs.oracle.com/javase/8/docs/api/java/util/Set.html
     * @param intSetb The other IntegerSet to perform the difference with.
     */
    public void diff(IntegerSet intSetb) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < this.set.size(); i++) {
            int value = this.set.get(i);
            if (!intSetb.set.contains(value)) {
                result.add(value);
            }
        }
        set = result;
    }

    /**
     * Performs the complement of this set relative to another IntegerSet. The complement will
     * contain elements from this set that are not present in the other set.
     *
     * @param intSetb The other IntegerSet to calculate the complement with.
     */
    public void complement(IntegerSet intSetb) {
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < intSetb.set.size(); i++) {
            int item = intSetb.set.get(i);
            if (!set.contains(item)) {
                result.add(item);
            }
        }
        set = result;
    }

    /**
     * Returns true if the set is empty, false otherwise.
     *
     * @return true if the set is empty, false otherwise.
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set.
     *
     * @return a string representing the set.
     */
    public String toString() {
		return set.toString();
	}
    
}
