/**
 * 프로그래머스 월간 코드 챌린시 시즌1 - 3진법 뒤집기
 * https://programmers.co.kr/learn/courses/30/lessons/68935?language=java
 */
import java.util.*;

public class 3진법뒤집기 {

    public int solution(int n) {

        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        while(n != 0) {
            arr.add(n % 3);
            n /= 3;
        }
        int cur = 1;
        for(int i = arr.size()-1; i >= 0; i--) {
            answer += arr.get(i) * cur;
            cur *= 3;
        }
        
        return answer;
    }
}