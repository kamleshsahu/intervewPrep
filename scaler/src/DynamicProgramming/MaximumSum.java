package DynamicProgramming;

public class MaximumSum {

    public int solve(int[] A, int B, int C, int D) {
        int left[] = new int[A.length];
        int right[] = new int[A.length];
        left[0] = A[0] * B;
        right[A.length - 1] = A[A.length - 1] * D;
        for (int i = 1; i < A.length; i++) {
            left[i] = Math.max(A[i] * B, left[i - 1]);
        }
        int n = A.length;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(A[i] * D, right[i + 1]);
        }

        int max = -100000;
        for (int i = 0; i < n; i++) {
            int curr = left[i] + (A[i] * C) + right[i];
            max = Math.max(max, curr);
        }
        return max;
    }
}
//hint : if only 2-3 variables are given, then think of prefix/suffix sum or 2 pointer
//logic: medium-easy
//impl : easy
//
//t.c = O(n)
//s.c = o(n)