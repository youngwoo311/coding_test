package exam.complete;

//https://www.hackerrank.com/challenges/2d-array/problem
public class HourglassSum {

    public static void main(String[] args) {
        int[][] arr = new int[6][6];
        arr = new int[][]{{-9, -9, -9, 1, 1, 1},
                {0, -9, 0, 4, 3, 2},
                {-9, -9, -9, 1, 2, 3},
                {0, 0, 8, 6, 6, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, 1, 2, 4, 0}};
        System.out.println(hourglassSum(arr));
    }


    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int answer = 0 ;

//        validatable vertexes
//        i = 1,2,3,4
//        j = 1,2,3,4

        int[] adjacentArrX = {-1, -1,-1,0, 1,1,1};
        int[] adjacentArrY = {-1, 0, 1, 0, -1, 0, 1};

        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                int nowValue = Integer.MIN_VALUE;
                for (int r = 0; r < adjacentArrX.length; r++) {
                    nowValue += arr[i + adjacentArrX[r]][j + adjacentArrY[r]];
                }
                answer = Math.max(answer, nowValue);
            }
        }


        return answer;

    }

}
