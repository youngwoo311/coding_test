/**
 * https://www.acmicpc.net/problem/11725
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class ProblemSolving2 {
    private static List<Integer>[] tree;
    private static int[] parent;
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            int n = parseInt(br.readLine());
            tree = (List<Integer>[]) new ArrayList[n+1];
            for(int i=1; i<=n; i++) {
                tree[i] = new ArrayList<>();
            }
            parent = new int[n+1];
            for(int i=1; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = parseInt(st.nextToken());
                int y = parseInt(st.nextToken());
                tree[x].add(y);
                tree[y].add(x);
            }

            bfs();
            StringBuilder sb = new StringBuilder();
            for(int i=2; i<=n; i++) {
                sb.append(parent[i]).append("\n");
            }
            System.out.println(sb);
        }
    }

    private static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        parent[1] = -1;
        queue.offer(1);
        while(!queue.isEmpty()) {
            int x = queue.poll();
            for(int y : tree[x]) {
                if(parent[y] != 0) continue;
                parent[y] = x;
                queue.offer(y);
            }
        }
    }
}
