/*
 * https://www.acmicpc.net/problem/9205
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class ProblemSolving1 {

    private static final int MAX_MOVE = 20 * 50;
    private static Node[] graph;
    private static int[] visited;

    private static class Node {
        private int index;
        private int x;
        private int y;
        private List<Node> adjacent;

        Node(int index, int x, int y) {
            this.index = index;
            this.x = x;
            this.y = y;
            this.adjacent = new ArrayList<>();
        }

        void linkWith(Node other) {
            this.adjacent.add(other);
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            int testCase = parseInt(br.readLine());
            for (int t = 0; t < testCase; t++) {

                initGraph(br);

                boolean result = bfs();
                if (result) {
                    System.out.println("happy");
                } else {
                    System.out.println("sad");
                }
            }
        }
    }


    private static void initGraph(BufferedReader br) throws IOException {
        int marketCount = parseInt(br.readLine());
        int totalCount = 1 + marketCount + 1;

        graph = new Node[totalCount];
        visited = new int[totalCount];

        for (int i = 0; i < totalCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = parseInt(st.nextToken());
            int y = parseInt(st.nextToken());

            graph[i] = new Node(i, x, y);

            if (i == 0) {
                visited[i] = -1;
            } else if (i == totalCount - 1) {
                visited[i] = -2;
            } else {
                visited[i] = -3;
            }
        }

        for (int i = 0; i < totalCount - 1; i++) {
            Node src = graph[i];
            for (int j = 1; j < totalCount; j++) {
                if (i == j) continue;
                Node des = graph[j];
                if (Math.abs(src.x - des.x) + Math.abs(src.y - des.y) <= MAX_MOVE) {
                    src.linkWith(des);
                }
            }
        }
    }

    private static boolean bfs() {
        Queue<Integer> queue = new LinkedList<>();
        visited[0] = 1;
        queue.offer(0);
        while (!queue.isEmpty()) {
            int index = queue.poll();

            for (Node dest : graph[index].adjacent) {
                if (visited[dest.index] > 0) continue;

                if (visited[dest.index] == -2) {
                    return true;
                }

                visited[dest.index] = visited[index] + 1;
                queue.offer(dest.index);
            }
        }
        return false;
    }
}
