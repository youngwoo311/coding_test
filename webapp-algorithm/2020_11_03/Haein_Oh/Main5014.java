//https://www.acmicpc.net/problem/5014

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main5014 {
	public static int F, S, G, U, D, answer;
	public static int dx[];
	public static Queue<Integer> q;
	public static boolean vtd[];
	
	public static void solve() {
		int count = 0;
		boolean flag = false;
		loop:while(!q.isEmpty()) {
			int size = q.size();
			while(size > 0) {
				int x = q.poll();
				for(int i = 0; i < dx.length; i++) {
					int nx = x + dx[i];
					if(nx > F || nx <= 0) continue;
					if(nx == G) {
						flag = true;
						break;
					} else if(!vtd[nx]) {
						q.add(nx);
					} 
					vtd[nx] = true;
				}
				size--;
			}
			count++;
			if(flag) {
				answer = count;
				break loop;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();
		
		q = new LinkedList<Integer>();
		vtd = new boolean[1000001];
		answer = 987654321;
		vtd[S] = true;
		dx = new int[2];
		
		dx[0] = U;
		dx[1] = -D;
		q.add(S);

		if(S == G) answer = 0;
		else solve();
		if(answer == 987654321) System.out.println("use the stairs");
		else System.out.println(answer);
	}
}
