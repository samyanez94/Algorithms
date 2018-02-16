package data_structures;

import data_structures.exceptions.EmptyCollectionException;
import data_structures.exceptions.ElementNotFoundException;
import data_structures.exceptions.ChildNotFoundException;
import data_structures.interfaces.BinaryTree;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implements an linked representation of a binary tree. A binary tree is a tree data structure in
 * which each node has at most two children, which are referred to as the left child and the right
 * child.
 *
 * Reference: https://en.wikipedia.org/wiki/Binary_tree
 *
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public class LinkedBinaryTree<T> implements BinaryTree<T> {

    private BinaryTreeNode<T> root;
    private int modCount;

    /**
     * Creates a new binary tree.
     */
    public LinkedBinaryTree() {
        root = null;
    }

    /**
     * Creates a binary tree with the specified element as its root.
     *
     * @param element the element that will become the root of the binary tree
     */
    public LinkedBinaryTree(T element) {
        root = new BinaryTreeNode<>(element);
    }

    /**
     * Creates a binary tree with the specified element as its root and the given trees as its left
     * child and right child
     *
     * @param element the element that will become the root of the binary tree
     * @param left    the left subtree of this tree
     * @param right   the right subtree of this tree
     */
    public LinkedBinaryTree(T element, LinkedBinaryTree<T> left, LinkedBinaryTree<T> right) {
        root = new BinaryTreeNode<>(element);
        root.setLeft(left.root);
        root.setRight(right.root);
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
        BinaryTreeNode<T> parentNode = findNode(parent, root);

        if (parentNode == null)
            throw new ElementNotFoundException("Binary Tree.");

        BinaryTreeNode<T> childNode = parentNode.getLeft();

        if (childNode == null)
            throw new ChildNotFoundException(ChildNotFoundException.BinaryTreeDirection.LEFT);

        return childNode.getElement();

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
        BinaryTreeNode<T> parentNode = findNode(parent, root);

        if (parentNode == null)
            throw new ElementNotFoundException("Binary Tree.");

        BinaryTreeNode<T> childNode = parentNode.getRight();

        if (childNode == null)
            throw new ChildNotFoundException(ChildNotFoundException.BinaryTreeDirection.RIGHT);

        return childNode.getElement();
    }

    /**
     * Returns the root of the tree.
     *
     * @return a reference to the specified node
     * @throws EmptyCollectionException if the tree is empty
     */
    public T getRoot() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException("LinkedBinaryTree");

        return getRootNode().getElement();
    }

    /**
     * Returns a reference to the node at the root.
     *
     * @return a reference to the specified node
     */
    protected BinaryTreeNode<T> getRootNode() {
        return root;
    }

    /**
     * Returns true if the tree contains an element that matches the specified element and false
     * otherwise.
     *
     * @param element the element being sought in the tree
     * @return true if the tree contains the target element
     */
    public boolean contains(T element) {
        if (findNode(element, root) == null)
            return false;
        else
            return true;
    }

    /**
     * Returns a reference to the specified target element if it is found in this binary tree.
     *
     * @param target  the element being sought in this tree
     * @param current the node to begin searching from
     * @return the binaryTreeNode for the given target being sought or null if it was not found.
     */
    private BinaryTreeNode<T> findNode(T target, BinaryTreeNode<T> current) {
        if (current == null)
            return null;

        if (current.getElement().equals(target))
            return current;

        BinaryTreeNode<T> temp = findNode(target, current.getLeft());

        if (temp == null)
            temp = findNode(target, current.getRight());

        return temp;
    }

    /**
     * Returns the number of elements in the tree.
     *
     * @return an integer representing of number of elements in the tree
     */
    public int size() {
        return size(root);
    }

    /**
     * Returns the number of elements in the tree.
     *
     * @param node the root of the tree.
     * @return an integer representing of number of elements in the tree
     */
    private int size(BinaryTreeNode<T> node) {
        if (node == null)
            return 0;
        else
            return (size(node.getLeft()) + 1 + size(node.getRight()));
    }

    /**
     * Returns true if this tree contains no elements.
     *
     * @return true if this tree contains no elements
     */
    public boolean isEmpty() {
        return (root == null);
    }

    /**
     * Returns an iterator over the elements in this tree using the iteratorInOrder method
     *
     * @return an in order iterator over this binary tree
     */
    public Iterator<T> iterator() {
        return iteratorInOrder();
    }

    /**
     * Performs an inorder traversal on this binary tree by calling an overloaded, recursive inorder
     * method that starts with the root.
     *
     * @return a post order iterator over this tree
     */
    public Iterator<T> iteratorInOrder() {
        ArrayList<T> tempList = new ArrayList<>();
        inOrder(root, tempList);

        return new TreeIterator(tempList.iterator());
    }

    /**
     * Performs a recursive inorder traversal.
     *
     * @param node     the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    private void inOrder(BinaryTreeNode<T> node, ArrayList<T> tempList) {
        if (node != null) {
            inOrder(node.getLeft(), tempList);
            tempList.add(node.getElement());
            inOrder(node.getRight(), tempList);
        }
    }

    /**
     * Performs an preorder traversal on this binary tree by calling an overloaded, recursive
     * preorder method that starts with the root.
     *
     * @return a post order iterator over this tree
     */
    public Iterator<T> iteratorPreOrder() {
        ArrayList<T> tempList = new ArrayList<>();
        preOrder(root, tempList);

        return new TreeIterator(tempList.iterator());
    }

    /**
     * Performs a recursive preorder traversal.
     *
     * @param node     the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    private void preOrder(BinaryTreeNode<T> node, ArrayList<T> tempList) {
        if (node != null) {
            tempList.add(node.getElement());
            inOrder(node.getLeft(), tempList);
            inOrder(node.getRight(), tempList);
        }
    }

    /**
     * Performs an postorder traversal on this binary tree by calling an overloaded, recursive
     * postorder method that starts with the root.
     *
     * @return a post order iterator over this tree
     */
    public Iterator<T> iteratorPostOrder() {
        ArrayList<T> tempList = new ArrayList<>();
        postOrder(root, tempList);

        return new TreeIterator(tempList.iterator());
    }

    /**
     * Performs a recursive post order traversal.
     *
     * @param node     the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    private void postOrder(BinaryTreeNode<T> node, ArrayList<T> tempList) {
        if (node != null) {
            inOrder(node.getLeft(), tempList);
            inOrder(node.getRight(), tempList);
            tempList.add(node.getElement());
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
