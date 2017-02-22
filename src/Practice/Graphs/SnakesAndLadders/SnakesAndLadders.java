package Practice.Graphs.SnakesAndLadders;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Gopala Akshintala on 22/02/17.
 */
public class SnakesAndLadders {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            int snakesOrLadders = scn.nextInt();
            Map<Integer, Integer> snakesOrLaddersMap = new HashMap<>();
            while (snakesOrLadders-- > 0) {
                snakesOrLaddersMap.put(scn.nextInt(), scn.nextInt());
            }
            System.out.println(minDiceThrows(snakesOrLaddersMap));
        }
    }

    private static int minDiceThrows(Map<Integer, Integer> snakesOrLaddersMap) {
        boolean[] visited = new boolean[31];
        Queue<Node> boardQueue = new LinkedList<>();
        boardQueue.add(new Node(1, 0));
        visited[1] = true;
        while (!boardQueue.isEmpty()) {
            Node square = boardQueue.poll();
            if (square.vertex == 30) {
                return square.diceThrows;
            }
            for (int v = 1; v <= 6 && square.vertex + v <= 30; v++) {
                Integer snakeOrLadder = snakesOrLaddersMap.get(square.vertex + v);
                int nextSquareVertex = (snakeOrLadder != null && snakeOrLadder <= 30) ? snakeOrLadder : square.vertex + v;
                if (!visited[nextSquareVertex]) {
                    boardQueue.add(new Node(nextSquareVertex, square.diceThrows + 1));
                    visited[nextSquareVertex] = true;
                }
            }
        }
        return -1;
    }
}

class Node {
    int vertex;
    int diceThrows;

    public Node(int vertex, int diceThrows) {
        this.vertex = vertex;
        this.diceThrows = diceThrows;
    }
}
