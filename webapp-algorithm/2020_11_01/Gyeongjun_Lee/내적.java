package Programmers;

//[프로그래머스-월간 코드 첼린지 시즌1] 내적
public class 내적 {
    public static void main(String[] args) {
        int answer = 0;

        int[] a = {-1,0,1};
        int[] b = {1,0,-1};

        for(int i = 0; i < a.length; i++){
            answer += a[i] * b[i];
        }

        System.out.println(answer);

    }
}
