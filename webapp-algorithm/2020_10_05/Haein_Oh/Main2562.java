//https://www.acmicpc.net/problem/2562

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2562 {
    public static int maxValue, index;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        maxValue = -987654321;
        index = 0;

        for(int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine().trim());
            int value = Integer.parseInt(st.nextToken());
            if(maxValue < value) {
                maxValue = value;
                index = i;
            }
        }
        System.out.println(maxValue);
        System.out.println(index+1);
    }
}
