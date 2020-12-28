package BitManipulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinXORvalue {

    static int mb=31;

    static public int findMinXor(int[] arr) {
        Arrays.parallelSort(arr);

        int n= arr.length;
        int minXor = Integer.MAX_VALUE;
        int val = 0;

        // calculate min xor of consecutive pairs
        for (int i = 0; i < n - 1; i++) {
            val = arr[i] ^ arr[i + 1];
            minXor = Math.min(minXor, val);
        }

        return minXor;
    }

    static void addValue(Trie trie, int val) {
        for (int i = mb; i >= 0; i--) {
            int bit = (val >> i & 1);
            trie.add(bit, new Trie(bit));
            trie = trie.child.get(bit);
        }
    }

    static int max=100000;
    static int search(Trie trie, int val) {
        int temp=0;
        for (int i = mb; i >= 0; i--) {
            int bit=(val >> i & 1);
            if(trie.child.containsKey(bit)) {
                temp |=bit==1?1<<i:0;
                trie = trie.child.get(bit);
            }else if(trie.child.containsKey(1^bit)) {
                temp |=bit==0?1<<i:0;
                trie = trie.child.get(1^bit);
            }else{
                return max;
            }
        }
        return temp;
    }

    static class Trie {
        int val;
        Map<Integer, Trie> child = new HashMap<>();

        Trie(int val){
            this.val=val;
        }

        void add(int val, Trie trie) {
            if (!child.containsKey(val)) ;
            child.put(val, trie);
        }
    }
}
