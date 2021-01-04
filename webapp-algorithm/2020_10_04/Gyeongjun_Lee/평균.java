package etc;

import java.util.Scanner;

//1차원배열
public class 평균 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] score = new int[n];
		int max = 0;
		double sum = 0;
		
		for(int i = 0; i < n; i++) {
			score[i] = sc.nextInt();
			if(score[i] > max) {
				max = score[i];
			}
		}
		
		for(int i = 0; i < n; i++) {
			double newscore = score[i] / (double)max * 100;
			sum += newscore;
		}
		
		System.out.println(sum/n);
		
	}
}
