import java.util.*;

class Solution {
    public boolean isPrimeNumber(long n) {
        if (n < 2) return false;
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    public int solution(int n, int k) {
        int answer = 0;
        String s = Integer.toString(n, k);
        StringTokenizer st = new StringTokenizer(s, "0");
        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            if (isPrimeNumber(Long.parseLong(t))) {
                answer += 1;
            }
        }
        return answer;
    }
}