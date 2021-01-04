//https://www.acmicpc.net/problem/1747
import java.util.Scanner;

public class Main1747 {
	public static int N;
	public static int length = 1003001;
	public static boolean vtd[];
	
	public static void prime() {
		vtd[0] = vtd[1] = true;
		for(int i = 2; i <= Math.sqrt(length); i++) {
			if(vtd[i]) continue;
			for(int j = i; (i*j) <= length; j++) {
				vtd[i*j] = true;
			}
		}
	}
	
	public static boolean check(int x) {
		StringBuilder sb = new StringBuilder(String.valueOf(x));
		if(sb.toString().equals(sb.reverse().toString())) return true;
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		vtd = new boolean[length+1];
		prime();
		N = sc.nextInt();
		int num = 0;
		for(int i = N; i <= length; i++) {
			if(!vtd[i]) { //소수이면서
				if(check(i)) {
					num = i;
					break;
				}
			}
		}
		System.out.println(num);
		
	}
}
