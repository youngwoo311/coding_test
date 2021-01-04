//https://www.acmicpc.net/problem/2638

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2638 {
    public static int N, M, answer, arr[][];
    public static int dx[] = {-1, 0, 1 ,0};
    public static int dy[] = {0, -1, 0, 1};
    public static boolean vtd[][];
    public static Queue<int[]> q, f;

    public static boolean isMelting() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 1) return false;
            }
        }
        return true;
    }

    public static void melting() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == -1) arr[i][j] = 2;
            }
        }
        answer++; // hour++
    }

    public static void solve() {
        while(!q.isEmpty()) {
            int tmp[] = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            int count = 0;
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(arr[nx][ny] == 2) count++;
            }

            if(count >= 2) {
                arr[x][y] = -1;
            }
        }
    }

    public static void vtdInit() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                vtd[i][j] = false;
            }
        }
    }
    public static void init() {
        f.add(new int[] {0,0});
        arr[0][0] = 2;
        vtd[0][0] = true;

        while (!f.isEmpty()) {
            int tmp[] = f.poll();
            int x = tmp[0];
            int y = tmp[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if((arr[nx][ny] == 0 || arr[nx][ny] == 2) && !vtd[nx][ny]) {
                    arr[nx][ny] = 2;
                    vtd[nx][ny] = true;
                    f.add(new int[] {nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = 0;
        f = new LinkedList<int[]>(); // init (2)
        q = new LinkedList<int[]>();
        vtd = new boolean[N][M];
        while(true) {
            vtdInit();
            init();
            if(isMelting()) break; // melting check

            for(int i = 1; i < N-1; i++) { //edge x
                for(int j = 1; j < M-1; j++) {
                    if(arr[i][j] == 1) {
                        q.add(new int[] {i, j});
                    }
                }
            }
            solve();
            melting();
        }
        System.out.println(answer);
    }
}
