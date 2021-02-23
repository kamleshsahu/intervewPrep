package DynamicProgramming;

public class MaximumScorefromPerformingMultiplicationOperations {

    public int maximumScore(int[] nums, int[] m) {

        int n = nums.length;
        int sum = m.length;

        int dp[][]=new int[sum+1][sum+1];



        for(int k=sum-1;k>=0;k--){
            for(int i=0;i<=k;i++){

                int j  = k-i;

                int o1 = nums[i]*m[k] + dp[i+1][j];
                int o2 = nums[n-j-1]*m[k] + dp[i][j+1];

                dp[i][j] = Math.max(o1,o2);
            }
        }

        return dp[0][0];
    }


    //recursion + memo
    public int maximumScore2(int[] nums, int[] multipliers) {

        dp=new Integer[multipliers.length+1][multipliers.length+1];
        return recur(nums,multipliers,0,0);
    }

    Integer dp[][];
    int recur(int[] nums, int[] m, int i, int k){
        if(k>=m.length)
            return 0;

        if(dp[i][k]!=null)
            return dp[i][k];

        int j= nums.length-(k-i)-1;

        int o1= nums[i]*m[k] + recur(nums,m, i+1,k+1);
        int o2= nums[j]*m[k] + recur(nums,m, i, k+1);


        int ans = Math.max(o1,o2);
        dp[i][k]=ans;
        return ans;
    }
}

// https://leetcode.com/contest/weekly-contest-229/problems/maximum-score-from-performing-multiplication-operations/
// check the limits (constrains) carefully
// rest of questions is simple
// brute force => O(n^3)
// optimise => O(n^2)