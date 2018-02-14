package search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

class BinarySearchTest {

    // Test #1: Asserts the search method returns true when the target is in the list
    @Test
    void findsTarget() {
        Integer[] list = {1, 2, 3, 4, 5};
        assertTrue(BinarySearch.search(5, list));
    }

    // Test #2: Asserts the search method returns false when the target is not in the list
    @Test
    void doesNotFindsTarget() {
        Integer[] list = {1, 2, 3, 4, 5};
        assertFalse(BinarySearch.search(6, list));
    }

    // Test #3: Asserts the search method returns true when there are duplicates in the list
    @Test
    void findsTargetWithDuplicates() {
        Integer[] list = {1, 1, 3, 3, 10, 10};
        assertTrue(BinarySearch.search(3, list));
    }

    // Test #4: Asserts the search method returns true when other objects other than Integers are
    // used.
    @Test
    void findsTargetWithStrings() {
        String[] list = {"Chad", "Luis", "Luis", "Nicolas", "Samuel"};
        assertTrue(BinarySearch.search("Chad", list));
    }
}