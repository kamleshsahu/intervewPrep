package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumTimetoCollectAllApplesinaTree {


    List<Boolean> hasApple;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {

        this.hasApple = hasApple;
        List<TreeNode> nodes = new ArrayList<>(n+1);

        for(int i=0;i<n;i++)nodes.add(new TreeNode(i));
        Set<Integer> visited = new HashSet<>();
        for(int[] edge:edges){
            TreeNode node = nodes.get(edge[0]);
            TreeNode child = nodes.get(edge[1]);

            if(visited.contains(edge[1])){
                TreeNode temp = child;
                child = node;
                node = temp;
            }

            visited.add(edge[0]);
            visited.add(edge[1]);

            node.child.add(child);

        }


        return recur(nodes.get(0),0);
    }




    int recur(TreeNode root, int level){
        if(root==null)
            return 0;

        int count =0 ;

        for(TreeNode child:root.child){
            count += recur(child,level+1);
        }

        if((hasApple.get(root.val) || count>0) && level>0)
            count +=2;


        return count;


    }

    class TreeNode{
        int val;
        List<TreeNode> child = new ArrayList<>();
        TreeNode(int val){
            this.val = val;
        }
    }
}
