/**
 * https://programmers.co.kr/learn/courses/30/lessons/12905
 */

public class ProblemSolving2 {

    public int solution(int[][] board) {
        int answer = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) continue;
                if (i - 1 >= 0 && j - 1 >= 0) {
                    int min = Math.min(board[i - 1][j], Math.min(board[i][j - 1], board[i - 1][j - 1]));
                    board[i][j] = min + 1;
                }
                if (board[i][j] > answer) answer = board[i][j];
            }
        }

        return answer * answer;
    }
}
