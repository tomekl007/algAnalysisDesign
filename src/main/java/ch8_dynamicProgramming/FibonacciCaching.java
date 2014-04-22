package ch8_dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tomasz Lelek
 * @since 2014-04-22
 */
public class FibonacciCaching implements Fibonacci {


    private Map<Integer,Long> cache = new HashMap<>();

    private long fibCache(int n)
    {
      if(!cache.containsKey(n)){
          cache.put(n, fibCache(n-1) + fibCache(n - 2));
      }
      return cache.get(n);
    }

    @Override
    public long fibonacci(int n){
        cache.put(0, 0l);
        cache.put(1, 1l);
        return fibCache(n);

    }
}
