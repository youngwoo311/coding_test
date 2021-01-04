package Programmers;

import java.util.Arrays;
import java.util.Scanner;

//[프로그래머스-연습문제] 문자열 내 마음대로 정렬하기
//https://programmers.co.kr/learn/courses/30/lessons/12915
public class P12915 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();
        String[] strings = new String[c];
        for(int i = 0; i < strings.length; i++){
            strings[i] = sc.next();
        }

        int n = sc.nextInt();

        String[] answer = new String[strings.length];

        for(int i = 0; i < strings.length; i++){
            strings[i] = strings[i].charAt(n) + strings[i];
        }
        Arrays.sort(strings);
        for(int i = 0; i < strings.length; i++) {
            answer[i] = strings[i].substring(1);
        }

        for(String s : answer){
            System.out.println(s);
        }

        sc.close();

    }
}
