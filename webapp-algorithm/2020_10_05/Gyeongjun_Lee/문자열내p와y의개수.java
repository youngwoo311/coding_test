package Programmers;

import java.util.Scanner;

//[프로그래머스] 문자열 내 p와 y의 개수
public class 문자열내p와y의개수 {
    public static void main(String[] args) {

        boolean answer = true;

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        s = s.toUpperCase();

        int p = 0;
        int y = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'P'){
                p++;
            }
            else if(s.charAt(i) == 'Y'){
                y++;
            }
        }

        if(p != y) answer = false;
        System.out.println(answer);

    }
}
