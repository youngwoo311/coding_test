/**
 * https://programmers.co.kr/learn/courses/30/lessons/60062
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ProblemSolving3 {

    public int solution(int n, int[] weak, int[] dist) {

        Arrays.sort(dist);
        int[] linearWeak = getLinearWeak(n, weak);

        Set<Integer> reparableSets = new HashSet<>();
        reparableSets.add(0);

        for (int j = dist.length - 1; j >= 0; j--) {
            int curDist = dist[j];

            Set<Integer> reparableByCur = getReparableSetByCur(linearWeak, curDist, weak.length);

            Set<Integer> cand = new HashSet<>();
            for (int rs : reparableByCur) {
                for (int r : reparableSets) {
                    int combined = rs | r;
                    if (Integer.bitCount(combined) == weak.length) {
                        return dist.length - j;
                    }
                    cand.add(combined);
                }
            }
            reparableSets = cand;

        }
        return -1;
    }

    private Set<Integer> getReparableSetByCur(int[] linearWeak, int curDist, int weakCount) {
        Set<Integer> temp = new HashSet<>();
        for (int i = 0; i < weakCount; i++) {
            int bitSum = 0;
            for (int j = i; j < i + weakCount; j++) {
                if (linearWeak[j] - linearWeak[i] <= curDist) {
                    bitSum += (1 << (j % weakCount));
                }
            }
            temp.add(bitSum);
        }
        return temp;
    }

    private int[] getLinearWeak(int n, int[] weak) {
        int[] temp = new int[weak.length * 2 - 1];
        for (int i = 0; i < temp.length; i++) {
            if (i < weak.length) {
                temp[i] = weak[i];
            } else {
                temp[i] = weak[i % weak.length] + n;
            }
        }
        return temp;
    }
