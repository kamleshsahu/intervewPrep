package Tree;

public class SumEvenValuedGranparent {

    public int sumEvenGrandparent(TreeNode root) {
        return recur(root, false, false);
    }

    int recur(TreeNode root, boolean p, boolean gp) {
        if (root == null)
            return 0;

        int sum = 0;

        if (gp)
            sum = root.val;

        sum += recur(root.left, (root.val % 2) == 0, p);
        sum += recur(root.right, (root.val % 2) == 0, p);

        return sum;
    }
}
