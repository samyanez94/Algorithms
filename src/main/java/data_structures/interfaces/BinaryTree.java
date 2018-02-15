package data_structures.interfaces;

import data_structures.exceptions.ElementNotFoundException;
import data_structures.exceptions.ParentNotFoundException;
import data_structures.exceptions.ChildNotFoundException;

/**
 * A binary tree is a tree data structure in which each node has at most two children, which are
 * referred to as the left child and the right child.
 *
 * Reference: https://en.wikipedia.org/wiki/Binary_tree
 *
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public interface BinaryTree<T> extends Tree<T> {

    /**
     * Returns the parent element of a child in the tree.
     *
     * @param child the child element in the tree
     * @return the parent of the child node
     * @throws ElementNotFoundException if the child is not in the tree
     * @throws ParentNotFoundException  if the node does not has a child
     */
    T getParent(T child);

    /**
     * Returns the left child of a node in the tree.
     *
     * @param parent the parent element in the tree
     * @return the left child of the parent node
     * @throws ElementNotFoundException if the parent is not in the tree
     * @throws ChildNotFoundException   if the node does not has a left child
     */
    T getLeftChild(T parent);

    /**
     * Returns the right child of a node in the tree.
     *
     * @param parent the parent element in the tree
     * @return the right child of the parent node
     * @throws ElementNotFoundException if the parent is not in the tree
     * @throws ChildNotFoundException   if the node does not has a right child
     */
    T getRightChild(T parent);

}
