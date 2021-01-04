/**
 * 2019 KAKAO BLIND RECRUITMENT - 오픈채팅방
 * https://programmers.co.kr/learn/courses/30/lessons/42888?language=java
 */
import java.util.*;

class Solution {

    public String[] solution(String[] record) {
        
        ArrayList<String> arrayList = new ArrayList<>();
        HashMap<String, String> hashMap = new HashMap<>();

        for(String cur : record) {
            String[] arr = cur.split(" ");
            if(!arr[0].equals("Leave"))
                hashMap.put(arr[1], arr[2]);
        }

        for(String cur : record) {
            String[] arr = cur.split(" ");
            if(arr[0].equals("Enter")) {
                arrayList.add(hashMap.get(arr[1]) + "님이 들어왔습니다.");
            } else if(arr[0].equals("Leave")) {
                arrayList.add(hashMap.get(arr[1]) + "님이 나갔습니다.");
            }
        }

        String[] answer = new String[arrayList.size()];
        for(int i = 0 ; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }

        return answer;
    }
}