package SW역량테스트준비_기초.수학;
/**
 * 에라토스테네스의 체
 */

import java.util.Scanner;

public class 골드바흐의추측_6588_시간초과 {

    public static final int MAX = 1000000;

    public static void main(String[] args) {

        int[] prime = new int[MAX + 10];
        for(int i = 3; i <= MAX; i+=2) {
            if(isPrime(i)) {
                prime[i] = 1;
            }
        }

        Scanner scanner = new Scanner(System.in);
        int n;
        while((n = scanner.nextInt()) != 0) {
            boolean flag = false;
            for(int i = 3; i <= n/2; i+=2) {
                if(prime[i] == 1 && prime[n-i] == 1) {
                    System.out.println(n + " = " + i + " + " + (n-i));
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }
    }

    public static boolean isPrime(int x) {
        int cnt = 0;
        for(int i = 1; i*i <= x; i++) {
            if(x % i == 0) {
                cnt++;
            }
        }
        if(cnt == 1) {
            return true;
        }
        return false;
    }
}
