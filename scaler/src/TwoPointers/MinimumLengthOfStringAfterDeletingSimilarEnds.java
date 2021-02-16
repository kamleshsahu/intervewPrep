package TwoPointers;

public class MinimumLengthOfStringAfterDeletingSimilarEnds {

    class Solution {
        String s;

        public int minimumLength(String s) {
            if (s.length() <= 1)
                return s.length();

            this.s = s;
            int i = 0;
            int j = s.length() - 1;

            while (i < j && check(i, j)) {

                int k = moveFromLeft(i);
                int l = moveFromRight(j);
                if (l <= k)
                    return 0;
                i = k + 1;
                j = l - 1;
            }

            return j - i + 1;
        }

        boolean check(int i, int j) {
            return s.charAt(i) == s.charAt(j);
        }

        int moveFromLeft(int i) {
            char c = s.charAt(i);
            while (i < s.length()) {
                if (s.charAt(i) != c)
                    break;
                i++;
            }
            return i - 1;
        }

        int moveFromRight(int i) {
            char c = s.charAt(i);
            while (i >= 0) {
                if (s.charAt(i) != c)
                    break;
                i--;
            }
            return i + 1;
        }


    }
}
