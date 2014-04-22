package ch8_dynamicProgramming;

/**
 * @author Tomasz Lelek
 * @since 2014-04-22
 */
public class FibonacciUltimate implements Fibonacci {
    @Override
    public long fibonacci(int n) {
        long back2 = 0, back1 = 1;  /* last two values of f[n] */
        long next;              /* placeholder for sum */
        if (n == 0) return (0);
        for (int i = 2; i < n; i++) {
            next = back1 + back2;
            back2 = back1;
            back1 = next;
        }
        return (back1 + back2);
    }
}
