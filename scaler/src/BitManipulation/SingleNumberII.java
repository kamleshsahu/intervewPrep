package BitManipulation;

public class SingleNumberII {
    public int singleNumber(final int[] A) {

        int ans[]=new int[32];
        for(int item:A){
            for(int i=0;i<32;i++){
                if((item>>i&1) ==1)
                    ans[i]++;
            }
        }

        int val=0;

        for(int i=0;i<32;i++){
            if(ans[i]%3!=0){
                val|=1<<i;
            }
        }

        return val;
    }
}


//day 12
//diff: easy
//key : count bits
//
//brute force:
//S.C : O(n)
//
//Optimise:
//T.C : O(n)