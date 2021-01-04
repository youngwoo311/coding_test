package Algorithm.Leetcode;

public class MinimumDominoRotationsForEqualRow {

    private static final int SIZE = 7;

    public int minDominoRotations(int[] A, int[] B) {
        int resultOfA = calculateRotation(A, B);
        int resultOfB = calculateRotation(B, A);

        int answer = Math.min(resultOfA, resultOfB);
        return answer == A.length ? -1 : answer;
    }

    private int calculateRotation(int[] A, int[] B) {
        int minRotation = A.length;

        for (int num = 1; num <= 6; num++) {
            int countOfRotation = 0;
            int index = 0;
            for (; index < A.length; index++) {
                if (A[index] == num) continue;
                else if (B[index] == num) countOfRotation++;
                else break;
            }

            if (index != A.length) continue;
            minRotation = Math.min(minRotation, countOfRotation);
        }

        return minRotation;
    }

}
