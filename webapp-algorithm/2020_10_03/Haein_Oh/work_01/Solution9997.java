//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXIvNBzKapEDFAXR&categoryId=AXIvNBzKapEDFAXR&categoryType=CODE

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution9997 {
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine().trim());
		int test = Integer.parseInt(st.nextToken());
		
		for(int ts = 1; ts <= test; ts++) {
			st = new StringTokenizer(bf.readLine());
			int value = Integer.parseInt(st.nextToken()) % 365;
			value*=2;
			System.out.println("#" + ts + " " + (value/60) + " " + (value%60));
		}
	}
}
