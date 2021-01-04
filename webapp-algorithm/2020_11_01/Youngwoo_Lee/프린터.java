/**
 * 스택/큐 - 프린터
 * https://programmers.co.kr/learn/courses/30/lessons/42587?language=java
 */
import java.util.*;

class Solution {

    public int solution(int[] priorities, int location) {

        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int priority : priorities){
            pq.offer(priority);
        }

        while(!pq.isEmpty()) {
            for(int i=0; i < priorities.length; i++) {
                if(pq.peek() == priorities[i]) {
                    pq.poll();
                    answer++;
                    if(location == i) {
                        pq.clear();
                        break;
                    }
                }
            }
        }

        return answer;
    }
}