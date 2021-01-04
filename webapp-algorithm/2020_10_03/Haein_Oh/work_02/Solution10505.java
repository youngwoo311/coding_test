//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXNP4CvauaMDFAXS&categoryId=AXNP4CvauaMDFAXS&categoryType=CODE

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution10505 {
	public static int N, arr[];

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine().trim());
		
		int test = Integer.parseInt(st.nextToken());
		arr = new int[10001];
		for(int ts = 1; ts <= test; ts++) {
			st = new StringTokenizer(bf.readLine().trim());
			int N = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < N; i++) arr[i] = 0;
			st = new StringTokenizer(bf.readLine());
			int avg = 0;
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				avg += arr[i];
			}
			avg /= N;
			int ans = 0;
			for(int i = 0; i < N; i++) {
				if(arr[i] <= avg) ans++;
			}
			
			System.out.println("#" + ts + " " + ans);
		}
	}
}