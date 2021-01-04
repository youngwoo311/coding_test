package exam.complete;

import java.util.ArrayDeque;
import java.util.Queue;

//https://leetcode.com/problems/number-of-islands/
//Complete
public class NumberofIslands {

    public static void main(String[] args) {
        char[][] param = new char[][] {
                                          {'1','1','1','1','0'},
                                          {'1','1','0','1','0'},
                                          {'1','1','0','0','0'},
                                          {'0','0','0','0','0'}
                                        };
        System.out.println(numIslands(param));
    }
    public static int numIslands(char[][] grid) {
        int answer = 0  ;
        boolean[][] flag  = new boolean[grid.length][grid[0].length];

        for(int i = 0 ; i < grid.length; i++) {
            for(int j = 0 ; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && !flag[i][j]) {
                    answer++;
                    search(grid, flag, grid.length, grid[0].length, i,j);
                }
            }
        }

        return answer;


    }

    public static void search(char[][] grid, boolean[][] flag, int length, int length1, int i, int j) {
        Queue<InfoObj> queue = new ArrayDeque<>();

        queue.add(new InfoObj(i,j));
        flag[i][j] = true;

        int[] xArray = {0,0,1,-1};
        int[] yArray = {1,-1,0,0};


        while(true) {
            if(queue.size() < 1) break;
            InfoObj nowVal = queue.poll();
            for(int r = 0 ; r < 4 ; r++) {
                int nextX = nowVal.getX() + xArray[r];
                int nextY = nowVal.getY() + yArray[r];
                if(nextX >= 0 && nextX < length && nextY >= 0 && nextY < length1 && grid[nextX][nextY] == '1' &&!flag[nextX][nextY]) {
                    flag[nextX][nextY] = true;
                    queue.add(new InfoObj(nextX, nextY));

                }


            }
        }



    }

    private static class InfoObj {
        private int x ;
        private int y ;

        public InfoObj(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
