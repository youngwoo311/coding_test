package SW역량테스트준비_기초.브루트포스;

import java.util.Arrays;
import java.util.Scanner;

public class 일곱난쟁이_2309 {

    public static int[] arr = new int[9];
    public static int[] result = new int[7];
    public static boolean[] checked = new boolean[9];
    public static boolean flag = false;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < 9; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        getResult(0, 0);
    }

    public static void getResult(int current, int index) {
        if(flag) {
            return;
        }
        if(current == 7) {
            int sum = 0;
            for(int i = 0; i < 7; i++) {
                sum += result[i];
            }
            if(sum == 100) {
                flag = true;
                for(int i = 0; i < 7; i++) {
                    System.out.println(result[i]);
                }
            }
            return;
        }

        for(int i = index; i < 9; i++) {
            if(!checked[i]) {
                result[current] = arr[i];
                checked[i] = true;
                getResult(current+1, i);
                checked[i] = false;
            }
        }
    }
}
