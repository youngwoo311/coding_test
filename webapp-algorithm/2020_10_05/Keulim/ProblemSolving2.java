/*
 * https://programmers.co.kr/learn/courses/30/lessons/60063
 */

import java.util.LinkedList;
import java.util.Queue;

public class ProblemSolving2 {

    private class Node {
        int hx, hy;
        int tx, ty;
        int count;

        Node(int hx, int hy, int tx, int ty, int count) {
            this.hx = hx;
            this.hy = hy;
            this.tx = tx;
            this.ty = ty;
            this.count = count;
        }
    }

    private int N;
    private boolean[][][] check;
    private int[][] map;
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, 1, -1};

    public int solution(int[][] board) {
        map = board;
        N = board.length;
        check = new boolean[N][N][2];

        Queue<Node> queue = new LinkedList<>();
        check[0][0][0] = true;
        check[0][1][0] = true;
        queue.offer(new Node(0, 0, 0, 1, 0));
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if ((current.hx == N - 1 && current.hy == N - 1) || (current.tx == N - 1 && current.ty == N - 1)) {
                return current.count;
            }

            int currentDir = current.hy == current.ty ? 1 : 0; // dir 1 수직, 0 수평
            moveUpDownLeftRight(queue, current, currentDir);

            int nextDir = currentDir ^ 1;
            moveRotation(queue, current, currentDir, nextDir);
        }
        return 0;
    }

    private void moveUpDownLeftRight(Queue<Node> queue, Node current, int currentDir) {
        for (int k = 0; k < 4; k++) {
            int nhx = current.hx + dx[k];
            int nhy = current.hy + dy[k];
            int ntx = current.tx + dx[k];
            int nty = current.ty + dy[k];

            if (isOut(nhx, nhy) || isOut(ntx, nty)) continue;
            if (isVisited(nhx, nhy, currentDir) && isVisited(ntx, nty, currentDir)) continue;

            check[nhx][nhy][currentDir] = true;
            check[ntx][nty][currentDir] = true;

            queue.offer(new Node(nhx, nhy, ntx, nty, current.count + 1));
        }
    }


    private void moveRotation(Queue<Node> queue, Node current, int currentDir, int nextDir) {
        if (currentDir == 1) {  // 수직일 때
            // 오른쪽 회전
            if (!isOut(current.tx, current.ty + 1) && !isOut(current.hx, current.hy + 1)) {
                if (!isVisited(current.hx, current.hy + 1, nextDir)) {
                    check[current.hx][current.hy][nextDir] = true;
                    check[current.hx][current.hy + 1][nextDir] = true;
                    queue.offer(new Node(current.hx, current.hy, current.hx, current.hy + 1, current.count + 1));
                }

                if (!isVisited(current.tx, current.ty + 1, nextDir)) {
                    check[current.tx][current.ty][nextDir] = true;
                    check[current.tx][current.ty + 1][nextDir] = true;
                    queue.offer(new Node(current.tx, current.ty, current.tx, current.ty + 1, current.count + 1));
                }
            }
            // 왼쪽 회전
            if (!isOut(current.tx, current.ty - 1) && !isOut(current.hx, current.hy - 1)) {
                if (!isVisited(current.hx, current.hy - 1, nextDir)) {
                    check[current.hx][current.hy][nextDir] = true;
                    check[current.hx][current.hy - 1][nextDir] = true;
                    queue.offer(new Node(current.hx, current.hy - 1 , current.hx, current.hy, current.count + 1));
                }

                if (!isVisited(current.tx, current.ty - 1, nextDir)) {
                    check[current.tx][current.ty][nextDir] = true;
                    check[current.tx][current.ty - 1][nextDir] = true;
                    queue.offer(new Node(current.tx, current.ty - 1,  current.tx, current.ty, current.count + 1));
                }
            }

        } else {   // 수평일 때
            // 하  부 회전
            if (!isOut(current.tx + 1, current.ty) && !isOut(current.hx + 1, current.hy)) {
                if (!isVisited(current.tx + 1, current.ty, nextDir)) {
                    check[current.tx][current.ty][nextDir] = true;
                    check[current.tx + 1][current.ty][nextDir] = true;
                    queue.offer(new Node(current.tx, current.ty, current.tx + 1, current.ty, current.count + 1));
                }

                if (!isVisited(current.hx + 1, current.hy, nextDir)) {
                    check[current.hx][current.hy][nextDir] = true;
                    check[current.hx + 1][current.hy][nextDir] = true;
                    queue.offer(new Node(current.hx, current.hy, current.hx + 1, current.hy, current.count + 1));
                }
            }
            // 상 부 회전
            if (!isOut(current.tx - 1, current.ty) && !isOut(current.hx - 1, current.hy)) {
                if (!isVisited(current.hx - 1, current.hy, nextDir)) {
                    check[current.hx][current.hy][nextDir] = true;
                    check[current.hx - 1][current.hy][nextDir] = true;
                    queue.offer(new Node(current.hx - 1, current.hy, current.hx, current.hy, current.count + 1));
                }

                if (!isVisited(current.tx - 1, current.ty, nextDir)) {
                    check[current.tx][current.ty][nextDir] = true;
                    check[current.tx - 1][current.ty][nextDir] = true;
                    queue.offer(new Node(current.tx - 1, current.ty, current.tx, current.ty, current.count + 1));
                }
            }
        }
    }

    private boolean isOut(int x, int y) {
        return (x < 0 || y < 0 || x >= N || y >= N || map[x][y] == 1);
    }

    private boolean isVisited(int x, int y, int dir) {
        return check[x][y][dir];
    }
}
