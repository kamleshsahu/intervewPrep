package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class SearchforARange {
    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {


        int l=0;
        int h=a.size()-1;

        int start=-1,end=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(a.get(mid)<b){
                l=mid+1;
            }else if(a.get(mid)>b){
                h=mid-1;
            }else if(a.get(mid)==b){
                start=mid;
                h=mid-1;
            }
        }

        l=0;
        h=a.size()-1;

        while(l<=h){
            int mid=l+(h-l)/2;
            if(a.get(mid)<b){
                l=mid+1;
            }else if(a.get(mid)>b){
                h=mid-1;
            }else if(a.get(mid)==b){
                end=mid;
                l=mid+1;
            }
        }

        ArrayList<Integer> list=new ArrayList<>();

        list.add(start);
        list.add(end);

        return list;

    }
}
