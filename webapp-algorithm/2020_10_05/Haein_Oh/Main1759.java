//https://www.acmicpc.net/problem/1759

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1759 {
    public static int L, C, vowel;
    public static boolean res;
    public static String arr[];
    public static boolean check(String str) {
        res = false;
        vowel = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' ||
               str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                vowel++;
            }
        }
        if(vowel >= 1 && (L-vowel) >= 2) return true;
        return false;
    }
    public static void solve(int idx, int cnt, String ans) {
        if(cnt == L) {
            if(check(ans)) {
                System.out.println(ans);
            }
            return;
        }

        for(int i = idx; i < C; i++) {
            solve(i+1, cnt+1, ans+arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = bf.readLine().split(" ");
        Arrays.sort(arr);
        solve(0, 0, "");
    }
}
