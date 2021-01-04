package exam;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutations/
//Complete
public class Permutations {
    public static void main(String[] args) {
        System.out.println(permute(new int[] {1}));
    }

    static List<List<Integer>> answer = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {

        for(int i = 0 ; i < nums.length; i++) {
            boolean[] boolList = new boolean[nums.length];
            boolList[i] = true;
            List<Integer> paramList = new ArrayList<>();
            paramList.add(nums[i]);
            dfs(paramList, nums,boolList);
        }

        return answer;
    }

    public static void dfs(List<Integer> paramList, int[] nums, boolean[] boolList) {
        if(paramList.size() == nums.length) {
            List<Integer> answerList = new ArrayList<>(paramList);
            answer.add(answerList);
        }else if(paramList.size() < nums.length){
            for(int i = 0; i < nums.length; i++) {
                if(!boolList[i]) {
                    paramList.add(nums[i]);
                    boolList[i] = true;
                    dfs(paramList, nums,boolList);
                    paramList.remove(Integer.valueOf(nums[i]));
                    boolList[i] = false;
                }
            }
        }
    }
}
