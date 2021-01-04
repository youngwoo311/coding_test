package exam;

//https://leetcode.com/problems/minimum-path-sum/
//Complete
public class MinimumPathSum {
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][] {
                                                    {1,3,1},
                                                      {1,5,1},
                                                      {4,2,1}
                                                                }));
    }

//    DP
    public static int minPathSum(int[][] grid) {
        int answer = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] sumGrid = new int[n][m];

        for(int i = 0 ; i < n; i++) {
            for( int j = 0 ; j < m; j++) {
                int min = Integer.MAX_VALUE;
                if(i - 1 >= 0) {
                    min = sumGrid[i-1][j];
                }
                if(j - 1 >= 0) {
                    min = Math.min(min, sumGrid[i][j-1]);
                }
                if(i == 0 && j == 0 ) sumGrid[i][j] = grid[i][j];
                else sumGrid[i][j] = min + grid[i][j];
            }
        }

        return sumGrid[n-1][m-1];

    }
}
