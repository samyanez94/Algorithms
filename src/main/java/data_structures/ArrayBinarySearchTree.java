package data_structures;

import java.util.Iterator;

import data_structures.exceptions.ElementNotFoundException;
import data_structures.exceptions.EmptyCollectionException;

/**
 * Implements an array representation of a binary search tree. A binary search tree is a binary tree
 * with the added property that, for each node, the left child is less than the parent, which is
 * less than or equal to the right child.
 *
 * Reference: Java Software Structures by Lewis and Chase
 *
 * @author Dr. Lewis Chase
 */

public class ArrayBinarySearchTree<T extends Comparable<T>> extends ArrayBinaryTree<T> {

    private int height;
    private int maxIndex;

    /**
     * Creates a new binary search tree.
     */
    public ArrayBinarySearchTree() {
        super();
        height = 0;
        maxIndex = -1;
    }

    /**
     * Creates a binary search tree with specified element as the root.
     *
     * @param element the element that will be at the root of the new binary search tree
     */
    public ArrayBinarySearchTree(T element) {
        super(element);
        height = 0;
        maxIndex = 0;
    }

    /**
     * Adds the specified object to this binary search tree in the appropriate position according to
     * its key value. Note that equal elements are added to the right. Also note that the index of
     * the left child of the current index can be found by doubling the current index and adding 1.
     * Finding the index of the right child can be calculated by doubling the current index and
     * adding 2.
     *
     * @param element the element to be added to the search tree
     */
    public void insert(T element) {
        if (tree.length < maxIndex * 2 + 3)
            expandCapacity();
        
        if (isEmpty()) {
            tree[0] = element;
            maxIndex = 0;
        } else {
            boolean added = false;
            int currentIndex = 0;

            while (!added) {
                if (element.compareTo((tree[currentIndex])) < 0) {
                    // go left
                    if (tree[currentIndex * 2 + 1] == null) {
                        tree[currentIndex * 2 + 1] = element;
                        added = true;
                        if (currentIndex * 2 + 1 > maxIndex)
                            maxIndex = currentIndex * 2 + 1;
                    } else
                        currentIndex = currentIndex * 2 + 1;
                } else {
                    // go right
                    if (tree[currentIndex * 2 + 2] == null) {
                        tree[currentIndex * 2 + 2] = element;
                        added = true;
                        if (currentIndex * 2 + 2 > maxIndex)
                            maxIndex = currentIndex * 2 + 2;
                    } else
                        currentIndex = currentIndex * 2 + 2;
                }
            }
        }

        height = (int) (Math.log(maxIndex + 1) / Math.log(2)) + 1;
        count++;
    }

    /**
     * Removes the first element that matches the specified target element from this binary search
     * tree and returns a reference to it. Throws an ElementNotFoundException if the specified
     * target element is not found in the binary search tree.
     *
     * @param targetElement the element to be removed from the tree
     * @return a reference to the removed element
     * @throws ElementNotFoundException if an element not found exception occurs
     */
    public void remove(T targetElement) throws ElementNotFoundException {
        boolean found = false;

        for (int i = 0; (i <= maxIndex) && !found; i++) {
            if ((tree[i] != null) && targetElement.equals(tree[i])) {
                found = true;
                replace(i);
                count--;
            }
        }

        if (!found)
            throw new ElementNotFoundException("element not found in the binary tree");

        int temp = maxIndex;
        maxIndex = -1;
        for (int i = 0; i <= temp; i++)
            if (tree[i] != null)
                maxIndex = i;

        height = (int) (Math.log(maxIndex + 1) / Math.log(2)) + 1;
    }

