package Search;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

class BinarySearchTest {

    // Test #1: Asserts the search method returns true when the target is in the list
    @Test
    void findsTarget() {
        Integer[] list = { 1, 2, 3, 4, 5 };
        assertTrue(BinarySearch.search(5, list));
    }

    // Test #2: Asserts the search method returns false when the target is not in the list
    @Test
    void doesNotFindsTarget() {
        Integer[] list = { 1, 2, 3, 4, 5 };
        assertFalse(BinarySearch.search(6, list));
    }

    // Test #3: Asserts the search method returns false when the list is not sorted
    @Test
    void assertWhenListIsNotSorted() {
        Integer[] list = { 4, 3, 2, 5, 8 , 1};
        assertFalse(BinarySearch.search(4, list));
    }

    // Test #4: Asserts the search method returns true when other objects other than Integers are
    // used.
    @Test
    void findsTargetWithStrings() {
        String[] list = { "Chad", "Luis", "Luis", "Nicolas", "Samuel"};
        assertTrue(BinarySearch.search("Chad",list));
    }
}