package BitManipulation;

public class XorQueries {

    public int[][] solve(int[] A, int[][] B) {

        int dp[][]=new int[A.length+1][2];

        int count_0=0,count_1=0;
        for(int i=0;i<A.length;i++){
            if(A[i]==0)
                count_0++;
            else count_1++;

            dp[i+1][0]=count_0;
            dp[i+1][1]=count_1;
        }


        int ans[][]=new int[B.length][2];

        for(int i=0;i<B.length;i++){

            int[] query=B[i];

            int l=query[0]-1;
            int r=query[1];


            int count_zero=dp[r][0]-dp[l][0];
            int count_one= dp[r][1]-dp[l][1];

            if(count_one%2==1)
                ans[i][0]=1;

            ans[i][1]=count_zero;

        }

        return ans;
    }
}


//diff: easy
//keys : prefix array, xor property
//
//brute force:
//O(q*n)
//
//Optimise:
//O(q)