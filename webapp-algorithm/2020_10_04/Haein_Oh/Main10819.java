//https://www.acmicpc.net/problem/10819

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10819 {
    public static int N, answer, arr[], count[];
    public static boolean vtd[];

    public static int sum() {
        int result = 0;
        for(int i = 0; i < N-1; i++) {
            result += Math.abs(arr[count[i]] - arr[count[i+1]]);
        }
        return result;
    }

    public static void solve(int idx, int cnt) {
        if(cnt == N) {
            int res = sum();
            if(answer <= res) {
                answer = res;
            }
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!vtd[i]) {
             count[cnt] = i;
             vtd[i] = true;
             solve(i+1, cnt+1);
             vtd[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken().trim());
        arr = new int[N];
        count = new int[N];
        vtd = new boolean[N];
        st = new StringTokenizer(bf.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        answer = -987654321;
        solve(0, 0);
        System.out.println(answer);
    }
}
