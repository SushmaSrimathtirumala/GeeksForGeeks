package Regular.Graphs;

import DsAndUtils.DiGraph;

import java.util.Scanner;

/**
 * Created by gakshintala on 3/28/16.
 * <p>
 * This can only calculate the lenght of first encountered Cycle.
 */
public class CountCycleLength {

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
            if (!visited[i]) {
                cycleNode cycleNode = checkCycle(i);
                if (cycleNode.nodeValue != -1) {
                    System.out.println("Cycle Detected at: " + cycleNode.nodeValue);
                    //int cycleLen = countCycleLength(cycleNode);
                    System.out.println("Cycle length: " + cycleNode.count);
                    //return;
                }
            }
        }
        System.out.println("No Cycle");
    }

    // This uses DFS
    private static cycleNode checkCycle(int i) {
        visited[i] = true;
        hasCycle[i] = true;
        for (int neighbour : g.getAllOutgoingVertices(i)) {
            if (!visited[neighbour]) {
                cycleNode result = checkCycle(neighbour);
                if (result.nodeValue == -1) {
                    hasCycle[i] = false;
                } else if (result.countIncrement) {
                    if (neighbour != result.nodeValue) {
                        result.count++;
                    } else {
                        result.countIncrement = false;
                    }
                }
                return result;
            }
            // If above check is skipped due to visited, we still have record of hasCycle and we shall check as below.
            if (hasCycle[neighbour]) return new cycleNode(neighbour, 1, true);
        }
        hasCycle[i] = false; // This node is clear, doesn't cause any cycle due to its outgoing nodes;
        return new cycleNode(-1, 0, false); // No cycle here
    }

    private static DiGraph readGraph(Scanner scn, int vertexCount, int edgeCount) {
        DiGraph DiGraph = new DiGraph(vertexCount);
        for (int i = 0; i < edgeCount; i++) {
            DiGraph.addEdge(scn.nextInt(), scn.nextInt());
        }
        return DiGraph;
    }
}

class cycleNode {
    int nodeValue;
    int count;
    boolean countIncrement;

    public cycleNode(int nodeValue, int count, boolean countIncrement) {
        this.nodeValue = nodeValue;
        this.count = count;
        this.countIncrement = countIncrement;
    }
}

