package Programmers;

import java.util.Arrays;

//[프로그래머스-연습문제] K번째수
//https://programmers.co.kr/learn/courses/30/lessons/42748
public class P42748 {
    public static void main(String[] args) {

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answer = new int[commands.length];

        for(int m = 0; m < commands.length; m++){
            int[] tmp = Arrays.copyOfRange(array, commands[m][0]-1, commands[m][1]);
            Arrays.sort(tmp);
            answer[m] = tmp[commands[m][2]-1];
        }

        for(int a : answer){
            System.out.println(a);
        }

    }
}
