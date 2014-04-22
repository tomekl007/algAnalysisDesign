package ch8_dynamicProgramming;

/**
 * @author Tomasz Lelek
 * @since 2014-04-22
 */
public class BinomialCoefficient {

    public static final int MAX = 10;

    public double countBinomialCoefficient(int n, int m) {

        long bc[][] = new long[MAX][MAX];
        for (int i = 0; i <= n; i++) bc[i][0] = 1;
        for (int j = 0; j <= n; j++) bc[j][j] = 1;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j < i; j++)
                bc[i][j] = bc[i - 1][j - 1] + bc[i - 1][j];
        return (bc[n][m]);
    }
}
