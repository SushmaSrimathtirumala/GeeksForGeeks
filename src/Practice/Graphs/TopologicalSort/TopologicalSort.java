package Practice.Graphs.TopologicalSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by gakshintala on 1/10/16.
 */
// NOT TESTED, refer the one in Hackerrank
public class TopologicalSort {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int testCases = scn.nextInt();
        while (testCases-- > 0) {
            int edgeCount = scn.nextInt();
            int vertexCount = scn.nextInt();
            Digraph_TS graph = new Digraph_TS(vertexCount);
            while (edgeCount-- > 0) {
                graph.addEdge(scn.nextInt(), scn.nextInt());
            }

            Arrays.stream(dfs(vertexCount, graph)).forEach(val -> System.out.print(val + " "));
        }
    }

    private static int[] dfs(int vertexCount, Digraph_TS graph) {
        boolean[] visited = new boolean[vertexCount];
        List<Integer> reversePostOrder = new ArrayList<>();

        for (int i = 0; i < vertexCount; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited, reversePostOrder);
            }
        }
        return reversePostOrder.stream().mapToInt(i -> i).toArray();
    }


    private static void dfs(Digraph_TS graph, int vertex, boolean[] visited, List<Integer> reversePostOrder) {
        visited[vertex] = true;

        for (int adj : graph.getConnectingNodes(vertex)) {
            if (!visited[adj]) {
                dfs(graph, adj, visited, reversePostOrder);
            }
        }
        reversePostOrder.add(vertex);
    }
}


class Digraph_TS {
    private int n;
    private List<Integer>[] adj;

    Digraph_TS(int n) {
        this.n = n;
        this.adj = new List[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public List<Integer> getConnectingNodes(int source) {
        return adj[source];
    }
}

