package ch6_weightedGraphs;

/**
 * @author Tomasz Lelek
 * @since 2014-04-20
 */
@FunctionalInterface
public interface QuadConsumer<T, W, U, X> {
    void accept(T t, W w ,U u, X x);
}
