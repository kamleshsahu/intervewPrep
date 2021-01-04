package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class p1 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[0],o1[0]);
            }
        });

        int sum=0;
        int i=0;
        while(truckSize>0 && i<boxTypes.length){
                int count = Math.min(truckSize, boxTypes[i][1]);
                truckSize-=boxTypes[i][1];
                sum+=boxTypes[i][0]*count;
            i++;
        }

        return sum;
    }

}
