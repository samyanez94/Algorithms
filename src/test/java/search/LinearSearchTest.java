package search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

class LinearSearchTest {

    // Test #1: Asserts the search method returns true when the target is in the list
    @Test
    void findsTarget() {
        Integer[] list = {1, 2, 3, 4, 5};
        assertTrue(LinearSearch.search(5, list));
    }

    // Test #2: Asserts the search method returns false when the target is not in the list
    @Test
    void doesNotFindsTarget() {
        Integer[] list = {1, 2, 3, 4, 5};
        assertFalse(LinearSearch.search(6, list));
    }

    // Test #3: Asserts the search method returns true when there are duplicates in the list
    @Test
    void findsTargetWithDuplicates() {
        Integer[] list = {1, 1, 3, 3, 10, 10};
        assertTrue(LinearSearch.search(3, list));
    }

    // Test #4: Asserts the search method returns true when other objects other than Integers are
    // used.
    @Test
    void findsTargetWithStrings() {
        String[] list = {"Chad", "Luis", "Luis", "Nicolas", "Samuel"};
        assertTrue(LinearSearch.search("Chad", list));
    }
}