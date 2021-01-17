package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TuplewithSameProduct {

    public static void main(String[] args) {

        int arr1[] = {2,3,4,6};

        int arr2[] = {1,2,4,5,10};
        System.out.println(tupleSameProduct(arr1));
        System.out.println(tupleSameProduct(arr2));

        int arr3[]={2,3,4,6,8,12};
        System.out.println(tupleSameProduct(arr3));


        int arr4[]={2,3,5,7};
        System.out.println(tupleSameProduct(arr4));

    }

//   static public int tupleSameProduct(int[] nums) {
//
//        HashMap<Integer,Integer> map = new HashMap<>();
//
//        for (int i = 0; i <nums.length; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                int val = nums[i]*nums[j];
//
//                map.put(val,map.getOrDefault(val,0)+1);
//            }
//        }
//
//       System.out.println(map);
//
//        int ans =0;
//
//        for(int count: map.values()){
//           if(count>1)
//           ans +=perm(count)*2*2;
//           //ans +=(int)Math.pow(count-1,2);
//        }
//        return ans;
//    }

    static public int tupleSameProduct(int[] nums) {

       // HashMap<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(int num:nums){
            set.add(num);
        }

        int ans =0;
        for (int i = 0; i <nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i==j)continue;
                for (int k = 0; k < nums.length; k++) {
                    if(i==k || j==k)continue;
                    int l = (nums[i]*nums[j])/nums[k];
                    if((nums[i]*nums[j])%nums[k]==0 && set.contains(l) &&
                       l!=nums[i] && l!=nums[j] && l!=nums[k])
                    {
                      //  System.out.println(nums[i]+" "+nums[j]+" "+nums[k]+ " " + (nums[i]*nums[j])/nums[k]);
                        ans++;
                    }
                }
            }
        }

//        System.out.println(map);
//
//
//        for(int count: map.values()){
//            if(count>1)
//                ans +=perm(count)*2*2;
//            //ans +=(int)Math.pow(count-1,2);
//        }
        return ans;
    }

    public static int perm(int n){
        return (factorial(n) / (factorial(n - 2)));
    }

    public static int factorial(int n) {
        //1
        int fact = 1;
        //2
        for (int i = 1; i <= n; i++) {
            //3
            fact = fact * i;
        }
        //4
        return fact;
    }
}
