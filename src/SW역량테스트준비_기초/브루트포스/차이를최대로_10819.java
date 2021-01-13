package SW역량테스트준비_기초.브루트포스;

import java.util.Scanner;

public class 차이를최대로_10819 {

    public static int max = 0;
    public static int[] arr = new int[10];
    public static int[] result = new int[10];
    public static boolean[] check = new boolean[10];
    public static int n;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        getResult(0);
        System.out.println(max);
    }

    public static void getResult(int current) {
        if(current == n) {
            int sum = calculate(n);
            if(sum > max) {
                max = sum;
            }
            return;
        }
        for(int i = 0; i < n; i++) {
            if(!check[i]) {
                result[current] = arr[i];
                check[i] = true;
                getResult(current+1);
                check[i] = false;
            }
        }
    }

    public static int calculate(int size) {
        int calculateResult = 0;

        for(int i = 0; i < n-1; i++) {
            int minus = Math.abs(result[i+1] - result[i]);
            calculateResult += minus;
        }

        return calculateResult;
    }
}
