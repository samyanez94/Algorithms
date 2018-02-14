package sort;

/**
 * Quicksort is a divide-and-conquer method for sorting. It works by partitioning an array into two
 * sub-arrays, then sorting the sub-arrays independently.
 *
 * Average case = O(nlogn) Worst case = O(n^2) Best case = O(nlogn)
 *
 * Reference: CS50 Hardvard
 *
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public class QuickSort {

    /**
     * Sorts an array of objects that implement Comparable using the Quick sort algorithm.
     *
     * @param unsorted the array to be sorted.
     */
    public static <T extends Comparable<T>> void sort(T... unsorted) {
        sort(0, unsorted.length - 1, unsorted);
    }

    /**
     * Sorts an array of objects that implement Comparable by using the Quick sort algorithm.
     *
     * @param min      the lower index of the array to be sorted.
     * @param max      the upper index of the array to be sorted.
     * @param unsorted the array to be sorted.
     */
    private static <T extends Comparable<T>> void sort(int min, int max, T... unsorted) {
        if (max > min) {

            T pivot = unsorted[max];
            int wall = min;

            for (int i = min; i < max; i++) {
                if (unsorted[i].compareTo(pivot) <= 0)
                    swap(i, wall++, unsorted);
            }

            swap(max, wall, unsorted);
            sort(min, wall - 1, unsorted);
            sort(wall, max, unsorted);
        }
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
