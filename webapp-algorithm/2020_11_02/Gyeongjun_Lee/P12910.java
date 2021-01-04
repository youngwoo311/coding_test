package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//[프로그래머스-연습문제] 나누어 떨어지는 숫자 배열
//https://programmers.co.kr/learn/courses/30/lessons/12910
public class P12910 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int divisor = sc.nextInt();

        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) list.add(arr[i]);
        }

        if(list.size() == 0) list.add(-1);

        answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        Arrays.sort(answer);
        for(int a : answer) {
            System.out.println(a);
        }

        sc.close();

    }
}
