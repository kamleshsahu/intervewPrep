package LinkedList;

public class FlatenABinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode flatten(TreeNode root) {

        if (root == null) return root;

        flatten(root.left);
        flatten(root.right);


        if (root.left != null) {
            TreeNode templ = root.left;
            while (templ.right != null) templ = templ.right;
            templ.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        return root;
    }
}

//hint : try to solve for smaller part
//t.c = O (n^2)