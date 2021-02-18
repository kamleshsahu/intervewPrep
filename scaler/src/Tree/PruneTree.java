package Tree;

public class PruneTree {

    public TreeNode pruneTree(TreeNode root) {
        return recur(root)?root:null;
    }

    boolean recur(TreeNode root){
        if(root==null)
            return false;

        boolean left = recur(root.left) ;
        boolean right = recur(root.right);

        if(!left)
            root.left = null;
        if(!right)
            root.right = null;

        return (root.val==1 | left | right);
    }
}
// thinking : easy
// impl: easy
// handle edge cases properly
// t.c = O(n)