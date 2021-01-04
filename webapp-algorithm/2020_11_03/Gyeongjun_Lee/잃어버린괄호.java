package BackJoon;

import java.util.Scanner;
import java.util.StringTokenizer;

//[백준-그리디알고리즘] 잃어버린 괄호
public class 잃어버린괄호 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        StringTokenizer sub = new StringTokenizer(input, "-");
        int sum = Integer.MAX_VALUE;

        while(sub.hasMoreTokens()){
            int tmp = 0;

            StringTokenizer add = new StringTokenizer(sub.nextToken(), "+");

            while(add.hasMoreTokens()){
                tmp += Integer.parseInt(add.nextToken());
            }

            if(sum == Integer.MAX_VALUE){
                sum = tmp;
            } else{
                sum -= tmp;
            }
        }

        sc.close();
        System.out.println(sum);

    }
}
