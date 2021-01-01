package BinarySearch;
public class PaintersPartitionProblem {
    public int paint(int A, int B, int[] C) {

        long mod=10000003l;

        long l=0l;

        long h=0l;

        for(int item:C){
            h+=item;
            l=Math.max(item,l);
        }

        long ans=0l;

        while(l<=h){

            long mid=l+(h-l)/2;

            if(isPossible(C,A,mid)){
                ans=mid;
                h=mid-1;
            }else l=mid+1;

        }

        return (int)(((ans%mod)*(B%mod))%mod);

    }


    boolean isPossible(int wall[],int painters,long guessed_time){

        long curr_time=0;


        int i=0;

        while(i<wall.length){

            while(i<wall.length && curr_time+wall[i]<=guessed_time){
                curr_time+=wall[i];
                i++;
            }
            curr_time=0;
            painters--;
            if(painters<0)
                return false;
        }

        return true;

    }
}
