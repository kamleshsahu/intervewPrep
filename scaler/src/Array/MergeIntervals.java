package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class MergeIntervals {

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });

        Stack<Interval> stack = new Stack<Interval>();

        for (Interval item : intervals) {

            if (!stack.isEmpty() && stack.peek().end >= item.start) {
                stack.peek().end = Math.max(stack.peek().end, item.end);
            } else {
                stack.push(item);
            }

        }
        return new ArrayList<Interval>(stack);
    }

    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}

//day 6,
//diff : easy
//keyword: stack
//Brute Force:
//T.C = O(n)
