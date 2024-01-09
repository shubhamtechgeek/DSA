package org.dsaPrep.KingOfInterviews.DynamicProgramming;
//3rd Jan, 2024

//*******************//
//Coin Change: You are given an integer array coins representing coins of different denominations
// and an integer amount representing a total amount of money. Return the fewest number of coins
// that you need to make up that amount. If that amount of money cannot be made up by any combination
// of the coins, return -1. You may assume that you have an infinite number of each kind of coin.
//*******************//

public class MaximumSubarraySum {

    public static void main(String[] args) {

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(findMaxSum(nums));

    }

    private static int findMaxSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE; int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(nums[i], nums[i]+sum);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }


}
