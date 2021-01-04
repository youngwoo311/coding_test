package Programmers;

import java.util.Scanner;

//[프로그래머스-연습문제] 시저 암호
//https://programmers.co.kr/learn/courses/30/lessons/12926
public class P12926 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        String answer = "";

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(Character.isUpperCase(c)){
                if(c + n > 'Z') answer += (char)(c - 26 + n);
                else answer += (char)(c + n);
            }

            else if(Character.isLowerCase(c)){
                if(c + n > 'z') answer += (char)(c - 26 + n);
                else answer += (char)(c + n);
            }
            else answer += " ";
        }

        sc.close();
        System.out.println(answer);

    }
}
