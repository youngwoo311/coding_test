//https://www.acmicpc.net/problem/9436
import java.util.ArrayList;
import java.util.Scanner;

public class Main9436 {
	public static int N, T;
	public static ArrayList<Integer> list;
	
	public static boolean check() {
		for(int i = 0; i < list.size()-1; i++) {
			if(list.get(i) != list.get(i+1)) return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			N = sc.nextInt();
			if(N == 0) break;
			T = sc.nextInt();
			
			list = new ArrayList<>();
			for(int i = 0; i < N; i++) list.add(i, 0);
			int idx = 0;
			while(true) {
				for(int i = 1;i <= T; i++) {
					list.set(idx, list.get(idx)+1);
					idx++;
					idx = idx >= N ? idx = 0 : idx;
				}
				if(idx-1 == -1) {
					list.remove(N-1);
					idx = 0;
				} else {
					list.remove(idx-1);
					idx = idx-1;					
				}
				if(check()) break;
				N--;
			}
			System.out.println(list.size() + " " + list.get(0));
		}
	}
}
