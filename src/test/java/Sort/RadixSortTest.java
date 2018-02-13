package Sort;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
 @author Samuel Yanez <samuelyanez94@gmail.com>
 */

class RadixSortTest {

    // Test #1: Asserts the sort method sorts and array of integers
    @Test
    void sorts() throws RadixSort.NegativeIntegerException {
        Integer[] expected = {1, 2, 3, 4, 5};
        Integer[] actual = {2, 3, 4, 1, 5};

        RadixSort.sort(actual);

        assertArrayEquals(expected, actual);
    }

    // Test #2: Asserts the sort method does not crash when the array is empty
    @Test
    void sortsEmptyArray() throws RadixSort.NegativeIntegerException {
        Integer[] expected = {};
        Integer[] actual = {};

        RadixSort.sort(actual);

        assertArrayEquals(expected, actual);
    }

    // Test #3: Asserts the sort method does not sorts and array of negative integers
    @Test
    void throwsExceptionWithNegativeNumbers() {
        Integer[] actual = {45, 0, 3, -5, -10, 7};

        assertThrows(RadixSort.NegativeIntegerException.class, () -> RadixSort.sort(actual));
    }

    // Test #4: Asserts the sort method sorts and array of integers with duplicates
    @Test
    void sortsDuplicateIntegers() throws RadixSort.NegativeIntegerException {
        Integer[] expected = {0, 1, 2, 2, 2, 3, 3, 4};
        Integer[] actual = {2, 2, 3, 0, 3, 2, 4, 1};

        RadixSort.sort(actual);

        assertArrayEquals(expected, actual);
    }
}