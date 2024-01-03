package org.dsaPrep.KingOfInterviews.DynamicProgramming;
//31st Dec, 2023

//*******************//
//Climbing Stairs: You are climbing a staircase. It takes n steps to reach the top. Each time you can either climb 1 or 2 steps.
// In how many distinct ways can you climb to the top?
//*******************//


import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {


    //method 1 = pure recursion
    // Time :: O(N^2), Space :: O(N)

    //Either take 1 step or take 2 step
    private static int climbStairs1(int top) {
        if(top == 0) return 1;

        if(top < 0) return 0;

        return climbStairs1(top - 1) + climbStairs1(top - 2);
    }

    private static final Map<Integer, Integer> memo = new HashMap<>();

    //method 2 = recursion + memo data storing = memoization
    // Time :: O(N), Space :: O(N)
    private static int climbStairs2(int top) {
        if(memo.containsKey(top)){
            return memo.get(top);
        }

        if(top == 0) return 1;

        if(top < 0) return 0;

        memo.put(top,  climbStairs2(top-1) + climbStairs2(top-2));

        return memo.get(top);
    }

    //method 3 = tabulation (iterative)
    // Time :: O(N), Space :: O(N)
    private static int climbStairs3(int top){
        int[] memo = new int[top+1];

        memo[1] = 1;
        memo[2] = 2;

        for (int steps = 3; steps <= top ; steps++) {
            int oneStep =
            memo[steps] = memo[steps-1] + memo[steps-2];
        }
        return memo[top];
    }


    public static void main(String[] args) {

        int top = 43;

//      int result1 = climbStairs1(top);
//      int result2 = climbStairs2(top);
        int result3 = climbStairs3(top);
        System.out.println(result3);

    }




}
