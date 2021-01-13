package SW역량테스트준비_기초.브루트포스;

import java.util.Scanner;

public class 테트로미노_14500 {

    public static int[][] arr = new int[510][510];
    public static int n, m;
    public static int max;
    public static boolean[][] check = new boolean[510][510];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                getResult(i, j,0, 0, 0);
            }
        }
        System.out.println(max);
    }

    public static void getResult(int i, int j, int current, int sum, int checkCnt) {
        if(i < 0 || i >= n || j < 0 || j >= m) {
            return;
        }
        if(current > 6) {
            return;
        }
        if(checkCnt == 4) {
            if(sum > max) {
                max = sum;
            }
            return;
        }

        if(!check[i][j]) {
            check[i][j] = true;
            getResult(i+1, j, current+1, sum + arr[i][j], checkCnt + 1);
            getResult(i, j+1, current+1, sum + arr[i][j], checkCnt + 1);
            getResult(i-1, j, current+1, sum + arr[i][j], checkCnt + 1);
            getResult(i, j-1, current+1, sum + arr[i][j], checkCnt + 1);
            check[i][j] = false;
        } else {
            getResult(i+1, j, current+1, sum, checkCnt);
            getResult(i, j+1, current+1, sum, checkCnt);
            getResult(i-1, j, current+1, sum, checkCnt);
            getResult(i, j-1, current+1, sum, checkCnt);
        }
    }
}
