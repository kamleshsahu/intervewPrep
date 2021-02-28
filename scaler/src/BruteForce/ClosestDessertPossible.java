package BruteForce;

public class ClosestDessertPossible {

    int smaller;
    int bigger;
    int n;
    int m;
    int target;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {

        smaller = -1000000;
        bigger =1000000;

        n= baseCosts.length;
        m= toppingCosts.length;
        this.target = target;

        for(int i=0;i<n;i++){
            topping(toppingCosts,baseCosts[i],0);
        }


        if(target-smaller <= bigger-target){
            return smaller;
        }else return bigger;

    }

    void topping(int[] toppingCosts, int curr, int i){

        if(curr>=target){
            bigger = Math.min(curr,bigger);
            return ;
        }

        smaller = Math.max(curr,smaller);

        if(i>=m)
            return;

        topping(toppingCosts,curr,i+1);
        topping(toppingCosts,curr+toppingCosts[i],i+1);
        topping(toppingCosts,curr+2*toppingCosts[i],i+1);
    }

}
