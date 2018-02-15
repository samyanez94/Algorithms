package data_structures;

/**
 * Represents a node in a binary tree.
 *
 * Reference: Java Software Structures by Lewis and Chase
 *
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public class BinaryTreeNode<T> {

    private T element;
    private BinaryTreeNode<T> left, right;

    /**
     * Creates a new binary tree node with the element in the parameters.
     *
     * @param element that will become a part of the new node
     */
    public BinaryTreeNode(T element) {
        this.element = element;
        left = null;
        right = null;
    }

    /**
     * Creates a new tree node with the specified data.
     *
     * @param element that will become a part of the new tree node
     * @param left    the tree that will be the left subtree of this node
     * @param right   the tree that will be the right subtree of this node
     */
    public BinaryTreeNode(T element, LinkedBinaryTree<T> left, LinkedBinaryTree<T> right) {
        this.element = element;
        if (left == null)
            this.left = null;
        else
            this.left = left.getRootNode();

        if (right == null)
            this.right = null;
        else
            this.right = right.getRootNode();
    }

    /**
     * Return the element at this node.
     *
     * @return the element stored at this node
     */
    public T getElement() {
        return element;
    }

    /**
     * Sets the element in this node.
     *
     * @param element the element to be set for the node.
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * Return the right child of this node.
     *
     * @return the right child of this node
     */
    public BinaryTreeNode<T> getRight() {
        return right;
    }

    /**
     * Sets the right child of this node.
     *
     * @param node the right child of this node
     */
    public void setRight(BinaryTreeNode<T> node) {
        right = node;
    }

    /**
     * Return the left child of this node.
     *
     * @return the left child of the node
     */
    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    /**
     * Sets the left child of this node.
     *
     * @param node the left child of this node
     */
    public void setLeft(BinaryTreeNode<T> node) {
        left = node;
    }
}
