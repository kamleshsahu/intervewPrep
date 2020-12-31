package BinarySearch;

import java.util.Arrays;

public class AggressiveCows {

    public int solve(int[] A, int cows) {

        Arrays.sort(A);

        int l = 0;
        int h = A[A.length - 1];
        int ans = 1;
        while (l < h) {

            int mid = l + (h - l + 1) / 2;

            if (isPossible(A, mid, cows)) {
                l = mid;
            } else {
                h = mid - 1;
            }

        }
        return l;

    }


    boolean isPossible(int A[], int diff, int cows) {

        int last = -1000000001;
        for (int i = 0; i < A.length; i++) {
            if (A[i] - diff >= last) {
                cows--;
                last = A[i];
                if (cows == 0)
                    return true;
            }
        }
        return false;
    }
}
