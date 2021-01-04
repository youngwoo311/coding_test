//https://www.acmicpc.net/problem/2579
import java.util.Scanner;

public class Main2579 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[301];
        for(int i = 0; i <  N; i++) {
            arr[i] = sc.nextInt();
        }
        int dp[][] = new int[301][2];
            dp[0][0] = arr[0];
            dp[0][1] = arr[0];
            
            dp[1][0] = arr[1] + dp[0][0];
            dp[1][1] = arr[1];

        for(int i = 2; i < N; i++) {
            dp[i][0] = arr[i] + dp[i-1][1];
            dp[i][1] = arr[i] + Math.max(dp[i-2][0], dp[i-2][1]);
        }
        System.out.println(Math.max(dp[N-1][0], dp[N-1][1]));
    }
}