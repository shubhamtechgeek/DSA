package org.dsaPrep.KingOfInterviews.DynamicProgramming;
//23rd Jan, 2024

//*******************//
//Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
//The test cases are generated so that the answer can fit in a 32-bit integer.
//*******************//


public class CombinationSum4 {

    //recursive
    //Time :: O(target*nums)  //Space :: O(target)
    private static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        if(dp[target] > 0 || target == 0){
            return dp[target];
        }
        int count = 0;
        for(int num : nums){
            if(target >= num){
                count+=  combinationSum4(nums, target-num);
            }
        }
        dp[target] = count;
        return dp[target];
    }

    //iterative
    //Time :: O(target*nums)  //Space :: O(target)
    public static int combinationSum5(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int tar = 1; tar <= target; tar++) {
            for (int num : nums) {
                if (tar >= num) {
                    dp[tar] += dp[tar - num];
                }
            }
        }

        return dp[target];
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 4;

        System.out.println(combinationSum5(nums, target));

    }



}
