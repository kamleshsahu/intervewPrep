package ArrayAndMaths;

public class MaximumAbsoluteDifference {

        public int maxArr(int[] nums) {

            int max1=Integer.MIN_VALUE,
                    max2=Integer.MIN_VALUE,
                    min1=Integer.MAX_VALUE,
                    min2=Integer.MAX_VALUE;


            for(int i=0;i<nums.length;i++){
                max1=Math.max(max1,nums[i]+i+1);
                min1=Math.min(min1,nums[i]+i+1);
                max2=Math.max(max2,nums[i]-(i+1));
                min2=Math.min(min2,nums[i]-(i+1));
            }

            return Math.max(Math.abs(max1-min1),Math.abs(max2-min2));
        }
}
//Day2
//Difficulty : Easy
//Brute Force:
//T.C = O(n2)
//
//Optimise:
//break the question in cases,compare each val by opening mod
//T.C = O(n)
//
