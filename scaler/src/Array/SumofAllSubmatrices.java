package Array;

public class SumofAllSubmatrices {

        public int solve(int[][] A) {

            int sum=0;
            int n=A.length;

            int p=0,q=0,k=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    p=(i+1)*(j+1);
                    q=(n-i)*(n-j);
                    k=p*q;
                    sum+=k*A[i][j];
                }
            }
            return sum;
        }
}

//day 6
//diff : medium
//brute force:
//t.c = O(n4*n2)
//
//optimise:
//observation, maths
//t.c = O(n2)