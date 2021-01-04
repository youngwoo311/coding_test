//https://www.acmicpc.net/problem/2589

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2589 {
    public static int N, M, answer, arr[][];
    public static int dx[] = {-1, 0, 1, 0};
    public static int dy[] = {0, -1, 0, 1};
    public static boolean vtd[][];
    public static Queue<int[]> q;

    public static void init() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                vtd[i][j] = false;
            }
        }
    }

    public static void solve() {
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                int tmp[] = q.poll();
                int x = tmp[0];
                int y = tmp[1];
                int z = tmp[2];

                for(int i = 0; i < 4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if(arr[nx][ny] == 0 && !vtd[nx][ny]) {
                        vtd[nx][ny] = true;
                        q.add(new int[] {nx, ny, z+1});
                        answer = (answer < (z+1)) ? (z+1) : answer;
                    }
                }
                size--;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            String str = bf.readLine();
            for(int j = 0; j < M; j++) {
                char ch = str.charAt(j);
                if(ch == 'L') arr[i][j] = 0;
                else arr[i][j] = 1;
            }
        }
        answer = -987654321;
        q = new LinkedList<int[]>();
        vtd = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0) {
                    init();
                    vtd[i][j] = true;
                    q.add(new int[]{i, j, 0});
                    solve();
                }
            }
        }
        System.out.println(answer);
    }
}
