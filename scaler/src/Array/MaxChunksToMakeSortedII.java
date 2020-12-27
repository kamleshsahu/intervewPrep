package Array;

import java.util.Arrays;

class MaxChunksToMakeSortedII {

    public int solve(int[] arr) {

        int temp[] = Arrays.copyOf(arr, arr.length);

        Arrays.sort(temp);

        int prefix1 = 0;
        int prefix2 = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            prefix1 += temp[i];
            prefix2 += arr[i];
            if (prefix1 == prefix2)
                count++;
        }

        return count;

    }
}
