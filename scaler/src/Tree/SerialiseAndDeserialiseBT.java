package Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerialiseAndDeserialiseBT {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        s(root, sb);
        return sb.toString();
    }

    void s(TreeNode data, StringBuilder sb) {
        if (data == null) {
            sb.append("#").append(",");
            return;
        }

        sb.append(data.val).append(",");

        s(data.left, sb);
        s(data.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));

        return d(q);
    }

    TreeNode d(Queue<String> q) {


        String curr = q.poll();
        if (curr.equals("#"))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(curr));

        root.left = d(q);
        root.right = d(q);

        return root;
    }
}
