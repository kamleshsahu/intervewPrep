package LinkedList;

public class LongestPalindromicLinkList {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public int solve(ListNode head) {
        return maxPalindrome(head);
    }

    // function for counting the common elements
    static int countCommon(ListNode a, ListNode b) {
        int count = 0;

        // loop to count coomon in the list starting
        // from node a and b
        for (; a != null && b != null;
             a = a.next, b = b.next)

            // increment the count for same values
            if (a.val == b.val)
                ++count;
            else
                break;

        return count;
    }

    // Returns length of the longest palindrome
    // sublist in given list
    static int maxPalindrome(ListNode head) {
        int result = 0;
        ListNode prev = null, curr = head;

        // loop till the end of the linked list
        while (curr != null) {
            // The sublist from head to current
            // reversed.
            ListNode next = curr.next;
            curr.next = prev;

            // check for odd length
            // palindrome by finding
            // longest common list elements
            // beginning from prev and
            // from next (We exclude curr)
            result = Math.max(result,
                    2 * countCommon(prev, next) + 1);

            // check for even length palindrome
            // by finding longest common list elements
            // beginning from curr and from next
            result = Math.max(result,
                    2 * countCommon(curr, next));

            // update prev and curr for next iteration
            prev = curr;
            curr = next;
        }
        return result;
    }
}


//broute force: O(n2)
//
//hint : try to optimise on brute force,
//        reverse on the go.
//
//Optimise : O(n)