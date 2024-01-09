package org.dsaPrep.KingOfInterviews.DynamicProgramming;
//10th Jan, 2024

//*******************//
//Maximum Product Array :: Given an integer array nums, find a subarray that has the largest product,
// and return the product. The test cases are generated so that the answer will fit in a 32-bit integer.
//*******************//

public class MaximumProductSubarray {

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4, -2, -5};

        System.out.println(findMaxProduct(nums));

    }

    private static int findMaxProduct(int[] nums) {
        int maxProduct = 1; int bestProduct = Integer.MIN_VALUE; int minProduct = 1;
        for(int num : nums){
            if(num < 0){
                int temp = minProduct;
                minProduct = maxProduct;
                maxProduct = temp;
            }
            minProduct = Math.min(num, num*minProduct);
            maxProduct = Math.max(num, num*maxProduct);
            bestProduct = Math.max(bestProduct, maxProduct);
        }

        return bestProduct;
    }

}
