import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder stream = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        int i = 0;
        int j = m;
        while (i < (t - 1) * m + p) {
            stream.append(Integer.toString(i, n));
            char c = stream.charAt(i);
            int mod = (i + 1) % m;
            if (mod == p || (m == p && mod == 0)) {
                if (Character.isAlphabetic(c)) {
                    answer.append(Character.toUpperCase(c));
                }
                if (Character.isDigit(c)) {
                    answer.append(c);
                }
            }
            i += 1;
        }
        return answer.toString();
    }
}