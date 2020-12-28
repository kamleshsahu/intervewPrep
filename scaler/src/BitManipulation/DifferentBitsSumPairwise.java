package BitManipulation;

public class DifferentBitsSumPairwise {

    long mod=(long)Math.pow(10,9)+7l;
    public int cntBits(int[] arr) {

        long n= arr.length;
        long ans = 0; // Initialize result

        // traverse over all bits
        for (int i = 0; i < 32; i++) {

            // count number of elements
            // with i'th bit set
            int count = 0;

            for (int j = 0; j < n; j++)
                if ((arr[j] & (1 << i)) == 0)
                    count++;

            // Add "count * (n - count) * 2"
            // to the answer
            ans += ((count * ((n - count) * 2)%mod)%mod);
            ans%=mod;
        }

        return (int)(ans);

    }
}


//day 12
//diff : easy
//keys: bit count
//
//brute force:
//t.c = O(n^2)
//
//Optimise:
//t.c = O(n*32)
