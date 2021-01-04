package SW역량테스트준비_기초.수학;

import java.util.Scanner;

public class 최소공배수_1934 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();

        for(int i = 0; i < testCase; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();

            int result = findLCM(A, B);
            System.out.println(result);
        }
    }

    public static int findLCM(int a, int b) {
        int gcd = 1;
        for(int i = a; i >= 1; i--) {
            if(a % i == 0 && b % i == 0) {
                gcd = i;
                break;
            }
        }
        return a / gcd * b;
    }
}
