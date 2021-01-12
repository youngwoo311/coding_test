package SW역량테스트준비_기초.브루트포스;

import java.util.Scanner;

public class 일이삼더하기_9095 {

    public static int n;
    public static int cnt;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();
        for(int i = 0; i < testCase; i++) {
            cnt = 0;
            n = scanner.nextInt();
            getResult(0);
            System.out.println(cnt);
        }
    }

    public static void getResult(int currentSum) {
        if(currentSum > n) {
            return;
        }
        if(currentSum == n) {
            cnt++;
            return;
        }
        for(int i = 1; i <= 3; i++) {
            getResult(currentSum + i);
        }
    }
}
