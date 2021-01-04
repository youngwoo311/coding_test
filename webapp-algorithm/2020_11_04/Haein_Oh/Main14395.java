//https://www.acmicpc.net/problem/14395
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Temp {
	long num;
	String str;
	public Temp(long num, String str) {
		this.num = num;
		this.str = str;
	}
}

public class Main14395 {
	public static long S, T;
	public static String answer;
	public static Queue<Temp> q;
	public static HashSet<Long> set;
	
	public static void solve() {
		set = new HashSet<>();
		loop:while(!q.isEmpty()) {
			Temp tmp = q.poll();
			long num = tmp.num;
			String str = tmp.str;
			
			for(int i = 0; i < 4; i++) {
				long nx = 0;
				String nstr = "";
				switch(i) {
				case 0: // *
					nx = num * num;
					nstr = str + "*";
					break;
				case 1: // +
					nx = num + num;
					nstr = str + "+";
					break;
				case 2: // -
					nx = num - num;
					nstr = str + "-";
					break;
				case 3: // /
					if(num != 0) {
						nx = num / num;
						nstr = str + "/";
						if(!set.contains(nx)) {
							set.add(nx);
							q.add(new Temp(nx, nstr));
						}
					}
					break;
				}
				if(i != 3 && !set.contains(nx)) {
					set.add(nx);
					q.add(new Temp(nx, nstr));
				}
					
				if(nx == T) {
					answer = nstr;
					break loop;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		S = sc.nextLong();
		T = sc.nextLong();	
		answer = "";
		if(S == T) answer = "0";
		else {			
			q = new LinkedList<Temp>();
			q.add(new Temp(S, ""));
			solve();
		}
		
		if(answer == "") System.out.println("-1");
		else System.out.println(answer);
	}
}
