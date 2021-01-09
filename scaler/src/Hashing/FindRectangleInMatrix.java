package Hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindRectangleInMatrix {

    public int solve(final int[][] A) {


        Set<String> set=new HashSet<>();

        for(int i=0;i<A.length;i++){
            List<Integer> l1=new ArrayList<>();
            for(int j=0;j<A[0].length;j++){
                if(A[i][j]==1)
                    l1.add(j);
            }

            for(int k=0;k<l1.size();k++){
                for(int p=k+1;p<l1.size();p++){
                    String key=l1.get(k)+"."+l1.get(p);
                    if(set.contains(key))return 1;
                    set.add(key);
                }
            }
        }

        return 0;
    }
}


//diff : easy
//t.c = O(n*m^2)