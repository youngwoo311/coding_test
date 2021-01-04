package Programmers;

import java.util.Scanner;

//[프로그래머스-월간 코드 첼린지 시즌1] 3진법 뒤집기
public class 삼진법뒤집기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String three = "";
        while(n > 0){
            three = (n % 3) + three;
            n /= 3;
        }

        String rev = new StringBuilder(three).reverse().toString();
        System.out.println(Integer.parseInt(rev, 3));
        sc.close();

    }
}
