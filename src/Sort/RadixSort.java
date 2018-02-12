package Sort;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Radix sort is a non-comparative integer sorting algorithm that sorts data with integer keys by
 * grouping keys by the individual digits which share the same significant position and value. A
 * positional notation is required, but because integers can represent strings of characters (e.g.,
 * names or dates) and specially formatted floating point numbers, radix sort is not limited to
 * integers.
 *
 * NOTE: This radix sort only works for positive integers
 *
 * Average case = O(n*k) Worst case = O(n*k) Best case = O(n*k)
 *
 * NOTE: n is the number of digits and k is the average bucket size
 *
 * Reference: http://en.wikipedia.org/wiki/Radix_sort
 *
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public class RadixSort {

    private static final int RADIX = 10;

    /**
     * Sorts an array of Integers using the Radix sort algorithm.
     *
     * @param unsorted the array of Integers to be sorted.
     */
    @SuppressWarnings("unchecked")
    public static void sort(Integer[] unsorted) {

        Queue<Integer>[] buckets = new Queue[RADIX];

        int numberOfDigits = getMaxNumberOfDigits(unsorted);
        int digit;

        // Creates buckets
        for (int i = 0; i < RADIX; i++)
            buckets[i] = new LinkedList<Integer>();

        for (int i = 0; i <= numberOfDigits; i++) {

            // Sorts the list
            for (int j = 0; j < unsorted.length; j++) {
                digit = getDigit(unsorted[j], i + 1);
                buckets[digit].add(unsorted[j]);
            }

            // Gathers the numbers back in the list
            int counter = 0;
            for (int j = 0; j < RADIX; j++) {
                while (!(buckets[j].isEmpty())) {
                    unsorted[counter] = buckets[j].poll();
                    counter++;
                }
            }
        }
    }

    /**
     * Cycles through a list of Integers and returns the maximum number of digits for a single
     * instance of an Integer.
     *
     * @param array the array of Integers to be sorted.
     */
    private static int getMaxNumberOfDigits(Integer[] array) {
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for (int i : array) {
            temp = (int) Math.log10(i) + 1;
            if (temp > max)
                max = temp;
        }
        return max;
    }

    /**
     * Returns the n digit of an Integer.
     *
     * @param number the number to find the n digit.
     * @param n      the position of the digit being searched.
     */
    private static int getDigit(int number, int n) {
        return (int) ((number / Math.pow(10, n - 1)) % 10);
    }
}
