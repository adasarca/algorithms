package interview.ms2020.task3;

public class Solution {

    public String solution(String riddle) {
        char[] chars = riddle.toCharArray();
        int n = chars.length;

        for (int i = 0; i < n; i++) {
            if (chars[i] != '?') continue;

            char x = (i == 0) ? 'X' : chars[i - 1];
            char y = (i == n - 1) ? 'Y' : chars[i + 1];

            char c = 'a';
            while(c == x || c == y) {
                c++;
            }
            chars[i] = c;
        }
        return new String(chars);
    }
}
