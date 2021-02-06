package DynamicProgramming;

public class regexExp2 {

    public int isMatch(final String A, final String B) {
        dp = new Integer[A.length()+1][B.length()+1];
        return recur(A,B,0,0);
    }

    Integer[][] dp;

    int recur(String word, String reg, int i, int j){
        if(isSuperWild(reg))
            return 1;
        if(i==word.length() && (j==reg.length() || isStar(reg.substring(j))))
            return 1;
        else if(i==word.length() || j==reg.length())
            return 0;

        if(dp[i][j]!=null)
            return dp[i][j];

        int ans= 0;
        if(isStar(reg.substring(j))){
            if(isMatch(word.charAt(i),reg.charAt(j))){
                ans = (recur(word,reg,i+1,j) | recur(word,reg,i,j+2));
            }
            else
                ans = recur(word,reg,i,j+2);
        }else if(isMatch(word.charAt(i),reg.charAt(j))){
            ans = recur(word,reg,i+1,j+1);
        }

        dp[i][j]=ans;
        return ans;

    }

    boolean isSuperWild(String x){
        return x.length()>=2 && x.charAt(0)=='.' && x.charAt(1)=='*';
    }

    boolean isStar(String x){
        return x.length()>=2 && x.charAt(1)=='*';
    }

    boolean isMatch(char a,char b){
        return a==b || b=='.';
    }


}
