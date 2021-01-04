//https://www.acmicpc.net/problem/2644
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2644 {
	public static int N, M, num1, num2, count, arr[][];
	public static boolean vtd[], flag;
	public static Queue<Integer> q;
	
	public static void solve() {
		loop:while(!q.isEmpty()) {
			int size = q.size();
			while(size > 0) {
				int x = q.poll();
				
				for(int i = 0; i < N; i++) {
					if((arr[x][i] == 1 || arr[i][x] == 1) && !vtd[i]) {
						if(i == num2) {
							count++;
							flag = true;
							break loop;
						}
						q.add(i);
						vtd[i] = true;
					}
				}		
				size--;
			}
			count++;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		num1 = sc.nextInt()-1;
		num2 = sc.nextInt()-1;
		
		M = sc.nextInt();
		count = 0;
		arr = new int[N][N];
		vtd = new boolean[N];
		flag = false;
		for(int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x-1][y-1] = 1;
		}
		
		q = new LinkedList<Integer>();
		q.add(num1);
		vtd[num1] = true;
		solve();
		if(flag) System.out.println(count);
		else System.out.println("-1");
	}
}
