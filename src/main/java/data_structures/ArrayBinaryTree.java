package data_structures;

import data_structures.exceptions.EmptyCollectionException;
import data_structures.exceptions.ElementNotFoundException;
import data_structures.exceptions.ChildNotFoundException;
import data_structures.interfaces.BinaryTree;


import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implements an array representation of a binary tree. A binary tree is a tree data structure in
 * which each node has at most two children, which are referred to as the left child and the right
 * child.
 *
 * Reference: https://en.wikipedia.org/wiki/Binary_tree
 *
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public class ArrayBinaryTree<T> implements BinaryTree<T> {

    private static final int DEFAULT_CAPACITY = 50;

    private T[] tree;
    private int count;

    private int modCount;

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
     * Returns the left child of a node in the tree.
     *
     * @param parent the parent element in the tree
     * @return the left child of the parent node
     * @throws ElementNotFoundException if the parent is not in the tree
     * @throws ChildNotFoundException   if the node does not has a left child
     */
    public T getLeftChild(T parent) {
        if (!contains(parent))
            throw new ElementNotFoundException("Binary Tree");

        T leftChild = tree[getLeftChildIndex(find(parent))];

        if (leftChild == null)
            throw new ChildNotFoundException(ChildNotFoundException.BinaryTreeDirection.LEFT);

        return leftChild;
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
        if (!contains(parent))
            throw new ElementNotFoundException("Binary Tree");

        T rightChild = tree[getRightChildIndex(find(parent))];

        if (rightChild == null)
            throw new ChildNotFoundException(ChildNotFoundException.BinaryTreeDirection.RIGHT);

        return rightChild;
    }


    /**
     * Protected method that returns the index of the left child of an element in the tree.
     *
     * @param index index of the parent element in the tree
     * @return index of the left child
     */
    private int getLeftChildIndex(int index) {
        /* TODO:  Throw exception when index is out of bounds*/
        return 2 * index + 1;
    }

    /**
     * Protected method that returns the index of the right child of an element in the tree.
     *
     * @param index index of the parent element in the tree
     * @return index of the right child
     */
    private int getRightChildIndex(int index) {
        /* TODO:  Throw exception when index is out of bounds*/
        return 2 * index + 2;
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
        if (find(element) == -1)
            return false;
        else
            return true;
    }

    /**
     * Returns the position index of a target element if it is found in this binary tree. Throws a
     * ElementNotFoundException if the specified target element is not found in the binary tree.
     *
     * @param target the element being sought in the tree
     * @return index of a target element or -1 if not element was found
     */

    private int find(T target) {
        for (int i = 0; i < tree.length; i++)
            if (tree[i] != null && tree[i].equals(target))
                return i;

        return -1;
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
     * Returns a string representation of this binary tree showing the nodes in an inorder fashion.
     *
     * @return a string representation of the binary tree
     */
    public String toString() {
        ArrayList<T> list = new ArrayList<T>();
        inOrder(0, list);
        return list.toString();
    }

    /**
     * Returns an iterator over the elements of this binary tree using the iteratorInOrder method
     *
     * @return an iterator over the binary tree
     */
    public Iterator<T> iterator() {
        return this.iteratorInOrder();
    }

    /**
     * Performs an inorder traversal on this binary tree by calling an overloaded, recursive inorder
     * method that starts with the root.
     *
     * @return an iterator over the binary tree
     */
    public Iterator<T> iteratorInOrder() {
        ArrayList<T> tempList = new ArrayList<T>();
        inOrder(0, tempList);

        return new TreeIterator(tempList.iterator());
    }

    /**
     * Performs a recursive inorder traversal.
     *
     * @param node the index of the node used in the traversal
     * @param list the temporary list used in the traversal
     */
    private void inOrder(int node, ArrayList<T> list) {
        if (node < tree.length)
            if (tree[node] != null) {
                inOrder(node * 2 + 1, list);
                list.add(tree[node]);
                inOrder((node + 1) * 2, list);
            }
    }

    /**
     * Performs an preorder traversal on this binary tree by calling an overloaded, recursive
     * preorder method that starts with the root.
     *
     * @return an iterator over the binary tree
     */
    public Iterator<T> iteratorPreOrder() {
        ArrayList<T> list = new ArrayList<T>();
        preOrder(0, list);

        return new TreeIterator(list.iterator());
    }

    /**
     * Performs a recursive preorder traversal.
     *
     * @param node the index of the node used in the traversal
     * @param list the temporary list used in the traversal
     */
    private void preOrder(int node, ArrayList<T> list) {
        if (node < tree.length)
            if (tree[node] != null) {
                list.add(tree[node]);
                preOrder(node * 2 + 1, list);
                preOrder((node + 1) * 2, list);
            }
    }

    /**
     * Performs an postorder traversal on the binary tree by calling an overloaded, recursive
     * postorder method that starts with the root.
     *
     * @return an iterator over the binary tree
     */
    public Iterator<T> iteratorPostOrder() {
        ArrayList<T> list = new ArrayList<T>();
        postOrder(0, list);

        return new TreeIterator(list.iterator());
    }

    /**
     * Performs a recursive postorder traversal.
     *
     * @param node the index of the node used in the traversal
     * @param list the temporary list used in the traversal
     */
    private void postOrder(int node, ArrayList<T> list) {
        if (node < tree.length)
            if (tree[node] != null) {
                postOrder(node * 2 + 1, list);
                postOrder((node + 1) * 2, list);
                list.add(tree[node]);
            }
    }

    /**
     * Inner class to represent an iterator over the elements of this tree
     */
    private class TreeIterator implements Iterator<T> {
        private int expectedModCount;
        private Iterator<T> iter;

        /**
         * Sets up this iterator using the specified iterator.
         *
         * @param iter the list iterator created by a tree traversal
         */
        TreeIterator(Iterator<T> iter) {
            this.iter = iter;
            expectedModCount = modCount;
        }

        /**
         * Returns true if this iterator has at least one more element to deliver in the iteration.
         *
         * @return true if this iterator has at least one more element to deliver in the iteration
         * @throws ConcurrentModificationException if the collection has changed while the iterator
         *                                         is in use
         */
        public boolean hasNext() throws ConcurrentModificationException {
            if (!(modCount == expectedModCount))
                throw new ConcurrentModificationException();

            return (iter.hasNext());
        }

        /**
         * Returns the next element in the iteration. If there are no more elements in this
         * iteration, a NoSuchElementException is thrown.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iterator is empty
         */
        public T next() throws NoSuchElementException {
            if (hasNext())
                return (iter.next());
            else
                throw new NoSuchElementException();
        }

        /**
         * The remove operation is not supported.
         *
         * @throws UnsupportedOperationException if the remove operation is called
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
