package Sorting;

import java.util.Collections;
import java.util.LinkedList;

public class BusAndPassenger {

    public int[] solve(int[] A, String B) {

        LinkedList<Pair> queue = new LinkedList<>();

        for (int i = 0; i < A.length; i++) {
            queue.add(new Pair(i + 1, A[i]));
        }

        Collections.sort(queue);

        int ans[] = new int[2 * A.length];
        int i = 0;

        while (i < B.length()) {

            if (B.charAt(i) == '0') {
                Pair temp = ((LinkedList<Pair>) queue).pollFirst();
                queue.add(temp);
                ans[i] = temp.index;
            } else {
                ans[i] = ((LinkedList<Pair>) queue).pollLast().index;
            }

            i++;
        }

        return ans;
    }

    class Pair implements Comparable<Pair> {
        int val;
        int index;

        Pair(int index, int val) {
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(val, o.val);
        }
    }
}
