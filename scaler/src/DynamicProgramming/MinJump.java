package DynamicProgramming;

public class MinJump {

    public int jump(int[] nums) {
        int curEnd = 0;
        int curFarthest = 0;
        int jumpStep = 0;

        if(nums[0]==0 && nums.length>1)return -1;

        for (int i = 0; i <nums.length -1 ; i++) {
            curFarthest = Math.max(curFarthest, nums[i] + i);
            if(i == curEnd)
            {
                jumpStep++;
                curEnd = curFarthest;
            }
            if(curEnd >= nums.length -1)break;

        }
        return jumpStep;
    }

}


//diff: medium-hard
//thinking : hard
//implementing - medium hard
//
//hint : think how far you can go from current position
//
//D.P = t.c = O(n^2)
//Optimised: t.c =O(n)