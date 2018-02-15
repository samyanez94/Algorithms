package data_structures.exceptions;

/**
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public class ChildNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Sets up this exception with an appropriate message.
     */
    public ChildNotFoundException(BinaryTreeDirection direction) {
        super("Node does not has a " + direction.directionString + " child.");
    }

    enum BinaryTreeDirection {
        LEFT("left"),
        RIGHT("right");

        String directionString;

        BinaryTreeDirection(String direction) {
            directionString = direction;
        }
    }
}
