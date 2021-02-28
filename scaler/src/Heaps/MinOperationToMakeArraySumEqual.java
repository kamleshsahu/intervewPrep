package Heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinOperationToMakeArraySumEqual {

    public int minOperations(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        int s1 = Arrays.stream(nums1).sum();
        int s2 = Arrays.stream(nums2).sum();

        if (nums1.length > nums2.length * 6
                || nums2.length > nums1.length * 6)
            return -1;

        int small[], big[];

        if (s1 < s2) {
            small = nums1;
            big = nums2;
        } else {
            int temp = s2;
            s2 = s1;
            s1 = temp;
            small = nums2;
            big = nums1;
        }

        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        int count = 0;

        for (int item : small) minHeap.add(item);
        for (int item : big) maxHeap.add(item);

        while (s1 < s2) {

            int o1 = minHeap.isEmpty() ? 0 : 6 - minHeap.peek();
            int o2 = maxHeap.isEmpty() ? 0 : maxHeap.peek() - 1;
            if (o1 == 0 && o2 == 0)
                break;
            if (o1 > o2) {
                s1 += o1;
                minHeap.poll();
            } else {
                s2 -= o2;
                maxHeap.poll();
            }

            count++;
        }

        return count;
    }
}
