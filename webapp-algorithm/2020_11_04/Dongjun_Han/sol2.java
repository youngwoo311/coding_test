/*
https://programmers.co.kr/learn/courses/30/lessons/43105
 */

public class sol2 {
    public int sol2(int[][] triangle){
        int answer = 0;
        int[][] solArray = new int[triangle.length][triangle.length];

        solArray[0][0] = triangle[0][0];
        for(int i=1;i<triangle.length;i++){
            solArray[i][0] = solArray[i-1][0] + triangle[i][0];
            solArray[i][i] = solArray[i-1][i-1] + triangle[i][i];
        }

        for(int i=2;i< triangle.length;i++){
            for(int j=1;j<i;j++){
                solArray[i][j] = Math.max(solArray[i-1][j-1], solArray[i-1][j]) + triangle[i][j];
            }
        }

        int maxAns = solArray[triangle.length-1][0];
        for(int i=1;i< triangle.length;i++){
            int temp = solArray[triangle.length-1][i];
            if(maxAns<temp){
                maxAns = temp;
            }
        }
        answer = maxAns;
        return answer;
    }

}
