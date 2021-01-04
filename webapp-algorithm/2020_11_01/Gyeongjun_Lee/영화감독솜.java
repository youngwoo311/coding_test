package BackJoon;

import java.util.Scanner;

//[백준-bruteforce] 영화감독솜
public class 영화감독솜 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 665;
        int cnt = 0;

        while(true) {
            if(String.valueOf(++a).contains("666")) {
                System.out.println(a);
                cnt++;
            }
            if(cnt == n) break;
        }

        System.out.println(a);
        sc.close();
    }
}

