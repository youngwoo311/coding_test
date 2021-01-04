/**
 * 스택/큐 - 기능개발
 * https://programmers.co.kr/learn/courses/30/lessons/42586?language=java
 */
import java.util.*;

class Solution {

	public int[] solution(int[] progresses, int[] speeds) {

		Stack<Integer> stack = new Stack<Integer>();
		for(int i = progresses.length - 1; i >= 0; i--) {
			stack.add((100 - progresses[i]) / speeds[i] + ((100 - progresses[i]) % speeds[i] > 0 ? 1 : 0));
		}

		List<Integer> list = new ArrayList<Integer>();
		while(!stack.isEmpty()) {
			int cnt = 1;
			int top = stack.pop();

			while(!stack.isEmpty() && stack.peek() <= top) {
				cnt++;
				stack.pop();
			}
			list.add(cnt);
		}

		int[] answer = new int[list.size()];
		for(int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}