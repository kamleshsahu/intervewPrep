package BinarySearch;

public class DistributeCandies {

    long a;
    long b;
    long man;
    public int solve(int man, int a, int b) {
        this.a = a;
        this.b = b;
        this.man = man;

        long low = 1;
        long high = a + b;

        long ans = 0;

        while (low <= high) {
            long mid = (low + high) / 2;

            if (check(mid)) {
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }
        }
        return (int) ans;
    }

    boolean check(long n) {
        if(n==0)return false;
        return ( (a / n) + (b / n) >= man);
    }
}


//hint: guess
//
//diff - medium - easy
//t.c = O(log(n))