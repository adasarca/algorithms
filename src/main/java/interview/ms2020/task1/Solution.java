package interview.ms2020.task1;

public class Solution {

    public int solution(int[] A, int[] B, int N) {
        int M = A.length;
        int[] out = new int[N + 1];

        for (int i = 0; i < M; i++) {
            out[A[i]]++;
            out[B[i]]++;
        }

        int maxRank = 0;
        for (int i = 0; i < M; i++) {
            int rank = out[A[i]] + out[B[i]] - 1;
            if (rank > maxRank)
                maxRank = rank;
        }
        return maxRank;
    }
}
