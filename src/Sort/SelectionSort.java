package Sort;

/**
 * One of the simplest sorting algorithms works as follows: First, find the smallest item in the
 * array and exchange it with the first entry. Then, find the next smallest item and exchange it
 * with the second entry. Continue in this way until the entire array is sorted. This method is
 * called selection sort because it works by repeatedly selecting the smallest remaining item.
 *
 * Average case = O(n^2) Worst case = O(n^2) Best case = O(n^2)
 *
 * Reference: Algorithms by Sedgewick, Robert
 *
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public class SelectionSort {

    /**
     * Sorts an array of objects that implement Comparable using the Selection algorithm.
     *
     * @param unsorted the array to be sorted.
     */
    public static <T extends Comparable<T>> void sort(T[] unsorted) {
        int length = unsorted.length;

        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++)
                if (unsorted[j].compareTo(unsorted[min]) < 0)
                    min = j;
            swap(i, min, unsorted);
        }
    }

    /**
     * Interchanges the values between two objects in an array.
     *
     * @param index1 the index of the first object in the array.
     * @param index2 the index of the second object in the array.
     * @param array  the array that contains the objects.
     */
    private static <T extends Comparable<T>> void swap(int index1, int index2, T[] array) {
        T value = array[index1];
        array[index1] = array[index2];
        array[index2] = value;
    }
}
