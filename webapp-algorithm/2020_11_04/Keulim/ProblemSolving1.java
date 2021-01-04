/**
 * https://www.acmicpc.net/problem/1167
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class ProblemSolving1 {
    private static class Node {
        int value, cost;
        public Node(int value, int cost) {
            this.value = value;
            this.cost = cost;
        }
    }

    private static int v, answer;
    private static List<Node>[] tree;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            v = parseInt(br.readLine());
            tree = (List<Node>[]) new ArrayList[v + 1];
            dist = new int[v + 1];
            for (int i = 1; i <= v; i++) {
                tree[i] = new ArrayList<>();
            }
            for (int i = 0; i < v; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int node = parseInt(st.nextToken());
                while (true) {
                    int other = parseInt(st.nextToken());
                    if (other == -1) break;
                    int cost = parseInt(st.nextToken());
                    tree[node].add(new Node(other, cost));
                }
            }

            bfs(1);
            int farthest = 1;
            for (int i = 2; i <= v; i++) {
                if (dist[i] > dist[farthest]) {
                    farthest = i;
                }
            }

            Arrays.fill(dist, 0);
            bfs(farthest);
            int answer = dist[1];
            for (int i = 2; i <= v; i++) {
                if (dist[i] > answer) {
                    answer = dist[i];
                }
            }

            System.out.println(answer - 1);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        dist[start] = 1;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (Node node : tree[x]) {
                if (dist[node.value] != 0) continue;
                dist[node.value] = dist[x] + node.cost;
                queue.offer(node.value);
            }
        }
    }
}
