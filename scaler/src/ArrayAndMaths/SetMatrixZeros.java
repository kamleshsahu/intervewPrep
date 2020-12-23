package ArrayAndMaths;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeros {

    int[][] matrix;
    public void setZeroes(int[][] matrix) {
        this.matrix = matrix;
        Set<Integer> cols = new HashSet<>();
        Set<Integer> rows = new HashSet<>();

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int row: rows){
            updateRow(row);
        }

        for(int col: cols){
            updateCol(col);
        }
    }

    public void updateRow(int index){
        for(int j = 0; j < matrix[0].length; j++)
            matrix[index][j] = 0;
    }

    public void updateCol(int index){
        for(int i = 0; i < matrix.length; i++)
            matrix[i][index] = 0;
    }

}
//DAY2 HW
//BRUTE FORCE:
//T.C = O(N2*N)
//
//OPTIMISED :
//T.C = O(N2)
