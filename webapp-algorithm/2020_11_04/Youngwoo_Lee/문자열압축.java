/**
 * 2020 KAKAO BLIND RECRUITMENT - 문자열 압축
 * https://programmers.co.kr/learn/courses/30/lessons/60057?language=java
 */
class Solution {

    public int solution(String s) {

        int answer = Integer.MAX_VALUE;

        if(s.length() == 1) return 1;

        for(int i = 1; i <= s.length() / 2; i++){
            String cur = "";
            String comp = "";
            String temp = "";
            int cnt = 1;

            for(int j = 0; j <= s.length()/i; j++){
                int start = i * j;
                int end = i * (j + 1);

                if(end > s.length()) end = s.length();

                cur = comp;
                comp = s.substring(start, end);

                if(cur.equals(comp)) {
                    cnt++;
                } else {
                    if(cnt > 1) temp += String.valueOf(cnt);
                    temp += cur;
                    cnt = 1;
                }
            }

            if(cnt > 1) temp += String.valueOf(cnt);
            temp += comp;
            answer = Math.min(temp.length(), answer);
        }
        
        return answer;
    }
}