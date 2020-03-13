package interview.google2020;

import java.util.HashSet;

public class UniqueSubstring {

    public String substring(String s) {
        int n = s.length();

        int start = 0;
        int end = 0;
        int max = 0;
        int maxStart = 0;
        HashSet<Character> set = new HashSet<>();

        while(end < n) {
            while (end < n && !set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
            }

            if (end - start > max) {
                max = end - start;
                maxStart = start;
            }

            if (end < n) {
                do {
                    set.remove(s.charAt(start));
                    start++;
                } while(s.charAt(start - 1) != s.charAt(end));
            }
        }

        char[] solution = new char[max];
        for (int i = 0; i < max; i++) {
            solution[i] = s.charAt(maxStart + i);
        }
        return new String(solution);
    }
}
