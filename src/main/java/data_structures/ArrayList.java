package data_structures;

import data_structures.exceptions.EmptyCollectionException;
import data_structures.interfaces.List;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;


/**
 * Resizable array implementation of a list. A list or sequence is an abstract data type that
 * represents a countable number of ordered values, where the same value may occur more than once.
 *
 * Reference: Java Software Structures by Lewis and Chase
 *
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public class ArrayList<T> implements List<T> {

    private final static int DEFAULT_CAPACITY = 10;

    private T[] list;
    private int size;

    private int modCount;

    /**
     * Creates a new list using the default capacity.
     */
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates a new list with a size specified in the parameters.
     *
     * @param initialCapacity the integer value of the size of the array list.
     */
    @SuppressWarnings("unchecked")
    public ArrayList(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        list = (T[]) (new Object[initialCapacity]);
        size = 0;
    }

    /**
     * Creates a new array to store the contents of the list with twice the capacity of the old
     * one.
     */
    private void expandCapacity() {
        list = Arrays.copyOf(list, list.length * 2);
    }

    /**
     * Adds the element to the end of the list.
     *
     * @param element the element to be added to the list
     */
    public void add(T element) {
        add(element, size);
    }

    /**
     * Adds the element at the specified index shifting all other subsequent elements in the list to
     * the right.
     *
     * @param element the element to be added to this list
     * @param index   the position in the list to insert the element
     */
    public void add(T element, int index) throws ArrayIndexOutOfBoundsException {
        if (index > size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        if (size >= list.length)
            expandCapacity();
        if (index == size)
            list[size] = element;
        else {
            System.arraycopy(list, index, list, index + 1, size - index);
            list[index] = element;
        }
        size++;
        modCount++;
    }

    /**
     * Removes and returns the first instance of the element from the list.
     *
     * @return the element to be removed
     */
    public T remove(T element) {
        return removeAt(indexOf(element));
    }

    /**
     * Removes and returns the element at a specific index.
     *
     * @param index the position in the list to remove the element from.
     * @return the removed element
     */
    public T removeAt(int index) throws EmptyCollectionException, ArrayIndexOutOfBoundsException {
        if (isEmpty())
            throw new EmptyCollectionException("list");
        if (index > size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);

        T result = get(index);
        System.arraycopy(list, index + 1, list, index, size - index - 1);

        modCount++;
        list[size--] = null;

        return result;
    }

    /**
     * Returns a reference to the element at a specific position in the list.
     *
     * @param index index of the element to return
     * @return reference to the element in the list
     * @throws ArrayIndexOutOfBoundsException if the index is not within the bounds of the array
     */
    public T get(int index) throws ArrayIndexOutOfBoundsException {
        if (index > size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        else
            return list[index];
    }

    /**
     * Replaces the element at a specific position in the list with a new element.
     *
     * @param element the element to be added into the list.
     * @param index   the index of the element to be replace.
     */
    public void set(T element, int index) {
        if (index > size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        list[index] = element;
    }

    /**
     * Returns true if the list contains the element in the parameters.
     *
     * @param target the element that the list is searched for
     * @return true if the target is in the list, false if otherwise
     */
    public boolean contains(T target) {
        return indexOf(target) >= 0;
    }


    /**
     * Returns the index of the element in the list.
     *
     * @param target the element that the list will be searched for
     * @return the index of the element in the array or -1 if the element is not found
     */
    private int indexOf(T target) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(target))
                return i;
        }
        return -1;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the integer representation of number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of this list
     */
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (T element : list)
            str.append(element).append(" ");

        return str.toString();
    }

    /**
     * Returns an iterator for the elements in this list.
     *
     * @return an iterator over the elements in this list
     */
    public Iterator<T> iterator() {
        return new ArrayListIterator(modCount);
    }

    /**
     * ArrayListIterator iterates over the elements of an ArrayList.
     */
    private class ArrayListIterator implements Iterator<T> {
        private int iteratorModCount;
        private int next;

        /**
         * Sets up this iterator using the specified modCount.
         *
         * @param modCount the current modification count for the ArrayList
         */
        ArrayListIterator(int modCount) {
            iteratorModCount = modCount;
            next = 0;
        }

        /**
         * Returns true if this iterator has at least one more element to deliver in the iteration.
         *
         * @return true if this iterator has at least one more element to deliver in the iteration
         * @throws ConcurrentModificationException if the collection has changed while the iterator
         *                                         is in use
         */
        public boolean hasNext() throws ConcurrentModificationException {
            if (iteratorModCount != modCount)
                throw new ConcurrentModificationException();

            return (next < size);
        }

        /**
         * Returns the next element in the iteration. If there are no more elements in this
         * iteration, a NoSuchElementException is thrown.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException          if an element not found exception occurs
         * @throws ConcurrentModificationException if the collection has changed
         */
        public T next() throws ConcurrentModificationException {
            if (!hasNext())
                throw new NoSuchElementException();

            next++;

            return list[next - 1];
        }

        /**
         * The remove operation is not supported in this collection.
         *
         * @throws IllegalStateException if the method is called before the first next() call
         */
        public void remove() throws IllegalStateException {
            throw new UnsupportedOperationException();
        }
    }
}
