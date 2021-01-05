package SW역량테스트준비_기초.수학;

import java.util.Scanner;

public class 소수찾기_1978 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int prime = 0;
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++) {
            int current = scanner.nextInt();
            if(isPrime(current)) {
                prime++;
            }
        }
        System.out.println(prime);
    }

    public static boolean isPrime(int x) {
        int cnt = 0;
        for(int i = 1; i <= x; i++) {
            if(x % i == 0) {
                cnt++;
            }
        }
        if(cnt == 2) {
            return true;
        }
        return false;
    }
}
