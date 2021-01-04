package BackJoon;

import java.util.Scanner;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2606
public class 바이러스 {
    
    private static int n;
    private static int[][] graph;
    private static boolean[] visited;
    private static String ans;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int line = sc.nextInt();

        graph = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i = 1; i < line + 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = graph[y][x] = 1;
        }

        DFS(1);
        StringTokenizer st = new StringTokenizer(ans);
        System.out.println(st.countTokens()-1);
    }

    public static void DFS(int start) {
        ans += start + " ";
        visited[start] = true;
        for(int i=1 ; i <= n; i++) {
            if(graph[start][i] == 1 && visited[i] == false) {
                DFS(i);
            }
        }
    }
}
