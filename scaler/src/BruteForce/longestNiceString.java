package BruteForce;

import java.util.HashSet;
import java.util.Set;

public class longestNiceString {

    public String longestNiceSubstring(String s) {
        max  =0;
        ans = "";
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                String curr = s.substring(i,j);
                if(check(curr)){
                    if(curr.length()>max){
                        ans = curr;
                        max = curr.length();
                    }
                }
            }
        }

        return ans;

    }

    int max ;
    String ans;

    boolean check(String s){

        Set<Character> small = new HashSet<>();
        Set<Character> big = new HashSet<>();

        for(Character item:s.toCharArray()){
            if(Character.isUpperCase(item)){
                big.add(Character.toLowerCase(item));
            }else{
                small.add(item);
            }
        }
        return small.equals(big);
    }
}
