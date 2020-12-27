package Array;

public class BeggarsOutsideTemple {
    public int[] solve(int baggers, int[][] queries) {
        int start = 0, end = 1, amount = 2;

        int pots[] = new int[baggers];

        for (int[] query : queries) {
            pots[query[start] - 1] += query[amount];
            if (query[end] < baggers)
                pots[query[end]] -= query[amount];
        }

        for (int curr = 1; curr < baggers; curr++) {
            pots[curr] += pots[curr - 1];
        }

        return pots;
    }
}
/*
BruteForce:
        S.C: O(baggers)
        T.C: O(queries*N)

Optimise:
        S.C: O(baggers)
        T.C: O(queries)
*/
