package ch2_alghoritmAnalysis;

/**
 * @author Tomasz Lelek
 * @since 2014-04-09
 */
public class DivideAndConquerExample {

    public static int power(int a, int n) {
        if (n == 0) return (1);
        int x = power(a, n / 2);
        if (isEven(n)) {
            return ((int) Math.pow(x, 2));
        } else {
            return (a * (int) Math.pow(x, 2));
        }
    }

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }
}
