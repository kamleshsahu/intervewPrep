package Tree;

public class GoodNodes {

    public int goodNodes(TreeNode root) {

        int max = Integer.MIN_VALUE;

        return recur(root, max);

    }

    int recur(TreeNode root, int max) {
        if (root == null)
            return 0;

        int curr = 0;

        if (root.val >= max) {
            max = root.val;
            curr++;
        }

        return (recur(root.left, max) + recur(root.right, max) + curr);
    }
}
// thinking : easy
// impl : easy
// t.c : O(n)