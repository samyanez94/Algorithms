package data_structures;

import data_structures.exceptions.EmptyCollectionException;
import data_structures.interfaces.Stack;

/**
 * A linked list implementation of an stack. A stack is a linear collection whose elements are added
 * and removed from the same end (LIFO). Said in another way, the elements of a stack are removed in
 * the reverse order of their placement on it. In fact, one of the principal uses of a stack in
 * computing is to reverse the order of something.
 *
 * Reference: Java Software Structures by Lewis and Chase
 *
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public class LinkedStack<T> implements Stack<T> {

    private LinkedNode<T> top;
    private int count;

    /**
     * Creates an empty stack.
     */
    public LinkedStack() {
        count = 0;
        top = null;
    }

    /**
     * Adds an element to the top of the stack.
     *
     * @param element element to be pushed on stack
     */
    public void push(T element) {
        LinkedNode<T> temp = new LinkedNode<T>(element);

        temp.setNext(top);
        top = temp;
        count++;
    }

    /**
     * Removes the element at the top of the stack and returns a reference to it.
     *
     * @return element from top of stack
     * @throws EmptyCollectionException if the stack is empty
     */
    public T pop() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException("Stack");

        T temp = top.getElement();
        top = top.getNext();
        count--;

        return temp;
    }

    /**
     * Returns a reference to the element at the top of the stack. The element is not removed from
     * the stack.
     *
     * @return element on top of stack
     * @throws EmptyCollectionException if the stack is empty
     */
    public T peek() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException("Stack");

        return top.getElement();
    }

    /**
     * Returns true if the stack is empty and false otherwise.
     *
     * @return true if stack is empty
     */
    public boolean isEmpty() {
        return (count == 0);
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return number of elements in the stack
     */
    public int size() {
        return count;
    }

    /**
     * Returns a string representation of a stack.
     *
     * @return String representing the stack
     */
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (LinkedNode<T> current = top; current != null; current = current.getNext())
            str.append(current.getElement().toString()).append(" ");

        return str.toString();
    }
}
