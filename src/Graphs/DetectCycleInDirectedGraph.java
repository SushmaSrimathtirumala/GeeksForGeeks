package Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by gakshintala on 3/28/16.
 */
public class DetectCycleInDirectedGraph {

    static boolean[] visited; // visited - used to prevent running into nodes that are already visited
    static boolean[] hasCycle; // hasCycle - used to nodes that are hasCycle and they are set to false if all the nodes
    // going away from this are check for hasCycle and is clear without cycle
    static Graph g;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int vertexCount = scn.nextInt();
        int edgeCount = scn.nextInt();
        visited = new boolean[vertexCount+1];
        hasCycle = new boolean[vertexCount+1];
        
        g = readGraph(scn, vertexCount, edgeCount);
        for (int i = 1; i <= vertexCount; i++) {
            if (!visited[i] && checkCycle(i))
                System.out.println("Cycle Detected!!!");
        }
        System.out.println("No Cycle");
    }

    private static boolean checkCycle(int i) {
        visited[i] = true;
        hasCycle[i] = true; // We are starting to check for hasCycle
        for (int neighbour : g.getAllOutgoingVertices(i)) {
            if (!visited[neighbour] && checkCycle(neighbour)) return true;
            // If above check is skipped due to visited, we still have record of hasCycle and we shall check as below.
            if (hasCycle[neighbour]) return true;
        }
        hasCycle[i] = false; // This node is clear, doesn't cause any cycle due to its outgoing nodes;
        return false; // No cycle here
    }

    private static Graph readGraph(Scanner scn, int vertexCount, int edgeCount) {
        Graph graph = new Graph(vertexCount);
        for (int i = 0; i < edgeCount; i++) {
            graph.addEdge(scn.nextInt(), scn.nextInt());
        }
        return graph;
    }
}

class Graph {
    List<Integer>[] adj;
    Graph(int vertexCount) {
        adj = new LinkedList[vertexCount + 1];
        for (int i = 1; i <= vertexCount; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int a, int b) {
        adj[a].add(b);
    }

    public Iterable<Integer> getAllOutgoingVertices(int vertex) {
        return adj[vertex];
    }
}


