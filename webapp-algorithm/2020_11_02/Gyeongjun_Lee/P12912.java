package Programmers;

import java.util.Scanner;

//[프로그래머스-연습문제] 두 정수 사이의 합
//https://programmers.co.kr/learn/courses/30/lessons/12912
public class P12912 {
    public static void main(String[] args) {
        long answer = 0;

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if(a < b){
            for(int i = a; a <= b; a++){
               answer += a;
            }
        } else{
            for (int i = b; b <= a; b++) {
               answer += b;
            }
        }

        System.out.println(answer);
        sc.close();

    }
}

