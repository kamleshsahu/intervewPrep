package DynamicProgramming;

import java.util.Arrays;

public class DistinctSubsequences {

    class Tabulation {
        public int numDistinct(String s, String t) {
            int n = s.length();       // length of String(s) in which sequence of String(t) is tobe counted
            int m = t.length();      //  length of target String(t)

            long dp[][] = new long[n + 1][1 + m];

            for (int i = 0; i <= n; i++)
                dp[i][0] = 1;           //base case: fisrt i chars in S will always match first 0 chars in t(target)

            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < m + 1; j++) {
                    if (s.charAt(i - 1) == t.charAt(j - 1))
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];//not match+match
                    else
                        dp[i][j] = dp[i - 1][j];                   //not match

                }

            }
            return (int) dp[n][m];
        }
    }

    class Recursion {

        private String S;
        private String T;
        int[][] dp;
        int n;
        int nT;

        public int numDistinct(String S, String T) {
            if (T.length() > S.length())
                return 0;

            n = S.length();
            nT = T.length();
            this.S = S;
            this.T = T;
            dp = new int[n][nT];

            for (int i = 0; i < n; i++)
                Arrays.fill(dp[i], -1);

            return rec(0, 0);
        }

        public int rec(int sIndex, int tIndex) {

            if (tIndex == nT)
                return 1;

            if (sIndex >= n)
                return 0;

            if (dp[sIndex][tIndex] != -1)
                return dp[sIndex][tIndex];

            int res = 0;

            if (S.charAt(sIndex) == T.charAt(tIndex))
                res = rec(sIndex + 1, tIndex + 1);

            res += rec(sIndex + 1, tIndex);

            return dp[sIndex][tIndex] = res;

        }

    }
}

//diff : medium-easy
//implementation : easy
//
//T.C = O(n^2)
//S.C = O(n^2)