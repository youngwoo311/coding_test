/**
 * 해시 - 완주하지 못한 선수
 * https://programmers.co.kr/learn/courses/30/lessons/42576?language=java
 */
import java.util.HashMap;

class Solution {

    public String solution(String[] participant, String[] completion) {

        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String player : participant) hashMap.put(player, hashMap.getOrDefault(player, 0) + 1);
        for (String player : completion) hashMap.put(player, hashMap.get(player) - 1);

        for (String key : hashMap.keySet()) {
            if (hm.get(key) != 0) {
                answer = key;
            }
        }

        return answer;
    }
}