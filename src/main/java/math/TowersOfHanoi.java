package math;

/**
 * The Towers of Hanoi is an old puzzle where you are given a set of three pegs
 * and n disks, with each disk a different size. Let's name the pegs A, B, and
 * C, and let's number the disks from 1, the smallest disk, to n, the largest
 * disk. At the outset, all n disks are on peg A, in order of decreasing size
 * from bottom to top, so that disk n is on the bottom and disk 1 is on the top.
 * The goal is to move all n disks from peg A to peg B.
 * <p>
 * There are 3 rules:
 * <p>
 * 1 - We can move only one disk at a time. 2 - We cannot place a larger disk on
 * top of a smaller disk. 3 - All disks must be on some peg except for the disk
 * in transit between pegs.
 * <p>
 * The solution consist on:
 * <p>
 * 1 - Recursively solve the subproblem of moving disks 1 through n - 1 from
 * whichever peg they start on to the spare peg.
 * <p>
 * 2 - Move disk n from the peg it starts on to the peg it's supposed to end up
 * on.
 * <p>
 * 3 - Recursively solve the subproblem of moving disks 1 through n -1 from the
 * spare peg to the peg they're supposed to end up on.
 * <p>
 * This approach takes O(2^n), where n is the number of disks.
 * <p>
 * Reference: Khan Academy
 *
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public class TowersOfHanoi {

    private int totalDisks;

    /**
     * Initializes the puzzle with a specific number of disk.
     *
     * @param n number of disk
     */
    public TowersOfHanoi(int n) {
        totalDisks = n;
    }

    /**
     * Solves the puzzles by moving the disk from peg 'A' to peg 'C'.
     */
    public void solve() {
        moveTower(totalDisks, 'A', 'C', 'B');
    }

    /**
     * Moves the disks from one tower to another by moving a subtower of n-1
     * disks out of the way, moving one disk, then moving the subtower back.
     * Base case of 1 disk.
     *
     * @param n       the number of disks to move
     * @param fromPeg the starting peg
     * @param toPeg   the ending peg
     * @param withPeg the spare peg
     */
    private void moveTower(int n, char fromPeg, char toPeg, char withPeg) {
        if (n == 1)
            moveDisk(fromPeg, toPeg);
        else {
            moveTower(n - 1, fromPeg, withPeg, toPeg);
            moveDisk(fromPeg, toPeg);
            moveTower(n - 1, withPeg, toPeg, fromPeg);
        }

    }

    /**
     * Prints the instruction to move one this from one peg to another.
     *
     * @param fromPeg the starting peg
     * @param toPeg   the ending peg
     */
    private void moveDisk(char fromPeg, char toPeg) {
        System.out.println("Moving disk from " + fromPeg + " to " + toPeg);
    }

}
