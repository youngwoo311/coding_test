/**
 * 2019 카카오 개발자 겨울 인턴십 - 튜플
 * https://programmers.co.kr/learn/courses/30/lessons/64065?language=java
 */
import java.util.*;

class Solution {

    public int[] solution(String s) {

        String [] strs = s.replaceAll("[{}]", " ").trim().split(" ,");
        int[] answer = new int[strs.length];
        HashSet<Integer> hashSet = new HashSet<Integer>();

        Arrays.sort(strs, (a,b) -> (a.length() - b.length()));
        int index = 0;
        for(String str : strs){
            for(String st : str.split(",")){
                int cur = Integer.parseInt(st.trim());
                if(hashSet.contains(cur)) continue;
                hashSet.add(cur);
                answer[index++] = cur;
            }
        }

        return answer;
    }
}