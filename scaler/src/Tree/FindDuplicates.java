package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicates {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        list = new ArrayList<>();
        map = new HashMap<>();
        vals = new HashMap<>();
        recur(root);

        for(Map.Entry<String,Integer> entry:map.entrySet()){
            String key = entry.getKey();
            int val = entry.getValue();

            if(val>1){
                list.add(vals.get(key));
            }
        }

        return  list;
    }

    List<TreeNode> list;
    Map<String,Integer> map;
    Map<String,TreeNode> vals;
    String recur(TreeNode root){
        if(root==null)
            return "#";

        String left = recur(root.left);
        String right = recur(root.right);

        String curr = root.val + "->" + left +"->" + right;

        int count = map.getOrDefault(curr,0);

        map.put(curr,count+1);
        vals.put(curr,root);
        return curr;
    }
}
// logic : easy-medium
// impl : easy-medimum
// tip: edge cases, handle properly
//t.c = O(n)
// s.c = O(n^2)