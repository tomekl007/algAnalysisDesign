package ch5graphs.operations;

/**
 * @author Tomasz Lelek
 * @since 2014-04-18
 */
@FunctionalInterface
public interface TriFunction<T,U,V,R> {
    R accept(T t, U u, V v);
}
