package ch5graphs.operations;

/**
 * @author Tomasz Lelek
 * @since 2014-04-18
 */
public class GraphHelper {


    public static void findPath(int start, int end, int[] parent){
        if ((start == end) || (end == -1))
            System.out.println(start);
        else {
            findPath(start, parent[end], parent);
            System.out.printf(" %d",end);
        }
    }
}
