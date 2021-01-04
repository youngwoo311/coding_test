/**
 * 프로그래머스 월간 코드 챌린시 시즌1 - 두 개 뽑아서 더하기
 * https://programmers.co.kr/learn/courses/30/lessons/68644?language=java
 */
import java.util.*;

public class 두개뽑아서더하기 {

    public int[] solution(int[] numbers) {

        int[] answer = {};
        ArrayList<Integer> arr = new ArrayList<>();

        for( int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if (arr.indexOf(sum) < 0) {
                    arr.add(sum);
                }
            }
        }

        answer = new int[arr.size()];
        for( int i = 0; i < arr.size(); i++){
            answer[i] = arr.get(i);
        }
        Arrays.sort(answer);

        return answer;
    }
}