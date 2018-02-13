package Sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 @author Samuel Yanez <samuelyanez94@gmail.com>
 */

class MergeSortTest {

    // Test #1: Asserts the sort method sorts and array of integers
    @Test
    void sorts() {
        Integer[] expected = {1, 2, 3, 4, 5};
        Integer[] actual = {2, 3, 4, 1, 5};

        MergeSort.sort(actual);

        assertArrayEquals(expected, actual);
    }

    // Test #2: Asserts the sort method does not crash when the array is empty
    @Test
    void sortsEmptyArray() {
        Integer[] expected = {};
        Integer[] actual = {};

        MergeSort.sort(actual);

        assertArrayEquals(expected, actual);
    }

    // Test #3: Asserts the sort method sorts and array of negative integers
    @Test
    void sortsNegativeIntegers() {
        Integer[] expected = {-10, -5, 0, 3, 7, 45};
        Integer[] actual = {45, 0, 3, -5, -10, 7};

        MergeSort.sort(actual);

        assertArrayEquals(expected, actual);
    }

    // Test #4: Asserts the sort method sorts and array of integers with duplicates
    @Test
    void sortsDuplicateIntegers() {
        Integer[] expected = {0, 1, 2, 2, 2, 3, 3, 4};
        Integer[] actual = {2, 2, 3, 0, 3, 2, 4, 1};

        MergeSort.sort(actual);

        assertArrayEquals(expected, actual);
    }

    // Test #5: Asserts the sort method sorts and array of rational numbers
    @Test
    void sortsDoubles() {
        Double[] expected = {-0.48, -0.38, 0.0, 2.2, 3.4, 5.6};
        Double[] actual = {5.6, 0.0, -0.38, -0.48, 2.2, 3.4};

        MergeSort.sort(actual);

        assertArrayEquals(expected, actual);
    }

    // Test #6: Asserts the sort method sorts and array of Strings
    @Test
    void sortsStrings() {
        String[] expected = {"Chad", "Luis", "Luis", "Nicolas", "Samuel"};
        String[] actual = {"Samuel", "Nicolas", "Luis", "Luis", "Chad"};

        MergeSort.sort(actual);

        assertArrayEquals(expected, actual);
    }
}