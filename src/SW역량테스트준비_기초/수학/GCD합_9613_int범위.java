package SW역량테스트준비_기초.수학;
/**
 * 순열, 조합
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GCD합_9613_int범위 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();
        for(int i = 0; i < testCase; i++) {
            int n = scanner.nextInt();
            List<Integer> list = new ArrayList(110);
            for(int j = 0; j < n; j++) {
                int current = scanner.nextInt();
                list.add(current);
            }
            long sum = sumGcd(n, list);
            System.out.println(sum);
        }
    }

    public static long sumGcd(int size, List<Integer> list) {
        if(size == 1) {
            return list.get(0);
        }

        long sum = 0;
        for(int i = 0; i < size-1; i++) {
            for(int j = i+1; j < size; j++) {
                sum += getGcd(list.get(i), list.get(j));
            }
        }
        return sum;
    }

    public static int getGcd(int x, int y) {
        int gcd = 1;

        for(int i = x; i >= 1; i--) {
            if(x % i == 0 && y % i == 0) {
                gcd = i;
                break;
            }
        }
        return gcd;
    }
}
