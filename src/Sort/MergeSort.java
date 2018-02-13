package Sort;

/**
 * Merge sort is a divide and conquer algorithm that was invented by John Von Neumann in 1945. Merge
 * sort works by sorting an array, dividing it into two halves, sorting the two halves
 * (recursively), and then merging the results. One of merge sort’s most attractive properties is
 * that it guarantees to sort any array of N items in time proportional to N log N. Its prime
 * disadvantage is that it uses extra space proportional to N.
 *
 * Average case = O(nlogn) Worst case = O(nlogn) Best case = O(nlogn)
 *
 * Reference: Algorithms by Robert Sedgewick
 *
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public class MergeSort {

    /**
     * Sorts an array of objects that implement Comparable by using the Merge sort algorithm.
     *
     * @param unsorted the array to be sorted.
     */
    public static <T extends Comparable<T>> void sort(T... unsorted) {
        sort(0, unsorted.length - 1, unsorted);
    }

    /**
     * Sorts an array of objects that implement Comparable by using the Merge sort algorithm.
     *
     * @param unsorted the array to be sorted.
     * @param min      the lower index of the array to be sorted.
     * @param max      the upper index of the array to be sorted.
     */
    private static <T extends Comparable<T>> void sort(int min, int max, T... unsorted) {
        if (min < max) {
            int mid = (min + max) / 2;
            sort(min, mid, unsorted);
            sort(mid + 1, max, unsorted);
            merge(min, mid, max, unsorted);
        }
    }

    /**
     * Merges two sorted sub-array back into the single sorted sub-array.
     *
     * @param unsorted the array to be sorted.
     * @param first    the lower index of the first sub-array.
     * @param mid      the upper index of the first sub-array.
     * @param last     the upper index of the second sub-array.
     */
    private static <T extends Comparable<T>> void merge(int first, int mid, int last, T... unsorted) {
        T[] temp = ((T[]) (new Comparable[unsorted.length]));

        int index = first;
        int first1 = first, last1 = mid;
        int first2 = mid + 1, last2 = last;

        while (first1 <= last1 && first2 <= last2) {
            if (unsorted[first1].compareTo(unsorted[first2]) < 0) {
                temp[index] = unsorted[first1];
                first1++;
            } else {
                temp[index] = unsorted[first2];
                first2++;
            }
            index++;
        }

        while (first1 <= last1) {
            temp[index] = unsorted[first1];
            first1++;
            index++;
        }

        while (first2 <= last2) {
            temp[index] = unsorted[first2];
            first2++;
            index++;
        }

        for (index = first; index <= last; index++)
            unsorted[index] = temp[index];
    }
}