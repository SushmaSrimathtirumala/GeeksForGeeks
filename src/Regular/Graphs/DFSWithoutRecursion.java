package Regular.Graphs;

import DsAndUtils.DiGraph;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by gakshintala on 4/19/16.
 */
public class DFSWithoutRecursion {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int vertexCount = scn.nextInt();
        int edgeCount = scn.nextInt();

        DiGraph g = readGraph(scn, vertexCount, edgeCount);
        System.out.println("Normal DFS: ");
        dfsIterative(g);

        System.out.println();
        boolean[] visited = new boolean[vertexCount + 1];
        System.out.println("Regular.BackTracking DFS: ");
        dfsRecursive(g, 1, visited);
    }

    private static void dfsRecursive(DiGraph g, int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for (int neighbour : g.getAllOutgoingVertices(vertex)) {
            if (!visited[neighbour]) {
                dfsRecursive(g, neighbour, visited);
            }
        }
    }

    private static void dfsIterative(DiGraph g) {
        Stack<Integer> stk = new Stack();
        int vertexCount = g.getVertexCount();
        boolean[] visited = new boolean[vertexCount + 1];
        stk.add(1);
        while (!stk.isEmpty()) {
            int vertex = stk.pop();
            visited[vertex] = true;
            System.out.print(vertex + " ");
            for (int neighbour : g.getAllOutgoingVertices(vertex)) {
                if (!visited[neighbour]) {
                    stk.add(neighbour);
                }
            }
        }
    }


    private static DiGraph readGraph(Scanner scn, int vertexCount, int edgeCount) {
        DiGraph DiGraph = new DiGraph(vertexCount);
        for (int i = 0; i < edgeCount; i++) {
            DiGraph.addEdge(scn.nextInt(), scn.nextInt());
        }
        return DiGraph;
    }
}

