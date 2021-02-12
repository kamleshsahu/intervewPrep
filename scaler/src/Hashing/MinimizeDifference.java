package Hashing;

public class MinimizeDifference {
    public int solve(int[] arr, int B) {

        min = 10000000;
        max = -1;
        int count[] = arrToCountMap(arr);

        while (B > 0 && min < max) {

            if (count[min] <= count[max] && count[min] <= B) {
                count[min + 1] += count[min];
                B -= count[min];
                min++;
            } else if (count[max] <= B) {
                count[max - 1] += count[max];
                B -= count[max];
                max--;
            } else {
                break;
            }

        }

        return max - min;

    }

    int min;
    int max;

    int[] arrToCountMap(int[] arr) {
        int[] count = new int[(int) Math.pow(10, 6) + 1];

        for (int item : arr) {
            count[item]++;
            min = Math.min(item, min);
            max = Math.max(item, max);
        }

        return count;
    }
}

// thinking- medium
// impl - easy
// think is order important in this array, will sorting help
// t.c = O(n)
// s.c = O(n)