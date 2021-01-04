/**
 * 스택/큐 - 주식가격
 * https://programmers.co.kr/learn/courses/30/lessons/42584?language=java
 */
import java.util.Stack;

class Solution {
    
    public int[] solution(int[] prices) {
        
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        int[] answer = new int[prices.length];

        stack.push(cur);
        for(cur = 1; cur < prices.length; cur++) {
            while(!stack.empty() && prices[cur] < prices[stack.peek()]) {
                int index = stack.pop();
                answer[index] = cur - index;
            }
            stack.push(cur);
        }

        while(!stack.empty()) {
            int index = stack.pop();
            answer[index] = cur - index - 1;
        }

        return answer;
    }
}