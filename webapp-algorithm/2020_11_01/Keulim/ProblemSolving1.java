/**
 * https://programmers.co.kr/learn/courses/30/lessons/67258
 */

import java.util.*;

public class ProblemSolving1 {

    public int[] solution(String[] gems) {
        Set<String> kinds = new HashSet<>();

        for (String gem : gems) {
            kinds.add(gem);
        }

        PriorityQueue<Range> pq = new PriorityQueue<>();
        Map<String, Integer> check = new HashMap<>();

        for (int i = 0, j = 0; i < gems.length; i++) {
            while (check.size() < kinds.size() && j < gems.length) {
                check.put(gems[j], check.getOrDefault(gems[j], 0) + 1);
                j++;
            }
            if (check.size() == kinds.size()) {
                pq.add(new Range(i + 1, j));
            }
            check.put(gems[i], check.get(gems[i]) - 1);
            if (check.get(gems[i]) == 0) {
                check.remove(gems[i]);
            }
        }
        Range answer = pq.poll();
        return new int[]{answer.start, answer.end};
    }

    static class Range implements Comparable<Range> {
        private int start;
        private int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Range o) {
            int thisDiff = this.end - this.start;
            int thatDiff = o.end - o.start;
            if (thisDiff == thatDiff) {
                return Integer.compare(this.start, o.start);
            }
            return Integer.compare(thisDiff, thatDiff);
        }
    }
}
