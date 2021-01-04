package com.exam;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        // 2-nested loop
        // O(n to the power of 2)
        for(int i = 0 ; i < nums.length - 1; i++ ) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[] {i, j };
                }
            }
        }
        return new int[] {};
    }
}
