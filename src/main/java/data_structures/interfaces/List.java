package data_structures.interfaces;

import java.util.Iterator;

/**
 * A list or sequence is an abstract data type that represents a countable number of ordered values,
 * where the same value may occur more than once.
 *
 * List defines the interface to a general list collection. Specific types of lists will implement
 * this interface to complete the set of necessary operations.
 *
 * Reference: Java Software Structures by Lewis and Chase
 *
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public interface List<T> {

    /**
     * Adds the element to the end of the list.
     *
     * @param element the element to be added to this list
     */
    void add(T element);

    /**
     * Removes and returns the element from the list.
     *
     * @return the element to be removed
     */
    T remove(T element);

    /**
     * Returns a reference to the element at a specific position in the list.
     *
     * @param index index of the element to return
     * @return reference to the element in the list
     * @throws ArrayIndexOutOfBoundsException if the index is not within the bounds of the array
     */
    T get(int index);

    /**
     * Returns true if this list contains the element in the parameters.
     *
     * @param target the element that the list is searched for
     * @return true if the target is in the list, false if otherwise
     */
    boolean contains(T target);

    /**
     * Returns the number of elements in the list.
     *
     * @return the integer representation of number of elements in this list
     */
    int size();

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    boolean isEmpty();

    /**
     * Returns a string representation of a queue.
     *
     * @return String representing the queue
     */
    String toString();

    /**
     * Returns an iterator for the elements in the list.
     *
     * @return an iterator over the elements in this list
     */
    Iterator<T> iterator();

}
