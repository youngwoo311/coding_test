/**
 * 완전탐색 - 모의고사
 * https://programmers.co.kr/learn/courses/30/lessons/42840?language=java
 */
import java.util.ArrayList;

class Solution {

    public int[] solution(int[] answers) {

        int[] answer = {};
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};
        int res1 = 0, res2 = 0, res3 = 0;

        for(int i = 0; i < answers.length; i++) {
            if(p1[i % p1.length] == answers[i]) res1++;
            if(p2[i % p2.length] == answers[i]) res2++;
            if(p3[i % p3.length] == answers[i]) res3++;
        }

        int max = Math.max(Math.max(res1, res2), res3);
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(max==res1) list.add(1);
        if(max==res2) list.add(2);
        if(max==res3) list.add(3);

        answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}