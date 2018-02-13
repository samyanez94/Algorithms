package Search;

/**
 * Binary search is a search algorithm that finds the position of a target value within a sorted
 * array. Binary search compares the target value to the middle element of the array; if they are
 * unequal, the half in which the target cannot lie is eliminated and the search continues on the
 * remaining half until it is successful.
 *
 * Average case = O(log n) Worst case = O(log n) Best case = O(1)
 *
 * Reference: https://en.wikipedia.org/wiki/Binary_search_algorithm
 *
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public class BinarySearch {

    /**
     * Searches through an array of Comparable objects an returns the first instance of the target
     * being searched using a Binary search algorithm.
     *
     * @param target the value being searched
     * @param list   the array of Comparable objects to be searched
     */
    public static <T extends Comparable<T>> boolean search(T target, T... list) {
        return search(target, 0, list.length - 1, list);
    }

    /**
     * Iterates through an array of Comparable objects and returns true if the value being searched
     * for is in the array.
     *
     * @param target the value being searched
     * @param min    the lower index of the sub-array being searched.
     * @param max    the upper index of the sub-array being searched.
     * @param list   the array of Comparable objects to be searched
     * @return true if the value is found. False otherwise.
     */
    private static <T extends Comparable<T>> boolean search(T target, int min, int max, T... list) {
        if (min > max)
            return false;

        int middle = (min + max) / 2;

        if (list[middle].compareTo(target) == 0)
            return true;

        else if (list[middle].compareTo(target) < 0)
            return search(target, middle + 1, max, list);

        else
            return search(target, min, middle - 1, list);
    }

}