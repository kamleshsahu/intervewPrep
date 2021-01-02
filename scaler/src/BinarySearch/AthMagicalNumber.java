package BinarySearch;

public class AthMagicalNumber {
    public int solve(int N, int A, int B) {

        if (B < A) {
            return solve(N, B, A);
        }
        long start = 0, end = Long.MAX_VALUE;
        while (start < end) {
            long mid = start + (end - start) / 2;
            if (check(A, B, mid) < N) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return (int) (start % (1e9 + 7));
    }

    private long check(int A, int B, long mid) {
        long count = 0;
        int lcm = lcm(A, B);

        count += (mid / A);
        if (lcm != B) {
            count += (mid / B);
            count -= (mid / lcm);
        }
        return count;
    }

    public int lcm(int p, int q) {
        return p * q / gcd(p, q);
    }

    private int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }
}


//diff : medium
//keyword : find how many numbers are multiple of given no? math property
//
//t.c = O(log n)