/*
 * https://www.acmicpc.net/problem/9465
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class ProblemSolving2 {
    public static int[][] d;
    public static int[][] a;
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {

            int testCase = parseInt(br.readLine());

            for(int t=0; t<testCase; t++) {
                int n = parseInt(br.readLine());
                d = new int[3][n+1];
                a = new int[2][n+1];
                for(int i=0; i<2; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    for(int j=1; j<=n; j++) {
                        a[i][j] = parseInt(st.nextToken());
                        d[i][j] = a[i][j];
                    }
                }

                for(int j=2; j<=n; j++) {
                    d[0][j] += Math.max(d[1][j-1], d[2][j-1]);
                    d[1][j] += Math.max(d[0][j-1], d[2][j-1]);
                    d[2][j] = Math.max(d[0][j-1], d[1][j-1]);
                }

                int answer = Math.max(d[0][n], d[1][n]);
                answer = Math.max(answer, d[2][n]);
                System.out.println(answer);
            }

        }
    }
}
