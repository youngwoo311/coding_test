package BackJoon;

import java.util.ArrayList;
import java.util.Scanner;

//[백준] 블랙잭
public class 블랙잭 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> list = new ArrayList();

        int ans;
        int i;
        for(ans = 0; ans < n; ++ans) {
            i = sc.nextInt();
            if (i <= m) {
                list.add(i);
            }
        }

        ans = 0;

        for(i = 0; i < list.size() - 2; ++i) {
            for(int j = i + 1; j < list.size() - 1; ++j) {
                for(int k = j + 1; k < list.size(); ++k) {
                    int sum = (Integer)list.get(i) + (Integer)list.get(j) + (Integer)list.get(k);
                    if (sum <= m) {
                        ans = Math.max(sum, ans);
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
