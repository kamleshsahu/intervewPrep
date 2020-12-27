package ArrayAndMaths;

import java.util.Arrays;

public class NextPermutation {

    public int[] nextPermutation(int[] number) {

        int i = 0;
        for (i = number.length - 1; i > 0; i--)
            if (number[i - 1] < number[i])
                break;


        if (i != 0) {

            int x = number[i - 1], smallest = i;
            for (int j = i + 1; j < number.length; j++)
                if (number[j] > x && number[j] <= number[smallest])
                    smallest = j;

            int temp = number[i - 1];
            number[i - 1] = number[smallest];
            number[smallest] = temp;

            Arrays.sort(number, i, number.length);
        } else {
            Arrays.sort(number);
        }
        return number;
    }
};

//day 2 , hw
//difficulty = medium , maths, plot 2D graph
//brute force:
//t.c = O(n)