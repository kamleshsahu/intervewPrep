package ArrayAndMaths;

public class MaxSumSubarray {

    public int maxSubArray(final int[] A) {


        int max_ending_here = 0;
        int max_sum = 0;


        for (int item : A) {

            max_ending_here += item;

            if (max_ending_here < 0)
                max_ending_here = 0;
            max_sum = Math.max(max_ending_here, max_sum);

        }

        // for all negative  case
        if (max_sum == 0) {
            if (A.length > 0)
                max_sum = A[0];
            for (int item : A) {
                max_sum = Math.max(max_sum, item);
            }
        }

        return max_sum;
    }
}

//day2 hw
//BRUTE FORCE:
//check for all subarray
//t.c = O(n2)
//s.c = O(1)
//
//Optimised:
//kadane's algo
//t.c = O(n)
//s.c = O(1)
