package data_structures.interfaces;

/**
 * A stack is a linear collection whose elements are added and removed from the same end (LIFO).
 * Said in another way, the elements of a stack are removed in the reverse order of their placement
 * on it. In fact, one of the principal uses of a stack in computing is to reverse the order of
 * something.
 *
 * Reference: Java Software Structures by Lewis and Chase
 *
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public interface Stack<T> {

    /**
     * Adds an element to the top of the stack.
     *
     * @param element element to be pushed onto the stack
     */
    void push(T element);

    /**
     * Removes and returns the top element from the stack.
     *
     * @return the element removed from the stack
     */
    T pop();

    /**
     * Returns the top element of the stack without removing it.
     *
     * @return the element on top of the stack
     */
    T peek();

    /**
     * Returns true if the stack contains no elements.
     *
     * @return true if the stack is empty
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the stack.
     *
     * @return the number of elements in the stack
     */
    int size();

    /**
     * Returns a string representation of a stack.
     *
     * @return String representing the stack
     */
    String toString();
}
