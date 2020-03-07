package interview.ms2020.demo;

import java.util.HashSet;

public class Solution {

    public int solution(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : A) {
            if (x > 0) {
                set.add(x);
            }
        }

        int k = 1;
        while(set.contains(k)) {
            k++;
        }

        return k;
    }
}
