package Array;

public class RainWaterTrapped {
    public int trap(final int[] height) {

        if(height.length==0)return 0;
        int max=0;
        int n=height.length;

        int left_sofar[]=new int[n];
        int right_sofar[]=new int[n];

        left_sofar[0]=height[0];
        right_sofar[n-1]=height[n-1];

        for(int i=1;i<n;i++){
            left_sofar[i]=Math.max(height[i],left_sofar[i-1]);
        }

        for(int i=n-2;i>=0;i--){
            right_sofar[i]=Math.max(height[i],right_sofar[i+1]);
        }

        for(int i=0;i<n;i++){
            max +=Math.min(right_sofar[i],left_sofar[i])-height[i];
        }

        return max;
    }
}
/*
BruteForce:
t.c = O(n*2)
s.c = O(n)

Optimise:
using left_so_far, right_so_far
t.c = O(n);
s.c = O(n);
*/