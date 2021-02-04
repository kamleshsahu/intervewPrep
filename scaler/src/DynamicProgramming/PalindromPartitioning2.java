package DynamicProgramming;

public class PalindromPartitioning2 {

    public int minCut(String A) {
        dp=new Integer[A.length()+1][A.length()+1];
        return solve(A,0,A.length());
    }

    int mod=(int)Math.pow(10,3)+3;
    Integer dp[][];
    int solve(String A, int i, int j) {
        if (i==j) {
            return 0;
        }else if(i>j)return 100000;

        if(dp[i][j]!=null){
            return dp[i][j];
        }

        if(isPalindrome(A.substring(i,j))){
            return 0;
        }

        int ans=100000;

        for (int k = i; k < j; k++) {
            int part1 = solve(A,i,k);
            int part2 = solve(A,k+1,j);

            ans =1 +Math.min(part1+part2,ans);
        }
        // System.out.println(ans);
        dp[i][j]=ans;
        return ans;
    }




    static boolean isPalindrome(String str)
    {

        // Pointers pointing to the beginning
        // and the end of the string
        int i = 0, j = str.length() - 1;

        // While there are characters toc compare
        while (i < j) {

            // If there is a mismatch
            if (str.charAt(i) != str.charAt(j))
                return false;

            // Increment first pointer and
            // decrement the other
            i++;
            j--;
        }

        // Given string is a palindrome
        return true;
    }
}
// try to break the problem in 2 parts, recursively each time
//logic :  medium - easy
// impl : medium - easy