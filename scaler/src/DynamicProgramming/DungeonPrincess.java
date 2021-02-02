package DynamicProgramming;

public class DungeonPrincess {
    public int calculateMinimumHP(int[][] arr) {
        dp = new Integer[arr.length + 1][arr[0].length + 1];
        return Math.abs(go(arr, 0, 0)) + 1;
    }

    Integer dp[][];

    int go(int[][] arr, int i, int j) {
        if (inValid(arr, i, j))
            return -100000;
        if (i == arr.length - 1 && j == arr[0].length - 1) {
            if (arr[i][j] > 0)
                return 0;
            else return arr[i][j];
        }

        if (dp[i][j] != null) return dp[i][j];

        int right = go(arr, i, j + 1);
        int down = go(arr, i + 1, j);

        int ans = Math.max(right, down) + arr[i][j];
        if (ans > 0) ans = 0;

        dp[i][j] = ans;
        return ans;

    }

    boolean inValid(int[][] arr, int i, int j) {
        return (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length);
    }
}


//logic : medium - hard
// impl : medium - easy
// hint : try to break the problem into smaller parts
// T.C = O(n), S.C = O(n)