package org.dsaPrep.KingOfInterviews.DynamicProgramming;
//9th Jan, 2024

//*******************//
//Maximum Subarray Sum: Given an integer array nums, find the subarray with the largest sum, and return its sum.
//*******************//

public class MaximumSubarraySum {

    public static void main(String[] args) {

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(findMaxSum(nums));

    }

    private static int findMaxSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE; int sum = 0;

        for (int num : nums) {
            sum = Math.max(num, num + sum);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }


}
