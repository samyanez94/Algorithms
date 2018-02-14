package sort;

/**
 * The algorithm that people often use to sort bridge hands is to consider the cards one at a time,
 * inserting each into its proper place among those already considered. In insertion sort the items
 * to the left of the current index are in sorted order during the sort, but they are not in their
 * final position, as they may have to be moved to make room for smaller items encountered later.
 * The array is, however, fully sorted when the index reaches the right end.
 *
 * Average case = O(n^2) Worst case = O(n^2) Best case = O(n)
 *
 * Reference: Algorithms by Robert Sedgewick
 *
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public class InsertionSort {

    /**
     * Sorts an array of objects that implement Comparable using the Insertion sort algorithm.
     *
     * @param unsorted the array to be sorted.
     */
    public static <T extends Comparable<T>> void sort(T... unsorted) {
        for (int i = 1; i < unsorted.length; i++) {
            for (int j = i; j > 0; j--) {
                if (unsorted[j].compareTo(unsorted[j - 1]) < 0)
                    swap(j, j - 1, unsorted);
            }
        }
    }

    /**
     * Interchanges the values between two objects in an array.
     *
     * @param index1 the index of the first object in the array.
     * @param index2 the index of the second object in the array.
     * @param array  the array that contains the objects.
     */
    private static <T> void swap(int index1, int index2, T... array) {
        T value = array[index1];
        array[index1] = array[index2];
        array[index2] = value;
    }
}
