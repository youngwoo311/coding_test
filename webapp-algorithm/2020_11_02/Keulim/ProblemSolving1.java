/*
 * https://www.acmicpc.net/problem/17070
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class ProblemSolving1 {
    public static int N, count;
    public static int[][] map;
    public static int[] dx = {0, 1, 1};
    public static int[] dy = {1, 0, 1};

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            N = parseInt(br.readLine());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = parseInt(st.nextToken());
                }
            }
            count = 0;
            map[0][1] = 1;
            dfs( 0, 1, 0);
            System.out.println(count);
        }
    }

    public static void dfs(int x, int y, int status) {
        if (x == N - 1 && y == N - 1) {
            count++;
            return;
        }
        for(int k=0; k<3; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(status + k == 1) continue;
            if (nx >= N || ny >= N || map[nx][ny] == 1) continue;
            if (k == 2)
                if (map[nx][ny - 1] == 1 || map[nx - 1][ny] == 1) continue;
            dfs(nx, ny, k);
        }
    }
}
