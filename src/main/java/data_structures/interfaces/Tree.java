package data_structures.interfaces;

import java.util.Iterator;

/**
 * A tree is a widely data structure that simulates a hierarchical tree structure, with a root value
 * and subtrees of children with a parent node, represented as a set of linked nodes.
 *
 * Reference: https://en.wikipedia.org/wiki/Tree_(data_structure)
 *
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public interface Tree<T> {

    /**
     * Returns the root of the tree.
     *
     * @return the element at the root of the tree
     */
    T getRoot();

    /**
     * Returns true if the tree contains an element that matches the specified element and false
     * otherwise.
     *
     * @param element the element being sought in the tree
     * @return true if the tree contains the target element
     */
    boolean contains(T element);

    /**
     * Returns the number of elements in the tree.
     *
     * @return an integer representing of number of elements in the tree
     */
    int size();

    /**
     * Returns true if this tree contains no elements.
     *
     * @return true if this tree contains no elements
     */
    boolean isEmpty();

    /**
     * Returns the string representation of this binary tree.
     *
     * @return a string representation of the binary tree
     */
    String toString();

    /**
     * Returns an iterator over the elements of this tree.
     *
     * @return an iterator over the elements of this binary tree
     */
    Iterator<T> iterator();

    /**
     * Returns an iterator that represents an inorder traversal on this binary tree.
     *
     * @return an iterator over the elements of this binary tree
     */
    Iterator<T> iteratorInOrder();

    /**
     * Returns an iterator that represents a preorder traversal on this binary tree.
     *
     * @return an iterator over the elements of this binary tree
     */
    Iterator<T> iteratorPreOrder();

    /**
     * Returns an iterator that represents a postorder traversal on this binary tree.
     *
     * @return an iterator over the elements of this binary tree
     */
    Iterator<T> iteratorPostOrder();
}
