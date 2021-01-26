package Greedy;

import java.util.ArrayList;

public class Bulbs {

    public int bulbs(ArrayList<Integer> a) {
        // To keep track of switch presses so far
        int count = 0;

        int res = 0;
        for (int i = 0; i < a.size(); i++)
        {
            /* if the bulb's original state is on and count
               is even, it is currently on...*/
            /* no need to press this switch */
            if (a.get(i) == 1 && count%2 == 0)
                continue;

            /* If the bulb's original state is off and count
               is odd, it is currently on...*/
                /* no need to press this switch */
            else if(a.get(i) == 0 && count%2 != 0)
                continue;

            /* if the bulb's original state is on and count
               is odd, it is currently off...*/
            /* Press this switch to on the bulb and increase
               the count */
            else if (a.get(i) == 1 && count%2 != 0)
            {
                res++;
                count++;
            }

            /* if the bulb's original state is off and
               count is even, it is currently off...*/
            /* press this switch to on the bulb and
               increase the count */
            else if (a.get(i) == 0 && count%2 == 0)
            {
                res++;
                count++;
            }
        }
        return res;
    }
}

//hint : think brute-force, then try optimise
//diff :
//logic - easy
//T.C : O(n)
