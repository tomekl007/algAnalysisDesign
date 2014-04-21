package ch7_combinatorialHeuristics;

/**
 * @author Tomasz Lelek
 * @since 2014-04-20
 */
@FunctionalInterface
public interface TriConsumer<T, U, W> {
    void accept(T t, U u, W w);
}
