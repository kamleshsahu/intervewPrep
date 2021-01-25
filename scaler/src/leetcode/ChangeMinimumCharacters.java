package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ChangeMinimumCharacters {

    public static void main(String[] args) {

    }

    public int minCharacters(String a, String b) {
       int s1 = a.length();
       int s2 = b.length();

       int maxO=0;

        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> merger = new HashMap<>();
        for(char ch:a.toCharArray()){
            map1.put(ch,map1.getOrDefault(ch,0)+1);
            merger.put(ch,merger.getOrDefault(ch,0)+1);
            maxO = Math.max(maxO, merger.get(ch));
        }

        Map<Character,Integer> map2 = new HashMap<>();

        for(char ch:b.toCharArray()){
            map2.put(ch,map2.getOrDefault(ch,0)+1);
            merger.put(ch,merger.getOrDefault(ch,0)+1);
            maxO = Math.max(maxO, merger.get(ch));
        }

        char min1val = Collections.min(map1.keySet());
        int min1 = map1.get(min1val);
        char min2val = Collections.min(map2.keySet());
        int min2 = map2.get(min2val);
        char max1val = Collections.max(map1.keySet());
        int max1 = map1.get(max1val);
        char max2val = Collections.max(map2.keySet());
        int max2 = map2.get(max2val);

        int ans = s1+s2 - maxO;
        if(min1val == min1val || max1val==max2val){
           ans =Math.min(ans,Math.min(s1,s2));
        }

        if(min1val<min2val){
            ans = Math.min(ans,s1-min1);
        }else if(min1val>min2val){
            ans = Math.min(ans,s2-min2);
        }

        if(max1val>max2val){
            ans = Math.min(ans,s1-max1);
        }else if(max1val<max2val){
            ans = Math.min(ans,s2-max2);
        }

        return ans;
    }
}
