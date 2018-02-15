package data_structures;

import data_structures.exceptions.EmptyCollectionException;
import data_structures.interfaces.Queue;

/**
 * An array implementation of a circular queue. A queue is a linear collection whose elements are
 * added on one end and removed from the other. Therefore, we say that queue elements are processed
 * in a first in, first out (FIFO) manner. Elements are removed from a queue in the same order in
 * which they are placed on the queue.
 *
 * Queues have a wide variety of application within computing. Whereas the principle purpose of a
 * stack is to reverse order, the principle purpose of a queue is to preserve order.
 *
 * Reference: Java Software Structures by Lewis and Chase
 *
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public class ArrayQueue<T> implements Queue<T> {

    private final static int DEFAULT_CAPACITY = 100;

    private T[] queue;
    private int count, front, rear;

    /**
     * Creates a new queue using the default capacity.
     */
    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates an new queue with a size specified in the parameters.
     *
     * @param initialCapacity the initial size of the array
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int initialCapacity) {
        queue = (T[]) (new Object[initialCapacity]);
        count = front = rear = 0;
    }

    /**
     * Creates a new array to store the contents of this queue with twice the capacity of the old
     * one.
     */
    @SuppressWarnings("unchecked")
    private void expandCapacity() {
        T[] larger = (T[]) (new Object[queue.length * 2]);

        for (int scan = 0; scan < count; scan++) {
            larger[scan] = queue[front];
            front = (front + 1) % queue.length;
        }

        front = 0;
        rear = count;
        queue = larger;
    }

    /**
     * Adds one element to the rear of this queue.
     *
     * @param element the element to be added to the rear of the queue
     */
    public void enqueue(T element) {
        if (size() == queue.length)
            expandCapacity();

        queue[rear] = element;
        rear = (rear + 1) % queue.length;

        count++;
    }

    /**
     * Removes and returns the element at the front of this queue.
     *
     * @return the element at the front of the queue
     * @throws EmptyCollectionException if the queue is empty
     */
    public T dequeue() {
        if (isEmpty())
            throw new EmptyCollectionException("queue");

        T result = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;

        count--;

        return result;
    }

    /**
     * Returns without removing the element at the front of this queue.
     *
     * @return the first element in the queue
     * @throws EmptyCollectionException if the queue is empty
     */
    public T first() {
        if (isEmpty())
            throw new EmptyCollectionException("Queue");

        return queue[front];
    }

    /**
     * Returns true if this queue contains no elements.
     *
     * @return true if this queue is empty
     */
    public boolean isEmpty() {
        return (count == 0);
    }

    /**
     * Returns the number of elements in this queue.
     *
     * @return the integer representation of the size of the queue
     */
    public int size() {
        return count;
    }

    /**
     * Returns a string representation of a queue.
     *
     * @return String representing the queue
     */
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (int i = rear - 1; i >= front; i--) {
            str.append(queue[i % queue.length]).append(" ");
        }

        return str.toString();
    }
}
