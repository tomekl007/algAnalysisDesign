package ch5graphs;

/**
 * @author Tomasz Lelek
 * @since 2014-04-16
 */
public class EdgeNode {
    public int adjencyInfo;
    public int weight;

    @Override
    public String toString() {
        return "EdgeNode{" +
                "adjencyInfo=" + adjencyInfo +
                ", weight=" + weight +
                ", next=" + next +
                '}';
    }

    public EdgeNode next;
}
