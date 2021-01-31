package leetcode;

import java.util.*;

public class RestoretheArrayFromAdjacentPairs {

    public static void main(String[] args) {

        int arr[][] = {{2, 1}, {3, 4}, {3, 2}};

        System.out.println(Arrays.toString(new RestoretheArrayFromAdjacentPairs().restoreArray(arr)));
    }

    Map<Integer, Node> nodes;
    public int[] restoreArray(int[][] adjacentPairs) {
        nodes = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            connect(pair[0], pair[1]);
        }

        Node head = getHead();

        return traverseList(head);
    }

    Node getHead() {
        Node first = null;
        for (Node node : nodes.values()) {
            if (node.neighbours.size() == 1) {
                first = node;
                break;
            }
        }
        return first;
    }

    class Node {
        int val;
        List<Node> neighbours;

        Node(int val) {
            this.val = val;
            neighbours = new ArrayList<>();
        }
    }

    int[] traverseList(Node curr) {
        List list = new ArrayList();
        list.add(curr.val);
        while (curr.neighbours.size() != 0) {
            Node prev = curr;
            curr = curr.neighbours.get(0);
            // remove the previous visited neighbour
            curr.neighbours.remove(prev);
            list.add(curr.val);
        }
        return convertToInt(list);
    }
    
    int[] convertToInt(List list){
        int arr[] = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) list.get(i);
        }
        return arr;
    }

    void connect(int a, int b) {
        Node node1 = getNode(a);
        Node node2 = getNode(b);
        
        node1.neighbours.add(node2);
        node2.neighbours.add(node1);
    }

    Node getNode(int val) {
        if (!nodes.containsKey(val)) {
            nodes.put(val, new Node(val));
        }
        return nodes.get(val);
    }
}
