package ch8_dynamicProgramming.editdistance;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tomasz Lelek
 * @since 2014-04-30
 */
public class EditDistByRecursion {

    private static int stringCompare(char[] s, char[] t, int i, int j){
        Map<MatchSymbol, Integer> opt = new HashMap<>();
        final int[] lowest_cost = new int[1];/* lowest cost */



        if (i == 0) return (j * indel(' '));
        if (j == 0) return (i * indel(' '));
        opt.put(MatchSymbol.MATCH, stringCompare(s, t, i - 1, j - 1) + match(s[i], t[j]));
        opt.put(MatchSymbol.INSERT, stringCompare(s, t, i, j - 1) + indel(t[j]));
        opt.put(MatchSymbol.DELETE, stringCompare(s, t, i - 1, j) + indel(s[i]));
        lowest_cost[0] = opt.get(MatchSymbol.MATCH);

        opt.forEach((matchSymbol, integer) -> {
              if(opt.get(matchSymbol) < lowest_cost[0]){
                  lowest_cost[0] = opt.get(matchSymbol);
              }
        });
        return (lowest_cost[0]);
    }

    private static int indel(char c) {
        return 1;
    }

    private static int match(char s, char c) {
        if (s == c) return 0;
        return 1;
    }

    public static int stringCompare(String s, String t){
        return stringCompare(s.toCharArray(), t.toCharArray(), s.length(), t.length());
    }
}
