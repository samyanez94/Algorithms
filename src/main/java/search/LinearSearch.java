package search;

/**
 * A straightforward way to perform a search in which we start at the beginning of the list and
 * compare each value in turn to the target element. Eventually, we will either find the target or
 * come to the end of the list and conclude that the target does not exist in the group.
 *
 * Average case = O(n) Worst case = O(n) Best case = O(1)
 *
 * Reference: https://en.wikipedia.org/wiki/Linear_search
 *
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public class LinearSearch {

    /**
     * Iterates through an array of Comparable objects and returns true if the element is in the
     * list.
     *
     * @param target the value being searched.
     * @param list   the array of Comparable objects to be searched.
     * @return true if the target is found. False otherwise.
     */
    public static <T> boolean search(T target, T... list) {
        for (T element : list) {
            if (element.equals(target))
                return true;
        }
        return false;
    }

}
