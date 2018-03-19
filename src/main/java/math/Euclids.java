package math;

/**
 * In mathematics, the Euclidean algorithm, or Euclid's algorithm, is an
 * efficient method for computing the greatest common divisor (GCD) of two
 * numbers, the largest number that divides both of them without leaving a
 * remainder. It is named after the ancient Greek mathematician Euclid, who
 * first described it in Euclid's Elements (c. 300 BC).
 * <p>
 * Average Case = O(n^2)
 * <p>
 * Reference: https://en.wikipedia.org/wiki/Euclidean_algorithm
 *
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public class Euclids {

    public static int gdc(int a, int b) {
        if (b == 0)
            return a;
        else
            return gdc(b, a % b);
    }

}
