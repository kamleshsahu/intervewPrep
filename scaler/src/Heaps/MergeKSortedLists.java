package Heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });
        ListNode ans = new ListNode(-1);
        ListNode temp = ans;
        for (ListNode node : a) {
            pq.add(node);
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            temp.next = new ListNode(node.val);
            temp = temp.next;
            if (node.next != null) pq.add(node.next);
        }
        return ans.next;
    }
}

//keyword : standard probem
//time comp: O(n*m)