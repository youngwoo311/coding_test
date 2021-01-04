/**
 * [프로그래머스] 입국심사
 * reference : https://programmers.co.kr/learn/courses/30/lessons/43238
 */

import java.util.Arrays;

public class 입국심사 {

    public long solution(int n, int[] times) {

        Arrays.sort(times);

        int M = times.length;
        long low = 1L;
        long high = (long) n * times[M - 1];
        long answer = high;

        while (low < high) {
            long mid = (low + high) / 2;

            long sumOfQuotient = 0;
            for (int i = 0; i < M; i++) {
                sumOfQuotient += mid / times[i];
            }

            if (sumOfQuotient < n) {
                low = mid + 1;
            } else {
                if(mid < answer) answer = mid;
                high = mid;
            }
        }

        return answer;
    }
}
