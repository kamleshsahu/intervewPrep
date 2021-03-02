package Tree;

public class LongestZigZagPath {

    static int max = 0;
    public static int longestZigZag(TreeNode root) {
        if (root == null) return -1;// if null return -1
        max = 0;
        helper(root.right, 1, true);// go right
        helper(root.left, 1, false);// go left
        return max;
    }

    private static void helper(TreeNode root, int step, boolean isRight) {
        if (root == null) return;
        max = Math.max(max, step);
        if (isRight) {// if coming from right go left
            helper(root.left, step + 1, false);
            helper(root.right, 1, true);//try again from start
        } else {// else coming from left then go right
            helper(root.right, step + 1, true);
            helper(root.left, 1, false);
        }
    }
}
