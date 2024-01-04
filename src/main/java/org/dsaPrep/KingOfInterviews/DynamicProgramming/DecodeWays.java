package org.dsaPrep.KingOfInterviews.DynamicProgramming;
//5th Jan, 2024

//*******************//
//Decode Ways: A message containing letters from A-Z can be encoded into numbers using the following mapping:
//        'A' -> "1"
//        'B' -> "2"
//        ...
//        'Z' -> "26"
//To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse
// of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
//"AAJF" with the grouping (1 1 10 6)
//"KJF" with the grouping (11 10 6)
//Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
//Given a string s containing only digits, return the number of ways to decode it.
//*******************//

public class DecodeWays {

    public static void main(String[] args) {

        System.out.println(decodeWays("111006"));

    }

    //method 1:: really frustated on this one will have to surely come back to this again.
    //similar to climbing stairs, tricky part is where we have to consider 1 to 26 decoding from string
    //which can be done by verifying for 1 and 2 digits at max from given string
    //time :: O(N), space :: O(1)
    private static int decodeWays(String str) {

        char prev = 'Z';
        int waysBefore = 1;
        int waysBeforeThat = 0;
        for (int strIdx = 0; strIdx < str.length(); strIdx++) {

            char current = str.charAt(strIdx);

            int totalWays = current == '0' ? 0 : waysBefore;
            if ((prev == '1') || (prev == '2' && current <= '6')) {
                totalWays += waysBeforeThat;
            }
            prev = current;
            waysBeforeThat = waysBefore;
            waysBefore = totalWays;
        }

        return waysBefore;
    }

    //method 2:: slightly easier way to understand
    //time :: O(N), space :: O(N) (due to dp array)
    public int decodeWays1(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        // Initialize the DP array
        int[] dp = new int[n + 1];
        dp[n] = 1; // There is one way to decode an empty string

        // Fill in the DP array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Check for leading zero
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                // Decode single digit
                dp[i] += dp[i + 1];

                // Decode two digits if possible
                if (i + 1 < n && Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }

        return dp[0];
    }
}
