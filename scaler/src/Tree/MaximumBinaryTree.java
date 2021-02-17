package Tree;
import Tree.TreeNode;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return recur(nums,0,nums.length-1);
    }

    TreeNode recur(int[] nums, int i, int j){
        if(i>j)
            return null;

        int k = getMaxIndex(nums, i, j);

        TreeNode curr= new TreeNode(nums[k]);

        curr.left = recur(nums,i,k-1);
        curr.right = recur(nums,k+1,j);

        return curr;

    }

    int getMaxIndex(int nums[], int i, int j){
        int max = -1;
        int maxIndex=-1;
        for(int k=i;k<=j;k++){
            if(nums[k]>max){
                max = nums[k];
                maxIndex = k;
            }
        }

        return maxIndex;
    }
}


// break the problem in smaller parts
// thinking : easy
// impl : easy
// t.c = O(n^2)