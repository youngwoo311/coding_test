package exam.uploaded;

//https://leetcode.com/problems/pacific-atlantic-water-flow/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        System.out.println(pacificAtlantic(new int[][] {
                                                        {1,2,2,3,5},
                                                        {3,2,3,4,4},
                                                        {2,4,5,3,1},
                                                        {6,7,1,4,5},
                                                        {5,1,1,2,4}
                                                }));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> answer = new ArrayList<>();
        if(matrix.length == 0) return answer;
        int n = matrix.length;
        int m = matrix[0].length;

        boolean[][] pacificValidCoor = new boolean[matrix.length][matrix[0].length];
        boolean[][] atlanticValidCoor = new boolean[matrix.length][matrix[0].length];
        Queue<idxSet> pacQueue = new ArrayDeque<>();
        Queue<idxSet> atlAueue = new ArrayDeque<>();


//        0 index rows & 0 index cols  - Pacific
//        m -1 index rows &
        for (int i = 0; i < matrix[0].length; i++) {
            pacificValidCoor[0][i] = true;
            atlanticValidCoor[n - 1][i] = true;
            pacQueue.add(new idxSet(0, i, matrix[0][i]));
            atlAueue.add(new idxSet(n-1, i, matrix[n-1][i]));
        }

        for (int i = 0; i < matrix.length; i++) {
            pacificValidCoor[i][0] = true;
            atlanticValidCoor[i][m - 1] = true;
            pacQueue.add(new idxSet(i, 0, matrix[i][0]));
            atlAueue.add(new idxSet(i, m-1, matrix[i][m-1]));
        }

        queueSearch(matrix, n, m, pacificValidCoor, pacQueue);
        queueSearch(matrix, n, m, atlanticValidCoor, atlAueue);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(pacificValidCoor[i][j] && atlanticValidCoor[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    answer.add(list);
                }
            }
        }
        return answer;
    }

    private static void queueSearch(int[][] matrix, int n, int m, boolean[][] atlanticValidCoor, Queue<idxSet> atlAueue) {
        int[] arrX = {0, 0, 1, -1};
        int[] arrY = {1, -1, 0, 0};
        while (atlAueue.size() > 0) {
            idxSet nowSet = atlAueue.poll();
            int nowX = nowSet.getX();
            int nowY  = nowSet.getY();
            for (int i = 0; i < arrX.length; i++) {
                int nextX = nowX + arrX[i];
                int nextY = nowY + arrY[i];
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    if (!atlanticValidCoor[nextX][nextY]) {
                        if (matrix[nextX][nextY] >= nowSet.getMaxVal()) {
                            atlanticValidCoor[nextX][nextY] = true;
                            atlAueue.add(new idxSet(nextX, nextY, matrix[nextX][nextY]));
                        }
                    }
                }
            }
        }
    }

    private static class idxSet {
        private int x;
        private int y;
        private int maxVal ;

        public idxSet(int x, int y, int maxVal) {
            this.x = x;
            this.y = y;
            this.maxVal = maxVal;
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

        public int getMaxVal() {
            return maxVal;
        }

        public void setMaxVal(int maxVal) {
            this.maxVal = maxVal;
        }
    }
}
