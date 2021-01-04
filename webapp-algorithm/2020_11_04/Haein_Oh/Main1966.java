//https://www.acmicpc.net/problem/1966
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main1966 {
	public static int N, M, answer;
	public static Integer arr[];
	public static Queue<int[]> q;
	
	public static void solve() {
		int idx = 0;
		
		loop:while(!q.isEmpty()) {
			int tmp[] = q.poll();
			int x = tmp[0];
			int y = tmp[1];
			if(arr[idx] == y) {
				idx++;
				if(x == M) {
					answer = idx;
					break loop;
				}
			} else {
				q.add(new int[] {x, y});
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int ts = 1; ts <= test; ts++) {
			answer = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			if(N == 1 && M == 0) {
				answer = 1;
				int x = sc.nextInt();
			}
			else {
				q = new LinkedList<int[]>();
				arr = new Integer[N];
				for(int i = 0; i < N; i++) {
					int x = sc.nextInt();
					arr[i] = x;
					q.add(new int[] {i, x});
				}
				Arrays.sort(arr, Collections.reverseOrder());
				solve();
			}
			System.out.println(answer);
		}
	}
}
