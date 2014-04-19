package ch6_weightedGraphs;

/**
 * @author Tomasz Lelek
 * @since 2014-04-19
 */
public class UnionFind {
    private SetUnion s;

    public UnionFind(int n) {
        s = new SetUnion();
        s.parent = new int[n];
        s.nrOfElementsInSubtree = new int[n];
        for (int i = 1; i <= n; i++) {
            s.parent[i] = i;
            s.nrOfElementsInSubtree[i] = 1;
        }
        s.nrOfElementsInSet = n;

    }

    int find(int x) {
        if (s.parent[x] == x) {
            return (x);
        } else {
            return (find(s.parent[x]));
        }
    }

    void unionsSets(int s1, int s2) {
        int r1, r2;                     /* roots of sets */
        r1 = find(s1);
        r2 = find(s2);
        if (r1 == r2) return;           /* already in same set */
        if (s.nrOfElementsInSubtree[r1] >= s.nrOfElementsInSubtree[r2]) {
            s.nrOfElementsInSubtree[r1] = s.nrOfElementsInSubtree[r1] + s.nrOfElementsInSubtree[r2];
            s.parent[r2] = r1;
        } else {
            s.nrOfElementsInSubtree[r2] = s.nrOfElementsInSubtree[r1] + s.nrOfElementsInSubtree[r2];
            s.parent[r1] = r2;
        }
    }

    boolean sameComponents(int s1, int s2)
    {
        return ( find(s1) == find(s2) );
    }

}
