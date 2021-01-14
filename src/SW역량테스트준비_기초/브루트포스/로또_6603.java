package SW역량테스트준비_기초.브루트포스;

import java.util.Scanner;

public class 로또_6603 {

    public static int k = -1;
    public static int[] arr;
    public static int[] result;
    public static boolean[] check;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while((k = scanner.nextInt()) != 0) {
            arr = new int[k];
            result = new int[k];
            check = new boolean[k];
            for(int i = 0; i < k; i++) {
                arr[i] = scanner.nextInt();
            }
            getResult(0, 0);
            System.out.println();
        }
    }

    public static void getResult(int current, int index) {

        if(current == 6) {
            for(int i = 0; i < 6; i++) {
                System.out.print(result[i]);
                System.out.print(" ");
            }
            System.out.println();
            return;
        }

        for(int i = index; i < k; i++) {
            if(!check[i] ) {
                result[current] = arr[i];
                check[i] = true;
                getResult(current+1, i+1);
                check[i] = false;
            }
        }
    }
}
