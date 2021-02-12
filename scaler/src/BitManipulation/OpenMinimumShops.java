package BitManipulation;

import java.util.HashMap;
import java.util.Map;

public class OpenMinimumShops {
        public int solve(int A, int B, int[][] C, int D, int[][] E) {
            int reqItems = calcRequiredItems(E);
            int itemsInShop[] = calcItemsInAShop(C);

            dp = new HashMap<>();

            int ans = recur(itemsInShop, reqItems, 0, 0);
            return ans > 20 ? -1 : ans;
        }

        Map<String, Integer> dp;

        int recur(int[] itemsInShop, int reqItems, int currItems, int i) {
            // all required items bought
            if ((currItems & reqItems) == reqItems) {
                return 0;
            }

            //reached end
            if (i == itemsInShop.length) {
                return 21;
            }

            String key = i + "." + currItems;
            if (dp.containsKey(key))
                return dp.get(key);

            int ans = 21;

            // buy from the shop
            int option1 = 1 + recur(itemsInShop, reqItems, currItems | itemsInShop[i], i + 1);
            // skip the shop
            int option2 = recur(itemsInShop, reqItems, currItems, i + 1);

            ans = Math.min(option1, option2);
            dp.put(key, ans);
            return ans;
        }

        int calcRequiredItems(int[][] E) {
            int reqItems = 0;
            for (int[] p : E) {
                int item = p[1];
                reqItems |= 1 << item;
            }
            return reqItems;
        }

        int[] calcItemsInAShop(int[][] C) {
            int[] itemsInShop = new int[21];

            for (int[] item : C) {
                int shopno = item[0];
                int itemno = item[1];
                itemsInShop[shopno] |= 1 << itemno;
            }
            return itemsInShop;
        }

}
// remove the noise
// check the boundry conditions
// think of brute force approach
// draw the recursion tree
// t.c = O(2^n) for brute force
// t.c = O(n), s.c = O(n) for dp

