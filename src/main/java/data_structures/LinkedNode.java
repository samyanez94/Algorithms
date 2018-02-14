package data_structures;

/**
 * Represents a single linked node in a linked list.
 *
 * Reference: Java Software Structures by Lewis and Chase
 *
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public class LinkedNode<T> {

    private T element;
    private LinkedNode<T> next;

    /**
     * Creates an empty node.
     */
    public LinkedNode() {
        next = null;
        element = null;
    }

    /**
     * Creates a node that stores the specified element.
     *
     * @param element element to be stored
     */
    public LinkedNode(T element) {
        next = null;
        this.element = element;
    }

    /**
     * Returns the element stored in this node.
     *
     * @return element stored at the node
     */
    public T getElement() {
        return element;
    }

    /**
     * Sets the element stored in this node.
     *
     * @param elem element to be stored at this node
     */
    public void setElement(T elem) {
        element = elem;
    }

    /**
     * Returns the node that follows this one.
     *
     * @return reference to next node
     */
    public LinkedNode<T> getNext() {
        return next;
    }

    /**
     * Sets the node that follows this one.
     *
     * @param node node to follow this one
     */
    public void setNext(LinkedNode<T> node) {
        next = node;
    }
}
