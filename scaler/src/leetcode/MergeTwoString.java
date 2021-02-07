package leetcode;

public class MergeTwoString {

    public static void main(String[] args) {
        String a = "aza";
        String b = "aba";
        System.out.println(largestMerge(a, b));
    }

    static public String largestMerge(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0)
            return s1 + s2;
        if (s1.compareTo(s2) >= 0) {
            return s1.charAt(0) + largestMerge(s1.substring(1), s2);
        }
        return s2.charAt(0) + largestMerge(s1, s2.substring(1));
    }
}

// try to break the problem in smaller part,
// check if string comparator is useful to check future
// logic : medium
// impl : easy