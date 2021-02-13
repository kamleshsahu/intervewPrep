package Heaps;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestInStream {

        Queue<Integer> minheap = new PriorityQueue<>();
        int k;
        public KthLargestInStream(int k, int[] nums) {
            this.k = k;
            for(int item:nums){
                minheap.add(item);
                if(minheap.size()>k)
                    minheap.poll();
            }
        }

        public int add(int val) {
            if(minheap.size()<k || val>minheap.peek())
            {
                minheap.add(val);
                if(minheap.size()>k)
                    minheap.poll();
            }
            return minheap.peek();
        }

}

// logic:easy
//impl : easy
//t.c = O(n)
//s.c = O(n)