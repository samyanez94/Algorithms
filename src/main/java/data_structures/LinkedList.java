package data_structures;

import data_structures.exceptions.ElementNotFoundException;
import data_structures.exceptions.EmptyCollectionException;
import data_structures.interfaces.List;

/**
 * Linked implementation of a list. A list or sequence is an abstract data type that represents a
 * countable number of ordered values, where the same value may occur more than once.
 * <p>
 * Reference: Java Software Structures by Lewis and Chase
 *
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public class LinkedList<T> implements List<T> {

    private LinkedNode<T> front, rear;
    private int size;

    private int modCount;

    /**
     * Creates a new list.
     */
    public LinkedList() {
        size = 0;
        front = rear = null;
    }

    /**
     * Adds the element to the end of the list.
     *
     * @param element the element to be added to this list
     */
    public void add(T element) {
        LinkedNode<T> node = new LinkedNode<>(element);

        if (isEmpty())
            front = node;
        else
            rear.setNext(node);

        rear = node;
        size++;
        modCount++;
    }

    /**
     * Adds the element at the specified index shifting all other element in the list to the right.
     *
     * @param element the element to be added to this list
     * @param index   the position in the list to insert the element
     */
    public void add(T element, int index) {
        if (index > size)
            throw new ArrayIndexOutOfBoundsException(index);
        if (index == size)
            add(element);
        else {
            LinkedNode<T> node = new LinkedNode<>(element);

            LinkedNode<T> previous = new LinkedNode<>();
            LinkedNode<T> current = front;

            if (index == 0) {
                node.setNext(current);
                front = node;

            } else {

                for (int i = 0; i < index; i++) {
                    previous = current;
                    current = current.getNext();
                }

                previous.setNext(node);
                node.setNext(current);
            }
            size++;
            modCount++;
        }
    }

    /**
     * Removes and returns the first instance of the element from the list.
     *
     * @return the element to be removed
     */
    public T remove(T element) {
        if (isEmpty())
            throw new EmptyCollectionException("LinkedList");

        boolean found = false;
        LinkedNode<T> previous = new LinkedNode<>();
        LinkedNode<T> current = front;

        while (current != null && !found)
            if (element.equals(current.getElement()))
                found = true;
            else {
                previous = current;
                current = current.getNext();
            }

        if (!found)
            throw new ElementNotFoundException("LinkedList");

        if (size() == 1) // only one element in the list
            front = rear = null;
        else if (current.equals(front)) // target is at the head
            front = current.getNext();
        else if (current.equals(rear)) // target is at the tail
        {
            rear = previous;
            rear.setNext(null);
        } else // target is in the middle
            previous.setNext(current.getNext());

        size--;
        modCount++;

        return current.getElement();
    }

    /**
     * Removes and returns the element at a specific index.
     *
     * @param index the position in the list to remove the element from.
     * @return the removed element
     * @throws EmptyCollectionException       if the list is empty
     * @throws ArrayIndexOutOfBoundsException if the index is out of the bounds of the list
     */
    public T removeAt(int index) {
        if (isEmpty())
            throw new EmptyCollectionException("LinkedList");
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException(index);

        LinkedNode<T> current = front;
        LinkedNode<T> previous = new LinkedNode<>();

        size--;
        modCount++;

        if (index == 0) {
            front = front.getNext();
            return current.getElement();
        } else {
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.getNext();
            }
            if (index == size) {
                rear = previous;
                previous.setNext(null);
            } else
                previous.setNext(current.getNext());

            return current.getElement();
        }
    }

    /**
     * Returns a reference to the element at a specific position in this list.
     *
     * @param index index of the element to return
     * @return reference to the element in the list
     * @throws ArrayIndexOutOfBoundsException if the index is not within the bounds of the array
     */
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        else {
            LinkedNode<T> current = front;
            for (int i = 0; i < index; i++)
                current = current.getNext();
            return current.getElement();
        }
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param element the element to be added into the list.
     * @param index   the index of the element to be replace.
     */
    public void set(T element, int index) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        else {
            LinkedNode<T> current = front;
            for (int i = 0; i < index; i++)
                current = current.getNext();
            current.setElement(element);
        }
    }

    /**
     * Returns true if this list contains the element in the parameters.
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
        LinkedNode<T> current = front;
        int index = 0;
        while (current != null) {
            if (current.getElement().equals(target))
                return index;
            else {
                current = current.getNext();
                index++;
            }
        }
        return -1;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    public boolean isEmpty() {
        return (front == null);
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
     * Returns a string representation of this list.
     *
     * @return a string representation of this list
     */
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (LinkedNode<T> current = front; current != null; current = current.getNext())
            str.append(current.getElement()).append(" ");

        return str.toString();
    }
}
