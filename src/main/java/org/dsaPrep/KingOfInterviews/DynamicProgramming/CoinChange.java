package org.dsaPrep.KingOfInterviews.DynamicProgramming;
//3rd Jan, 2024

//*******************//
//Coin Change: You are given an integer array coins representing coins of different denominations
// and an integer amount representing a total amount of money. Return the fewest number of coins
// that you need to make up that amount. If that amount of money cannot be made up by any combination
// of the coins, return -1. You may assume that you have an infinite number of each kind of coin.
//*******************//


import java.util.Arrays;

public class CoinChange {

    //understanding the problem is easy -> I will calculate minimum qty of coin needed with value coins[i] to form amount from 1 to amount.
    //ex -> i will need 1 qty of 1 value coin to form 1 amount.
    // i will need 10 qty of 1 value coin to form 10 amount.
    // i will need 2 qty of 5 value coin to form 10 amount.
    // so minimum qty needed to form is not 10 but only 2.
    //we keep finding minimum qty of coin needed of a specific value to form an n amount,
    //dp[10] = 2, dp[1] = 1 total needed is 3 for dp[11] as .

    //method1
    //Time:: O(coins.length)(amount), Space:: O(amount)
    //considering all coins less than the currentAmount
    private static int coinChange(int[] coins, int amount) {
        int[] dp = new int [amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(j >= coins[i-1])
                    dp[j] = Math.min(dp[j], dp[j-coins[i-1]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    //method2
    //Time:: O(amount*coins), Space:: O(amount*coin)
    //deciding whether to skip or pick a coin incase currentAmount greater than the coin value
    private static int coinChange1(int[] coins, int amount){
        int[][] dp = new int[coins.length+1][amount+1];

        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 0;
        }

        for (int j = 1; j < amount+1; j++) {
            dp[0][j]= amount+1;
        }

        for(int coinIdx = 1; coinIdx <= coins.length; ++coinIdx){
            for(int currentAmount = 1; currentAmount <= amount; currentAmount++){
                dp[coinIdx][currentAmount] = currentAmount >= coins[coinIdx-1] ? Math.min(dp[coinIdx-1][currentAmount], dp[coinIdx][currentAmount-coins[coinIdx-1]] + 1) : dp[coinIdx-1][currentAmount];
            }
        }

        return dp[coins.length][amount] > amount ? -1 : dp[coins.length][amount];
    }


    //method3
    //recursive approach
    //easy to understand approach
    private static int coinChange2(int[] coins, int amount){
        int[] dp = new int[amount+1];

        Arrays.fill(dp, amount+1);

        return coinChange2(coins, amount, dp);
    }

    private static int coinChange2(int[] coins, int amount, int[] dp){

        if(amount < 0){
            return -1;
        }

        if(dp[amount] < amount){
            return dp[amount];
        }

        if(amount == 0){
            return 0;
        }

        int min = -1;

        for(int coin : coins){
            int remainingAmount = amount - coin;
            int remainingQuantity = coinChange2(coins, remainingAmount, dp);
            if(remainingQuantity != -1){
                int totalQuantity = remainingQuantity + 1;
                if(min == -1 || totalQuantity < min){
                    min = totalQuantity;
                }
            }
        }

        dp[amount] = min;
        return min;

    }

    public static void main(String[] args) {

        int[] coins = {2,5,10,14};
        int amount = 1;

        int minPossibleCoinsNeeded = coinChange1(coins, amount);

        System.out.println(minPossibleCoinsNeeded);

    }



}
