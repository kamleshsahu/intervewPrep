package Arrays;

public class SearchingInRowWiseAndColumnWiseSortedMatrix {
    public int solve(int[][] A, int B) {

        int row = 0, col = A[0].length - 1;
        while (row < A.length && col >= 0 && B != A[row][col]) {
            if (B > A[row][col])
                row++;
            else col--;
        }

        if (row >= A.length || col < 0)
            return -1;

        return (row + 1) * 1009 + col + 1;

    }
}

// day 6
// diff : easy
// Brute Force :
// T.C = O(n*m)
// Optimised:
// keyword: already sorted,Binary Search
// T.C = O(n+m)