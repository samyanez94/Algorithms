package math;

/**
 * In mathematics, the Fibonacci numbers are the numbers in the following
 * integer sequence, called the Fibonacci sequence, and characterized by the
 * fact that every number after the first two is the sum of the two preceding
 * ones.
 * <p>
 * Average case for recursive method = O(2^n) Average case for dynamic method =
 * O(n)
 * <p>
 * Reference: https://en.wikipedia.org/wiki/Fibonacci_number
 *
 * @author Samuel Yanez <samuelyanez94@gmail.com>
 */

public class Fibonacci {

    /*
     * Recursive method that returns the nth fibonacci number.
     */
    public static long recursiveFibonacci(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        else
            return (recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2));
    }

    /*
     * Top down memoization approach where we break the prob­lem into
     * sub-problems, solve them as needed and store the solu­tion for future
     * use.
     */
    public static long dynamicTDFibonacci(int n) {

        long[] table = new long[n + 1];

        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        if (table[n] == 0)
            table[n] = dynamicTDFibonacci(n - 1) + dynamicTDFibonacci(n - 2);
        return table[n];
    }

    /*
     * A bottom-up approach were we solve the prob­lem with the small­est
     * pos­si­ble inputs and store it for future. As it cal­cu­lates for the
     * big­ger val­ues it uses the previous solu­tions.
     */
    public static long dynamicBUFibonacci(int n) {

        long[] table = new long[n + 1];

        table[0] = 0;
        table[1] = 1;

        for (int i = 2; i < n + 1; i++)
            table[i] = table[i - 1] + table[i - 2];

        return table[n];
    }
}
