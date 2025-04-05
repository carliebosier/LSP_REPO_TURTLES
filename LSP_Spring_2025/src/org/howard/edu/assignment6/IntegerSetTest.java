package org.howard.edu.assignment6;
//Carlie Bosier

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


/**
 * Test class for the IntegerSet class. Contains various test methods to make sure methods in IntegerSet class work correctly.
 */
public class IntegerSetTest {

    private IntegerSet set1;
    private IntegerSet set2;

    /**
     * Initializes two IntegerSet objects before each test.
     * Websites used for BeforeEach method: https://www.geeksforgeeks.org/before-vs-beforeclass-vs-beforeeach-vs-beforeall-in-junit/ and https://www.baeldung.com/junit-before-beforeclass-beforeeach-beforeall
     */
    @BeforeEach 
    public void setUp() {
        // Initialize the IntegerSet objects before each test
        set1 = new IntegerSet();
        set2 = new IntegerSet();
    }

    /**
     * Tests the clear method. Verifies that the set is empty after calling clear.
     */
    @Test
    @DisplayName("Test case for clear")
    public void testClear() {
        set1.add(1);
        set1.add(2);
        set1.clear();
        assertTrue(set1.isEmpty(), "Set should be empty after clear");
    }

    /**
     * Test the length method. Verifies that the correct number of elements is returned.
     */
    @Test
    @DisplayName("Test case for length")
    public void testLength() {
        set1.add(1);
        set1.add(2);
        set1.add(3);
        assertEquals(3, set1.length(), "Length of set should be 3");
    }

    /**
     * Test the equals method. Verifies that two sets are equal if they contain the same elements.
     */
    @Test
    @DisplayName("Test case for equals")
    public void testEquals() {
        set1.add(1);
        set1.add(2);
        set2.add(1);
        set2.add(2);
        assertTrue(set1.equals(set2), "Sets should be equal");

        set2.add(3);
        assertFalse(set1.equals(set2), "Sets should not be equal");
    }

    /**
     * Test the contains method. Verifies that the set contains specific elements. 
     */
    @Test
    @DisplayName("Test case for contains")
    public void testContains() {
        set1.add(1);
        set1.add(2);
        assertTrue(set1.contains(1), "Set should contain 1");
        assertFalse(set1.contains(3), "Set should not contain 3");
    }

    /**
     * Test the largest method. Verifies that the largest element in the set is returned and throws an exception if the set is empty. 
     * @throws IntegerSetException if the set is empty
     */
    @Test
    @DisplayName("Test case for largest")
    public void testLargest() throws IntegerSetException {
        set1.add(1);
        set1.add(2);
        set1.add(3);
        assertEquals(3, set1.largest(), "Largest value should be 3");

        IntegerSet emptySet = new IntegerSet();
        assertThrows(IntegerSetException.class, () -> emptySet.largest(), "Should throw exception for empty set");
    }

    /**
     * Test the smallest method. Verifies that the smallest element in the set is returned and throws an exception if the set is empty. 
     * @throws IntegerSetException if the set is empty
     */
    @Test
    @DisplayName("Test case for smallest")
    public void testSmallest() throws IntegerSetException {
        set1.add(1);
        set1.add(2);
        set1.add(3);
        assertEquals(1, set1.smallest(), "Smallest value should be 1");

        IntegerSet emptySet = new IntegerSet();
        assertThrows(IntegerSetException.class, () -> emptySet.smallest(), "Should throw exception for empty set");
    }

    /**
     * Test the add method. Verifies that duplicate elements are not added to the set. 
     */
    @Test
    @DisplayName("Test case for add")
    public void testAdd() {
        set1.add(1);
        set1.add(2);
        set1.add(1); // should not add 1 again
        assertEquals(2, set1.length(), "Set should only contain 2 unique elements");
    }

    /**
     * Test the remove method. Verifies that an element is removed from the set and is no longer in the set. 
     */
    @Test
    @DisplayName("Test case for remove")
    public void testRemove() {
        set1.add(1);
        set1.add(2);
        set1.remove(1);
        assertFalse(set1.contains(1), "Set should not contain 1 after removal");
    }

    /**
     * Test the union method. Verifies that the union of two sets contains all elements from both sets. 
     */
    @Test
    @DisplayName("Test case for union")
    public void testUnion() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.union(set2);
        assertTrue(set1.contains(3), "Set1 should contain 3 after union");
        assertEquals(3, set1.length(), "Union of set1 and set2 should have 3 elements");
    }

    /**
     * Test the intersect method. Verifies that the intersection of two sets contains only the elements shared in both sets.
     */
    @Test
    @DisplayName("Test case for intersect")
    public void testIntersect() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.intersect(set2);
        assertTrue(set1.contains(2), "Set1 should only contain 2 after intersection");
        assertFalse(set1.contains(1), "Set1 should not contain 1 after intersection");
    }

    /**
     * Test the diff method. Verifies that the difference of two sets contains the elements that are in the first set but not the second. 
     */
    @Test
    @DisplayName("Test case for diff")
    public void testDiff() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.diff(set2);
        assertTrue(set1.contains(1), "Set1 should contain 1 after difference");
        assertFalse(set1.contains(2), "Set1 should not contain 2 after difference");
    }

    /**
     * Test the complement method. Verifies that the complement of two sets contains elements that are not in the first set.  
     */
    @Test
    @DisplayName("Test case for complement")
    public void testComplement() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.complement(set2);
        assertTrue(set1.contains(3), "Set1 should contain 3 after complement");
        assertFalse(set1.contains(1), "Set1 should not contain 1 after complement");
    }

    /**
     * Test the isEmpty method. Verifies that the set is empty or not empty. 
     */
    @Test
    @DisplayName("Test case for empty")
    public void testIsEmpty() {
        assertTrue(set1.isEmpty(), "Set should be empty initially");
        set1.add(1);
        assertFalse(set1.isEmpty(), "Set should not be empty after adding an element");
    }

    /**
     * Test the toString method. Verifies that the string representation of the set matches the expected format. 
     */
    @Test
    @DisplayName("Test case for tostring")
    public void testToString() {
        set1.add(1);
        set1.add(2);
        assertEquals("[1, 2]", set1.toString(), "String representation should match");
    }
}

