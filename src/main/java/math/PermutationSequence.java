package math;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class PermutationSequence {

    public Integer[] calculate(int n, int k) {
        int fact[] = new int[n + 1];

        fact[0] = 1;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
            set.add(i);
        }
        if (fact[n] < k) {
            return null;
        }

        List<Integer> output = new LinkedList<>();
        this.calculate(set, k, fact, output);
        return output.toArray(new Integer[n]);
    }

    private void calculate(TreeSet<Integer> set, int k, int[] fact, List<Integer> output) {
        int n = set.size();
        if (n == 0) {
            return;
        }

        Iterator<Integer> iterator = set.iterator();
        Integer x = iterator.next();
        while (k > fact[n - 1]) {
            k -= fact[n - 1];
            x = iterator.next();
        }

        output.add(x);
        iterator.remove();
        this.calculate(set, k, fact, output);
    }
}
