package DynamicProgramming;

import java.util.Arrays;

public class BallonBurst {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3};

        System.out.println(Arrays.toString(recur(arr, 0, arr.length - 1)));
    }

    static int ans = 0;
    static int left = 1;
    static int right = 2;

    static int[] recur(int[] arr, int i, int j) {
        if (j - i == 1) {
            return new int[]{0, arr[i], arr[j]};
        }

        int min = Integer.MAX_VALUE;
        int[] currans = new int[3];
        for (int k = i + 1; k < j; k++) {
            int[] leftans = recur(arr, i, k);
            int[] rightans = recur(arr, k, j);

            int curr = leftans[ans] + leftans[left] * arr[k] * rightans[right] + rightans[ans];

            if (curr < min) {
                currans = new int[]{curr, leftans[left], rightans[right]};
                min = curr;
            }
        }
        return currans;
    }
}


// hint : try to break down the problem, think of curr, left, and right
// impl : medium
// login : medium

//Optimisation : not done yet, dp