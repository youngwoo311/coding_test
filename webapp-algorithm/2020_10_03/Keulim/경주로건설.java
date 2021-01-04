/**
 * [프로그래머스] 경주로건설
 * reference : https://programmers.co.kr/learn/courses/30/lessons/67259
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 경주로건설 {

    public int solution(int[][] board) {
        int N = board.length;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Queue<Point> queue = new LinkedList<>();
        board[0][0] = 1;
        queue.offer(new Point(0, 0, -1, 0));

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            int cx = cur.x;
            int cy = cur.y;
            int cd = cur.d;
            int cc = cur.c;

            for (int k = 0; k < 4; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (board[nx][ny] == 1) continue;

                int cost = 600;
                if (isStraight(cd, k)) {
                    cost = 100;
                }

                if (board[nx][ny] == 0 || cc + cost <= board[nx][ny]) {
                    board[nx][ny] = cc + cost;
                    queue.offer(new Point(nx, ny, k, board[nx][ny]));
                }
            }
        }
        return board[N - 1][N - 1];
    }

    private boolean isStraight(int cd, int k) {
        return cd == k || cd == -1;
    }

    private static class Point {
        private int x;
        private int y;
        private int d;
        private int c;

        public Point(int x, int y, int d, int c) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.c = c;
        }
    }
}