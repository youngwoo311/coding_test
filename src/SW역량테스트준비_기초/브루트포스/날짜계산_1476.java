package SW역량테스트준비_기초.브루트포스;

import java.util.Scanner;

public class 날짜계산_1476 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int e = scanner.nextInt();
        int s = scanner.nextInt();
        int m = scanner.nextInt();

        int i = 1;
        int j = 1;
        int k = 1;
        int cnt = 1;

        while(true) {
            if(e == i && s == j && m == k) {
                break;
            }
            i++;
            if(i > 15) i = 1;
            j++;
            if(j > 28) j = 1;
            k++;
            if(k > 19) k = 1;
            cnt++;
        }
        System.out.println(cnt);
    }
}
