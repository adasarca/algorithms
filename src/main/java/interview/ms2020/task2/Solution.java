package interview.ms2020.task2;

import java.util.HashMap;

public class Solution {

    public int solution(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int maxSum = -1;
        for (int x : A) {
            int digitSum = 0;
            int aux = x;
            while(aux > 0) {
                int digit = aux % 10;
                digitSum += digit;
                aux /= 10;
            }

            Integer y = map.get(digitSum);
            if (null == y) {
                map.put(digitSum, x);
            } else {
                if (x + y > maxSum) {
                    maxSum = x + y;
                }

                if (x > y) {
                    map.put(digitSum, x);
                }
            }
        }
        return maxSum;
    }
}
