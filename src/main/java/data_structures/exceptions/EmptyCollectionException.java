package data_structures.exceptions;

/**
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public class EmptyCollectionException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Sets up this exception with an appropriate message.
     *
     * @param collection the name of the collection
     */
    public EmptyCollectionException(String collection) {
        super("The " + collection + " is empty.");
    }
}
