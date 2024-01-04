package org.dsaPrep.KingOfInterviews.DynamicProgramming;
//1st Jan, 2024

//***************//
//House Robber: You are a professional robber planning to rob houses along a street.
// Each house has a certain amount of money stashed, the only constraint stopping you
// from robbing each of them is that adjacent houses have security systems connected
// and it will automatically contact the police if two adjacent houses were broken
// into on the same night.
//Given an integer array nums representing the amount of money of each house,
// return *the maximum amount of money you can rob tonight without alerting the police.
//***************//

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

    //recursive
    //Time:: O(N), Space:: O(N)
    private static int houseRobbed(int[] num, int counter) {

        if(num.length <= counter){
            return 0;
        }
        return num[counter] + houseRobbed(num, counter+2);
    }

    //iterative method1
    //Time:: O(N), Space:: O(1)
    private static int houseRobbed(int[] num){


        int oneStepBack = num[1];
        int twoStepBack = num[0];

        for (int i = 2; i < num.length; i++) {
            int currentMaxLoot = Math.max(twoStepBack + num[i], oneStepBack);
            twoStepBack = oneStepBack;
            oneStepBack = currentMaxLoot;
        }

        return oneStepBack;
    }

    //iterative method2:: dp
    //Time:: O(N), Space:: O(N)
    private static int houseRobbed1(int[] num){
        int[] dp = new int[num.length + 1];

        dp[1] = num[0];

        for (int i = 2; i <= num.length; i++) {
            dp[i] = Math.max(dp[i-2] + num[i-1], dp[i-1]);
        }

        return dp[num.length];
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,3,1};
        int[] num = {2,7,9,3,1};

//        int result = Math.max(houseRobbed(num, 0), houseRobbed(num, 1));
        int result = houseRobbed1(num1);

        System.out.println(result);



    }



}
