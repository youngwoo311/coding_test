/**
 * 2019 카카오 개발자 겨울 인턴십 - 크레인 인형뽑기 게임
 * https://programmers.co.kr/learn/courses/30/lessons/64061?language=java
 */
import java.util.Stack;

class Solution {

    public int solution(int[][] board, int[] moves) {

        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int cur : moves) {
            for(int i = 0; i < board.length; i++) {
                if(board[i][cur - 1] != 0) {
                    if(stack.peek() == board[i][cur - 1]) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[i][cur - 1]);
                    }
                    board[i][cur - 1] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}