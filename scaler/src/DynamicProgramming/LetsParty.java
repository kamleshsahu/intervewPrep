package DynamicProgramming;

public class LetsParty {

    public int solve(int A) {
        dp = new Integer[A+1];
        return recur(A,A);
    }

    int mod=10003;
    Integer dp[];
    int recur(int A,int i) {
        if(i==1 || i==2)
            return i;

        int ans=0;
        if(dp[i]!=null)return dp[i];
        ans = recur(A,i-1)%mod +((i-1)*recur(A,i-2))%mod;

        dp[i]=ans%mod;
        return ans%mod;
    }
}
//keywords : no of ways to party in pair
//hint: try to break the problem into smaller parts
//diff:
//logic: medium-hard
//implementation: easy
//t.c = O(n) , s.c = O(n)