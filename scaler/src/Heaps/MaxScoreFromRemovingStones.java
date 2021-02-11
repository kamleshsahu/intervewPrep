package Heaps;

import java.util.PriorityQueue;

public class MaxScoreFromRemovingStones {
    public int maximumScore(int a, int b, int c) {
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        pq.offer(a);
        pq.offer(b);
        pq.offer(c);
        while (pq.size() > 1) {
            int largest = pq.remove();
            int secondLargest = pq.remove();
            sum += 1;
            largest -= 1;
            secondLargest -= 1;
            if (largest > 0)
                pq.add(largest);
            if (secondLargest > 0)
                pq.add(secondLargest);
        }
        return sum;
    }
}

// optimise
// use maths
//t.c = n log(n)