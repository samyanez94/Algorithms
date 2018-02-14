package data_structures.interfaces;

/**
 * A queue is a linear collection whose elements are added on one end and removed from the other.
 * Therefore, we say that queue elements are processed in a first in, first out (FIFO) manner.
 * Elements are removed from a queue in the same order in which they are placed on the queue.
 *
 * Queues have a wide variety of application within computing. Whereas the principle purpose of a
 * stack is to reverse order, the principle purpose of a queue is to preserve order.
 *
 * Reference: Java Software Structures by Lewis and Chase
 *
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public interface Queue<T> {

    /**
     * Adds one element to the rear of this queue.
     *
     * @param element the element to be added to the rear of the queue
     */
    void enqueue(T element);

    /**
     * Removes and returns the element at the front of this queue.
     *
     * @return the element at the front of the queue
     */
    T dequeue();

    /**
     * Returns without removing the element at the front of this queue.
     *
     * @return the first element in the queue
     */
    T first();

    /**
     * Returns true if this queue contains no elements.
     *
     * @return true if this queue is empty
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in this queue.
     *
     * @return the integer representation of the size of the queue
     */
    int size();

    /**
     * Returns a string representation of a queue.
     *
     * @return String representing the queue
     */
    String toString();
}