package Union;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaximumWeightEdgeSum {

    public class Solution {
        long value =0;
        long mod = (long)Math.pow(10,9)+7l;

        public int solve(int[][] arr) {

            PriorityQueue<Edge> pq = new PriorityQueue<>();

            Map<Integer,Node> list = new HashMap<>();
            //List<Node> list= new ArrayList<>();

            for(int[] item:arr){
                int a = item[0];
                int b = item[1];
                int c = item[2];
                pq.add(new Edge(a,b,c));
                list.putIfAbsent(a,new Node(null));
                list.putIfAbsent(b,new Node(null));
            }

            value =0;

            while (!pq.isEmpty()){
                Edge edge =  pq.poll();

                Node a = list.get(edge.a);
                Node b = list.get(edge.b);

                union(a,b,edge.weight);
            }
            return (int)value;
        }

        void union(Node a, Node b,int weight){
            Node p1= getParent(a);
            Node p2= getParent(b);
            value +=(((p1.count*p2.count)%mod)*(weight%mod))%mod;
            value %=mod;
            p2.parent = p1;
            p1.count += p2.count;
            p1.count %= mod;
        }

        Node getParent(Node node){
            if(node.parent!=null){
                return getParent(node.parent);
            }else{
                return node;
            }
        }

        class Node{
            int count=1;
            Node parent;

            public Node(Node parent) {
                this.parent = parent;
            }
        }

        class Edge implements Comparable<Edge>{
            int a;
            int b;
            int weight;

            public Edge(int a, int b, int weight) {
                this.a = a;
                this.b = b;
                this.weight = weight;
            }

            @Override
            public int compareTo(Edge other) {
                return this.weight-other.weight;
            }
        }
    }

}



//hint : order not imp
//diff: logic : medium-easy , implement : medium-hard
//
//t.c = O(n Log n)