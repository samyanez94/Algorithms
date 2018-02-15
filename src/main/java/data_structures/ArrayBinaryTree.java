package data_structures;

import data_structures.exceptions.EmptyCollectionException;
import data_structures.interfaces.BinaryTree;
import data_structures.exceptions.ElementNotFoundException;
import data_structures.exceptions.ParentNotFoundException;
import data_structures.exceptions.ChildNotFoundException;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Implements an array representation of a binary tree. A binary tree is a tree data structure in
 * which each node has at most two children, which are referred to as the left child and the right
 * child.
 *
 * Reference: https://en.wikipedia.org/wiki/Binary_tree
 *
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public class ArrayBinaryTree<T extends Comparable<T>> implements BinaryTree<T> {

    private static final int DEFAULT_CAPACITY = 50;

    private T[] tree;
    private int count;

    protected int modCount;

    /**
     * Creates a new binary tree.
     */
    @SuppressWarnings("unchecked")
    public ArrayBinaryTree() {
        tree = (T[]) new Comparable[DEFAULT_CAPACITY];
        count = 0;
    }

    /**
     * Creates a new binary tree with the specified element as the root.
     *
     * @param element the element which will become the root of the new tree
     */
    @SuppressWarnings("unchecked")
    public ArrayBinaryTree(T element) {
        tree = (T[]) new Comparable[DEFAULT_CAPACITY];
        tree[0] = element;
        count = 1;
    }

    /**
     * Doubles the capacity of the tree when full.
     */
    protected void expandCapacity() {
        tree = Arrays.copyOf(tree, tree.length * 2);
    }

    /**
     * Protected method that returns the index of the parent of an element in the tree.
     *
     * @param Childindex index of the child element in the tree
     * @return index of the parent element
     */
    protected int getParentIndex(int Childindex) {
        return (Childindex - 1) / 2;
    }

    /**
     * Returns the parent element of a child in the tree.
     *
     * @param child the child element in the tree
     * @return the parent of the child node
     * @throws ElementNotFoundException if the child is not in the tree
     * @throws ParentNotFoundException  if the node does not has a child
     */
    public T getParent(T child) {
        return null;
    }

    /**
     * Returns the left child of a node in the tree.
     *
     * @param parent the parent element in the tree
     * @return the left child of the parent node
     * @throws ElementNotFoundException if the parent is not in the tree
     * @throws ChildNotFoundException   if the node does not has a left child
     */
    public T getLeftChild(T parent) {
        return null;
    }

    /**
     * Returns the right child of a node in the tree.
     *
     * @param parent the parent element in the tree
     * @return the right child of the parent node
     * @throws ElementNotFoundException if the parent is not in the tree
     * @throws ChildNotFoundException   if the node does not has a right child
     */
    public T getRightChild(T parent) {
        return null;
    }

    /**
     * Returns the root of the tree.
     *
     * @return the element at the root of the tree
     * @throws EmptyCollectionException if the tree is empty
     */
    public T getRoot() {
        if (isEmpty())
            throw new EmptyCollectionException("ArrayBinaryTree");

        return tree[0];
    }

    /**
     * Returns true if the tree contains an element that matches the specified element and false
     * otherwise.
     *
     * @param element the element being sought in the tree
     * @return true if the tree contains the target element
     */
    public boolean contains(T element) {
        if (find(element) == null)
            return false;
        else
            return true;
    }

    /**
     * Returns a reference to the specified target element if it is found in this binary tree.
     * Throws a ElementNotFoundException if the specified target element is not found in the binary
     * tree.
     *
     * @param target the element being sought in the tree
     * @return true if the element is in the tree
     * @throws ElementNotFoundException if the element is not in the tree
     */
    private T find(T target) throws ElementNotFoundException {
        T temp = null;
        boolean found = false;

        for (int i = 0; i < tree.length && !found; i++)
            if (tree[i] != null)
                if (target.equals(tree[i])) {
                    found = true;
                    temp = tree[i];
                }

        if (!found)
            throw new ElementNotFoundException("ArrayBinaryTree");

        return temp;
    }

    /**
     * Returns the number of elements in the tree.
     *
     * @return an integer representing of number of elements in the tree
     */
    public int size() {
        return count;
    }

    /**
     * Returns true if this tree contains no elements.
     *
     * @return true if this tree contains no elements
     */
    public boolean isEmpty() {
        return (count == 0);
    }

    /**
     * Returns an iterator over the elements of this tree.
     *
     * @return an iterator over the elements of this binary tree
     */
    public Iterator<T> iterator() {
        return null;
    }

    /**
     * Returns an iterator that represents an inorder traversal on this binary tree.
     *
     * @return an iterator over the elements of this binary tree
     */
    public Iterator<T> iteratorInOrder() {
        return null;
    }

    /**
     * Returns an iterator that represents a preorder traversal on this binary tree.
     *
     * @return an iterator over the elements of this binary tree
     */
    public Iterator<T> iteratorPreOrder() {
        return null;
    }

    /**
     * Returns an iterator that represents a postorder traversal on this binary tree.
     *
     * @return an iterator over the elements of this binary tree
     */
    public Iterator<T> iteratorPostOrder() {
        return null;
    }
}
