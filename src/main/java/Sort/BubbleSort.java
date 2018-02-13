package Sort;

/**
 * Bubble main.java.Sort is a simple sorting algorithm that repeatedly steps through the list to be sorted,
 * compares each pair of adjacent items and swaps them if they are in the wrong order. The pass
 * through the list is repeated until no swaps are needed, which indicates that the list is sorted.
 *
 * Average case = O(n^2) Worst case = O(n^2) Best case = O(n)
 *
 * Reference: https://en.wikipedia.org/wiki/Bubble_sort
 *
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public class BubbleSort {

    /**
     * Sorts an array of objects that implement Comparable using the Bubble sort algorithm.
     *
     * @param unsorted the array to be sorted.
     */
    public static <T extends Comparable<T>> void sort(T... unsorted) {
        int length = unsorted.length;

        for (int i = 0; i < length - 1; i++)
            for (int j = 0; j < length - i - 1; j++)
                if (unsorted[j].compareTo(unsorted[j + 1]) > 0)
                    swap(j, j + 1, unsorted);
    }

    /**
     * Interchanges the values between two objects in an array.
     *
     * @param index1 the index of the first object in the array.
     * @param index2 the index of the second object in the array.
     * @param array  the array that contains the objects.
     */
    private static <T extends Comparable<T>> void swap(int index1, int index2, T... array) {
        T value = array[index1];
        array[index1] = array[index2];
        array[index2] = value;
    }
}
