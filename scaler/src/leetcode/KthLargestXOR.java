package leetcode;

import java.util.PriorityQueue;

public class KthLargestXOR {

    public static void main(String[] args) {

    }

    public int kthLargestValue(int[][] matrix, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] ^= ((i>0)?matrix[i-1][j]:0)^((j>0)?matrix[i][j-1]:0);

                if(i>1 && j>1){
                    matrix[i][j] ^=matrix[i-1][j-1];
                }
                pq.add(matrix[i][j]);

                if(pq.size()>k){
                    pq.poll();
                }
            }

        }

        return pq.peek();
    }
}
