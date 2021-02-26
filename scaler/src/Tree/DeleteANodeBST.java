package Tree;

public class DeleteANodeBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return null;

        if(root.val==key){
            return join(root.left,root.right);
        }

        root.left = deleteNode(root.left,key);
        root.right = deleteNode(root.right,key);

        return root;
    }

    TreeNode join(TreeNode left,TreeNode right){
        if(left==null)
            return right;

        TreeNode leftend = rightend(left);
        leftend.right = right;
        return left;
    }

    TreeNode rightend(TreeNode root){

        if(root.right==null)
            return root;

        return rightend(root.right);
    }
}
