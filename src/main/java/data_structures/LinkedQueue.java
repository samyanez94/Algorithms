package data_structures;

import data_structures.exceptions.EmptyCollectionException;
import data_structures.interfaces.Queue;

/**
 * A linked list implementation of a queue. Queues are linear collections whose elements are added
 * on one end and removed from the other. Therefore, we say that queue elements are processed in a
 * first in, first out (FIFO) manner. Elements are removed from a queue in the same order in which
 * they are placed on the queue.
 *
 * Queues have a wide variety of application within computing. Whereas the principle purpose of a
 * stack is to reverse order, the principle purpose of a queue is to preserve order.
 *
 * Reference: Java Software Structures by Lewis and Chase
 *
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public class LinkedQueue<T> implements Queue<T> {

    private LinkedNode<T> front, rear;
    private int count;

    /**
     * Creates an empty queue.
     */
    public LinkedQueue() {
        front = rear = null;
        count = 0;
    }

    /**
     * Adds the element to the rear of the queue.
     *
     * @param element the element to be added to the rear of the queue
     */
    public void enqueue(T element) {
        LinkedNode<T> node = new LinkedNode<T>(element);

        if (isEmpty())
            front = node;
        else
            rear.setNext(node);

        rear = node;
        count++;
    }

    /**
     * Removes the element at the head of this queue and returns a reference to it.
     *
     * @return the element at the head of this queue
     * @throws EmptyCollectionException if the queue is empty
     */
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException("Queue");

        T result = front.getElement();
        front = front.getNext();
        count--;

        if (isEmpty())
            rear = null;

        return result;
    }

    /**
     * Returns a reference to the element at the head of this queue. The element is not removed from
     * the queue.
     *
     * @return a reference to the first element in this queue
     * @throws EmptyCollectionException if the queue is empty
     */
    public T first() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException("Queue");

        return front.getElement();
    }

    /**
     * Returns true if this queue is empty and false otherwise.
     *
     * @return true if this queue is empty
     */
    public boolean isEmpty() {
        return (count == 0);
    }

    /**
     * Returns the number of elements currently in this queue.
     *
     * @return the number of elements in the queue
     */
    public int size() {
        return count;
    }

    /**
     * Returns a string representation of a stack.
     *
     * @return String representing the stack.
     */
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (LinkedNode<T> current = front; current != null; current = current.getNext())
            str.append(current.getElement()).append(" ");

        return str.reverse().toString();
    }
}
