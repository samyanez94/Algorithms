package data_structures;

import data_structures.exceptions.EmptyCollectionException;
import data_structures.interfaces.Stack;

import java.util.Arrays;

/**
 * An array implementation of a stack. A stack is a linear collection whose elements are added and
 * removed from the same end (LIFO). Said in another way, the elements of a stack are removed in the
 * reverse order of their placement on it. In fact, one of the principal uses of a stack in
 * computing is to reverse the order of something.
 *
 * Reference: Java Software Structures by Lewis and Chase
 *
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public class ArrayStack<T> implements Stack<T> {

    private final static int DEFAULT_CAPACITY = 100;

    private T[] stack;
    private int top;


    /**
     * Creates an empty stack using the default capacity.
     */
    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates an new stack with a size specified in the parameters.
     *
     * @param initialCapacity the initial size of the array
     */
    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity) {
        stack = (T[]) (new Object[initialCapacity]);
        top = 0;
    }

    /**
     * Creates a new array to store the contents of the stack with twice the capacity of the old
     * one.
     */
    private void expandCapacity() {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

    /**
     * Adds an element to the top of the stack.
     *
     * @param element element to be pushed onto the stack
     */
    public void push(T element) {
        if (size() == stack.length)
            expandCapacity();

        stack[top++] = element;
    }

    /**
     * Removes and returns the top element from the stack.
     *
     * @return the element removed from the stack
     */
    public T pop() {
        if (isEmpty())
            throw new EmptyCollectionException("Stack");

        return stack[--top];
    }

    /**
     * Returns the top element of the stack without removing it.
     *
     * @return the element on top of the stack
     */
    public T peek() {
        if (isEmpty())
            throw new EmptyCollectionException("Stack");

        return stack[top - 1];
    }

    /**
     * Returns true if the stack contains no elements.
     *
     * @return true if the stack is empty
     */
    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return the number of elements in the stack
     */
    public int size() {
        return top;
    }

    /**
     * Returns a string representation of the stack.
     *
     * @return String representing the stack
     */
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (int i = top - 1; i >= 0; i--) {
            str.append(stack[i].toString());
            str.append(" ");
        }

        return str.toString();
    }
}
