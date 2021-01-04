package com.exam;


import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{2,3}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        merge array
//        O(log(n+m))
        if(nums1.length == 0 && nums2.length == 0) return (double) 0;
        int[] array = new int[nums1.length + nums2.length];
        System.arraycopy(nums1,0, array, 0, nums1.length);
        System.arraycopy(nums2,0, array, nums1.length, nums2.length);
        Arrays.sort(array);
        if(array.length == 1) return (double) array[0]/2 ;

        return array.length % 2 == 1 ? (double) array[array.length / 2] : ((double) (array[array.length / 2] + array[array.length / 2 - 1]) )/ 2;

    }

}

