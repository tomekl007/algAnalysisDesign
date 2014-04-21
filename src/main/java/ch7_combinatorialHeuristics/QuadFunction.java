package ch7_combinatorialHeuristics;

/**
 * @author Tomasz Lelek
 * @since 2014-04-20
 */
@FunctionalInterface
public interface QuadFunction<T,U,V,W,R> {
    R accept(T t, U u, V v, W w);
}
