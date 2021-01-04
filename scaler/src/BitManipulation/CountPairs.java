package BitManipulation;

import java.util.HashMap;
import java.util.Map;

public class CountPairs {
        int mod = 1000000007;
        public int countPairs(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            int n = arr.length;
            long res = 0;
            for (int num : arr) {
                int power = 1;
                for (int i = 0; i < 22; i++) {
                    if (map.containsKey(power - num)) {
                        res += map.get(power - num);
                        res %= mod;
                    }
                    power *= 2;
                }
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            return (int) res;
        }
}

//difficulty : medium-easy
//hint : try to reduce the problem into smaller problem
//bruteforce: O(n^2)
//
//Optimise: hashing
//        t.c = O(n)
//        s.c = O(n)
