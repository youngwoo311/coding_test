//https://www.acmicpc.net/problem/117267
// bottom-up
import java.util.Scanner;

public class Main11726 {
	public static int N, dp[];
	
	public static int solve() {
		dp = new int[1001];
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i <= N; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%10007;
		}
		return dp[N];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		System.out.println(solve());
	}
}
