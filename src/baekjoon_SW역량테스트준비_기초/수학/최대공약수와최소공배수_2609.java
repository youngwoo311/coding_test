package baekjoon_SW역량테스트준비_기초.수학;

import java.util.Scanner;

public class 최대공약수와최소공배수_2609 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int gcd = 1;
        int lcm = 10000;

        for(int i = A; i>=1; i--) {
            if(A % i == 0 && B % i == 0) {
                gcd = i;
                break;
            }
        }
        lcm = A / gcd * B;

        System.out.println(gcd);
        System.out.println(lcm);
    }
}
