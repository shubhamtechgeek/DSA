package org.dsaPrep.KingOfInterviews.DynamicProgramming;

public class HouseRobberII {


    private static int houseRobbedII(int[] houses){

        if(houses.length == 1){
            return houses[0];
        }

        int current = 0; int oneStep = houses[0]; int twoStep = 0;

        for(int steps = 1; steps < houses.length-1; steps++) {
            current = Math.max(houses[steps] + twoStep, oneStep);
            twoStep = oneStep;
            oneStep = current;
        }
        int max = oneStep;

        current = 0; oneStep = houses[1]; twoStep = 0;

        for(int steps = 2; steps <= houses.length-1; steps++) {
            current = Math.max(houses[steps] + twoStep, oneStep);
            twoStep = oneStep;
            oneStep = current;
        }

        return Math.max(max, oneStep);
    }

    public static void main(String[] args) {

        int[] houses = {1,2,3,1};
        int[] houses2 = {1,2};
        int[] houses1 = {2,7,9,3,1};

        int result = houseRobbedII(houses1);
        System.out.println(result);
//        int result = houseRobbedII(houses, 0);

    }
}
