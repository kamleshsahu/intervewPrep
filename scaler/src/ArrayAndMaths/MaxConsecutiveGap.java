package ArrayAndMaths;

public class MaxConsecutiveGap {

    public int maximumGap(final int[] nums) {

        if (nums.length < 2) return 0;

        float min = Integer.MAX_VALUE;
        float max = 0;
        for (int item : nums) {
            min = Math.min(min, item);
            max = Math.max(max, item);
        }

        float gap = (max - min) / (nums.length - 1);

        int arr[][] = new int[nums.length][2];

        int ans = (int) gap;
        for (int item : nums) {
            int bucket = (int) ((item - min) / gap);

            if (arr[bucket][0] == 0) arr[bucket][0] = item;
            if (arr[bucket][1] == 0) arr[bucket][1] = item;

            arr[bucket][0] = Math.min(arr[bucket][0], item);
            arr[bucket][1] = Math.max(arr[bucket][1], item);
        }

        int curr = 0;
        int prev = -1;
        while (curr < arr.length) {
            prev = curr;
            curr += 1;
            while (curr < arr.length && arr[curr][0] == 0)
                curr++;

            if (curr < arr.length)
                ans = Math.max(arr[curr][0] - arr[prev][1], ans);
        }

        //   System.out.println(Arrays.deepToString(arr));

        return ans;
    }
}

//
//Difficulty: Medium
//Brute Force :
//sort the array
//T.C = O(n log n)
//
//Optimised :
//improved logic: min gap, buckets
//T.C = O(n)
//S.C = O(2n)
