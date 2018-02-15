package data_structures.exceptions;

/**
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public class ElementNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Sets up this exception with an appropriate message.
     *
     * @param collection the name of the collection
     */
    public ElementNotFoundException(String collection) {
        super("The target element is not in this " + collection);
    }
}