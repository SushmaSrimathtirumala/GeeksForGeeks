package Regular.Graphs;

import DsAndUtils.DiGraph;

import java.util.Scanner;

/**
 * Created by gakshintala on 3/28/16.
 */
public class DetectCycleInDirectedGraph {

    static boolean[] visited; // visited - used to prevent running into nodes that are already visited
    static boolean[] hasCycle; // hasCycle - used to nodes that are hasCycle and they are set to false if all the nodes
    // going away from this are check for hasCycle and is clear without cycle
    static DiGraph g;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int vertexCount = scn.nextInt();
        int edgeCount = scn.nextInt();
        visited = new boolean[vertexCount + 1];
        hasCycle = new boolean[vertexCount + 1];

        g = readGraph(scn, vertexCount, edgeCount);

        // Let us say first vertex with value '1' is on border, it won't start a cycle. So need to check paths starting 
        // from all vertices to see which one of them can cause a cycle.
        for (int i = 1; i <= vertexCount; i++) {
            if (!visited[i] && checkCycle(i)) {
                System.out.println("Cycle Detected!!!");
                return;
            }
        }
        System.out.println("No Cycle");
    }

    // This uses DFS
    private static boolean checkCycle(int i) {
        visited[i] = true;
        hasCycle[i] = true; // We are starting to check for hasCycle
        for (int neighbour : g.getAllOutgoingVertices(i)) {
            // If not visited, then send that node for checkCycle. If it passes to have cycle, return true;
            if (!visited[neighbour] && checkCycle(neighbour)) return true;
            // If above check is skipped due to visited, we still have record of hasCycle and we shall check as below.
            if (hasCycle[neighbour]) return true;
        }
        hasCycle[i] = false; // This node is clear, doesn't cause any cycle due to its outgoing nodes;
        return false; // No cycle here
    }

    private static DiGraph readGraph(Scanner scn, int vertexCount, int edgeCount) {
        DiGraph graph = new DiGraph(vertexCount);
        for (int i = 0; i < edgeCount; i++) {
            graph.addEdge(scn.nextInt(), scn.nextInt());
        }
        return graph;
    }
}