    /**
     * Returns a copy of the array containing the values in the tree.
     *
     * @return a copy of the array containing the values in the tree
     */
    @SuppressWarnings("unchecked")
    public T[] getArray() {
        T[] temp;
        if (size() == 0) {
            temp = (T[]) new Object[0];
            return temp;
        }

        temp = (T[]) new Object[tree.length];
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null)
                temp[i] = tree[i];
            else
                temp[i] = null;
        }
        return temp;
    }

    /**
     * Returns the maximum index value in this tree.
     *
     * @return the integer representation of the maximum value in this tree
     */
    public int getMaxIndex() {
        return maxIndex;
    }

    /**
     * Returns the height of this tree.
     *
     * @return the integer height of the tree
     */
    public int getHeight() {
        return height;
    }

    /**
     * Removes elements that match the specified target element from this binary search tree. Throws
     * an ElementNotFoundException if the sepcified target element is not found in the binary search
     * tree.
     *
     * @param targetElement the element to be removed
     * @throws ElementNotFoundException if an element not found exception occurs
     */
    public void removeAllOccurrences(T targetElement) throws ElementNotFoundException {
        remove(targetElement);

        try {
            while (contains((T) targetElement))
                remove(targetElement);
        } catch (Exception ElementNotFoundException) {
            //TODO: Implement catch block
        }
    }

    /**
     * Removes the node with the least value from this binary search tree and returns a reference to
     * its element. Throws an EmptyBinarySearchTreeException if the binary search tree is empty.
     *
     * @return a reference to the node with the least value in this tree
     * @throws EmptyCollectionException if an empty collection exception occurs
     */
    public T removeMin() throws EmptyCollectionException {
        T result = null;

        if (isEmpty())
            throw new EmptyCollectionException("binary search tree");
        else {
            int currentIndex = 1;
            int previousIndex = 0;
            while (tree[currentIndex] != null && currentIndex <= tree.length)

            {
                previousIndex = currentIndex;
                currentIndex = currentIndex * 2 + 1;
            }
            result = tree[previousIndex];
            replace(previousIndex);
        }

        count--;

        return result;
    }

    /**
     * Removes the node with the highest value from this binary search tree and returns a reference
     * to its element. Throws an EmptyBinarySearchTreeException if the binary search tree is empty.
     *
     * @return the node with highest value in this tree
     * @throws EmptyCollectionException if an empty collections exception occurs
     */
    public T removeMax() throws EmptyCollectionException {
        T result = null;

        if (isEmpty())
            throw new EmptyCollectionException("binary tree");
        else {
            int currentIndex = 2;
            int previousIndex = 0;
            while (tree[currentIndex] != null && currentIndex <= maxIndex) {
                previousIndex = currentIndex;
                currentIndex = currentIndex * 2 + 2;
            } // while
            result = tree[previousIndex];
            replace(previousIndex);
        } // else

        count--;

        return result;
    }

    /**
     * Returns the element with the least value in this binary search tree. It does not remove the
     * node from the binary search tree. Throws an EmptyBinarySearchTreeException if the binary
     * search tree is empty.
     *
     * @return the element with the least value in this binary search tree
     * @throws EmptyCollectionException if an empty collection exception occurs
     */
    public T findMin() throws EmptyCollectionException {
        T result = null;

        if (isEmpty())
            throw new EmptyCollectionException("binary tree");
        else {
            int currentIndex = 0;
            while ((currentIndex * 2 + 1 <= maxIndex) && (tree[currentIndex * 2 + 1] != null))
                currentIndex = currentIndex * 2 + 1;
            result = tree[currentIndex];
        }
        return result;
    }

    /**
     * Returns the element with the highest value in this binary search tree. It does not remove the
     * node from the binary search tree. Throws an EmptyBinarySearchTreeException if the binary
     * search tree is empty.
     *
     * @return the element with the highest value in this binary search tree
     * @throws EmptyCollectionException if an empty collection exception occurs
     */

    public T findMax() throws EmptyCollectionException {
        T result = null;

        if (isEmpty())
            throw new EmptyCollectionException("binary tree");
        else {
            int currentIndex = 0;
            while ((currentIndex * 2 + 2 <= maxIndex) && (tree[currentIndex * 2 + 2] != null))
                currentIndex = currentIndex * 2 + 2;
            result = tree[currentIndex];
        }
        return result;
    }

    private void replace(int targetIndex) {
        int currentIndex, oldIndex, newIndex;
        ArrayList<Integer> oldList = new ArrayList<>();
        ArrayList<Integer> newList = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        Iterator<Integer> oldIt, newIt;

        // if target node has no children
        if ((targetIndex * 2 + 1 >= tree.length) || (targetIndex * 2 + 2 >= tree.length))
            tree[targetIndex] = null;

            // if target node has no children
        else if ((tree[targetIndex * 2 + 1] == null) && (tree[targetIndex * 2 + 2] == null))
            tree[targetIndex] = null;

            // if target node only has a left child
        else if ((tree[targetIndex * 2 + 1] != null) && (tree[targetIndex * 2 + 2] == null)) {

            // fill newlist with indices of nodes that will replace
            // the corresponding indices in oldlist

            // fill newlist
            currentIndex = (targetIndex * 2) + 1;
            tempList.add(currentIndex);
            while (!tempList.isEmpty()) {
                currentIndex = tempList.removeAt(0);
                newList.add(currentIndex);
                if ((currentIndex * 2 + 2) <= (Math.pow(2, height) - 2)) {
                    tempList.add(currentIndex * 2 + 1);
                    tempList.add(currentIndex * 2 + 2);
                }
            }

            // fill oldlist
            currentIndex = targetIndex;
            tempList.add(currentIndex);
            while (!tempList.isEmpty()) {
                currentIndex = tempList.removeAt(0);
                oldList.add(currentIndex);
                if ((currentIndex * 2 + 2) <= (Math.pow(2, height) - 2)) {
                    tempList.add(currentIndex * 2 + 1);
                    tempList.add(currentIndex * 2 + 2);
                }
            }

            // do replacement
            oldIt = oldList.iterator();
            newIt = newList.iterator();
            while (newIt.hasNext()) {
                oldIndex = oldIt.next();
                newIndex = newIt.next();
                tree[oldIndex] = tree[newIndex];
                tree[newIndex] = null;
            }
        }

        // if target node only has a right child
        else if ((tree[targetIndex * 2 + 1] == null) && (tree[targetIndex * 2 + 2] != null)) {

            // fill newlist with indices of nodes that will replace
            // the corresponding indices in oldlist

            // fill newlist
            currentIndex = targetIndex * 2 + 2;
            tempList.add(currentIndex);
            while (!tempList.isEmpty()) {
                currentIndex = (tempList.removeAt(0));
                newList.add(currentIndex);
                if ((currentIndex * 2 + 2) <= (Math.pow(2, height) - 2)) {
                    tempList.add(currentIndex * 2 + 1);
                    tempList.add(currentIndex * 2 + 2);
                }
            }

            // fill oldlist
            currentIndex = targetIndex;
            tempList.add(currentIndex);
            while (!tempList.isEmpty()) {
                currentIndex = (tempList.removeAt(0));
                oldList.add(currentIndex);
                if ((currentIndex * 2 + 2) <= (Math.pow(2, height) - 2)) {
                    tempList.add(currentIndex * 2 + 1);
                    tempList.add(currentIndex * 2 + 2);
                }
            }

            // do replacement
            oldIt = oldList.iterator();
            newIt = newList.iterator();
            while (newIt.hasNext()) {
                oldIndex = oldIt.next();
                newIndex = newIt.next();
                tree[oldIndex] = tree[newIndex];
                tree[newIndex] = null;
            }
        }

        // target node has two children
        else {
            currentIndex = targetIndex * 2 + 2;

            while (tree[currentIndex * 2 + 1] != null) {
                currentIndex = currentIndex * 2 + 1;
            }

            tree[targetIndex] = tree[currentIndex];

            // the index of the root of the subtree to be replaced
            int currentRoot = currentIndex;

            // if currentIndex has a right child
            if (tree[currentRoot * 2 + 2] != null) {

                // fill newlist with indices of nodes that will replace
                // the corresponding indices in oldlist

                // fill newlist
                currentIndex = currentRoot * 2 + 2;
                tempList.add(currentIndex);
                while (!tempList.isEmpty()) {
                    currentIndex = (tempList.removeAt(0));
                    newList.add(currentIndex);
                    if ((currentIndex * 2 + 2) <= (Math.pow(2, height) - 2)) {
                        tempList.add(currentIndex * 2 + 1);
                        tempList.add(currentIndex * 2 + 2);
                    }
                }

                // fill oldlist
                currentIndex = currentRoot;
                tempList.add(currentIndex);
                while (!tempList.isEmpty()) {
                    currentIndex = (tempList.removeAt(0));
                    oldList.add(currentIndex);
                    if ((currentIndex * 2 + 2) <= (Math.pow(2, height) - 2)) {
                        tempList.add(currentIndex * 2 + 1);
                        tempList.add(currentIndex * 2 + 2);
                    }
                }

                // do replacement
                oldIt = oldList.iterator();
                newIt = newList.iterator();
                while (newIt.hasNext()) {
                    oldIndex = oldIt.next();
                    newIndex = newIt.next();
                    tree[oldIndex] = tree[newIndex];
                    tree[newIndex] = null;
                }
            } else
                tree[currentRoot] = null;
        }

    }

    /**
     * Returns a string representation of the binary tree
     *
     * @return a string representation of the binary tree
     */
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i <= maxIndex; i++)
            if (tree[i] != null)
                result.append(tree[i]).append("\n");

        return result.toString();
    }

    /**
     * Returns the index of the specified target element if it is found in this binary tree. Throws
     * an ElementNotFoundException if the specified target element is not found in the binary tree.
     *
     * @param targetElement the element being sought in the tree
     * @return true if the element is in the tree
     * @throws ElementNotFoundException if an element not found exception occurs
     */
    private int findIndex(Comparable<T> targetElement, int n) throws ElementNotFoundException {
        int result = 0;

        if (n > tree.length)
            throw new ElementNotFoundException("binary search tree");
        if (tree[n] == null)
            throw new ElementNotFoundException("binary search tree");
        if (targetElement.compareTo(tree[n]) == 0)
            result = n;
        else if (targetElement.compareTo(tree[n]) > 0)
            result = findIndex(targetElement, (2 * (n + 1)));
        else
            result = findIndex(targetElement, (2 * n + 1));

        return result;
    }

}