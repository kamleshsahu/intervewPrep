package TwoPointers;

import java.util.Arrays;

public class MinDiffBetweenMinAndMax {

    public static void main(String[] args) {
        int arr[] = {6,5,3,2,2,4,5,6,4,3,4,5,6};
        System.out.println(minDiff(arr));
    }

    static int minDiff(int[] arr){
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();

        int prev=-1;
        int curr = 0;
        int ans = Integer.MAX_VALUE;

        while(curr<arr.length){
            if(arr[curr]==min || arr[curr]==max){
                if(prev!=-1 && arr[curr]!=arr[prev]){
                    ans = Math.min(ans,curr-prev);
                    prev = curr;
                }else if(prev==-1){
                    prev = curr;
                }
            }
            curr++;
        }

        return ans;
    }
}
//hint : try to remove the unnessory parts, then try to solve
//impl : easy
//logic : easy
//t.c : O(n)