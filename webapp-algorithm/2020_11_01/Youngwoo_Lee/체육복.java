/**
 * 탐욕법 - 체육복
 * https://programmers.co.kr/learn/courses/30/lessons/42862?language=java
 */
class Solution {

    public int solution(int n, int[] lost, int[] reserve) {

        int[] people = new int[n];
        int answer = n;

        for(int l : lost)
            people[l-1]--;
        for(int r : reserve)
            people[r-1]++;

        for(int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(i-1 >= 0 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                } else if(i+1 < people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                } else
                    answer--;
            }
        }
        return answer;
    }
}