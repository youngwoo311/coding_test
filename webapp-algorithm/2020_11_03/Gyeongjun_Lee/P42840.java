package Programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//[프로그래머스-완전탐색] 모의고사
//https://programmers.co.kr/learn/courses/30/lessons/42840
public class P42840 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] answers = new int[sc.nextInt()];
        for(int i = 0; i < answers.length; i++){
            answers[i] = sc.nextInt();
        }

        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1 ,2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int r1 = 0;
        int r2 = 0;
        int r3 = 0;

        for(int i = 0; i < answers.length; i++){
            if(p1[i%5] == answers[i]) r1++;
            if(p2[i%8] == answers[i]) r2++;
            if(p3[i%10] == answers[i]) r3++;
        }

        int max = Math.max(Math.max(r1, r2), r3);

        List<Integer> list = new ArrayList<Integer>();
        if(max == r1) list.add(1);
        if(max == r2) list.add(2);
        if(max == r3) list.add(3);

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        for(int a : answer){
            System.out.println(a);
        }

        sc.close();
    }
}
