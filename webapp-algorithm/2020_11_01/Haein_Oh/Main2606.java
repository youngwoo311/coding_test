//https://www.acmicpc.net/problem/2606

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2606 {
    public static int N, K, count, arr[][];
    public static boolean vtd[];
    public static Queue<Integer> q;

    public static void solve() {
        while(!q.isEmpty()) {
            int num = q.poll();
            vtd[num] = true;
            for(int i = 0; i < N; i++) {
                if((arr[num][i] == 1 || arr[i][num] == 1) && !vtd[i]) {
                    q.add(i);
                    vtd[i] = true;
                    count++;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine().trim());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        vtd = new boolean[N];
        count = 0;
        q = new LinkedList<>();
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x-1][y-1] = 1;
        }
        q.add(new Integer(0));

        solve();
        System.out.println(count);
    }
}

