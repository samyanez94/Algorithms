package data_structures.exceptions;

/**
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public class ParentNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Sets up this exception with an appropriate message.
     */
    public ParentNotFoundException() {
        super("Node does not has a parent node.");
    }
}
