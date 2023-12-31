package org.dsaPrep.KingOfInterviews.DynamicProgramming;
//31st Dec, 2023

//*******************//
//Counting Bits: Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
//ans[i] is the number of 1's in the binary representation of i.
//*******************//

public class CountingBits {

    private static int counter = 0;

    //method 1 :: recursive without dp
    // Time :: O(N), Space :: O(N)
    private static int countingBits1(int num){

        if(num == 1){
            return ++counter;
        }

        if(num % 2 == 1){
            counter++;

        }
        num = num >> 1;

        return countingBits1(num);
    }

    //method 2 :: iterative with dp
    // Time :: O(N), Space :: O(N)
    private static int countingBits2(int num){

        int[] dp = new int[num+1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= num; i++) {
            dp[i] = dp[i/2] + i%2;
        }

        return dp[num];

    }

    public static void main(String[] args) {

        int num = 15777707;

        int result1 = countingBits1(num);
        int result2 = countingBits2(num);

        System.out.println(result1);
        System.out.println(result2);
    }
}
