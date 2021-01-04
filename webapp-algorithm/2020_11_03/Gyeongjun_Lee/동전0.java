package BackJoon;

import java.util.Scanner;

//[백준-그리디알고리즘] 동전0
public class 동전0 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] coin = new int[n];
        for(int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }

        int ans = 0;

        int i = n-1;
        while(k > 0) {
            int tmp = k / coin[i];
            k -= tmp * coin[i--];
            ans += tmp;
        }

        sc.close();
        System.out.println(ans);

    }
}
