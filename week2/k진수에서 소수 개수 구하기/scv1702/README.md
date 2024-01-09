# 문제 풀이

## 문제 해설

본 문제는 진수 변환과 소수 판단 문제를 섞은 문제이다. `P`의 조건을 잘 생각해보면, `P`는 진수 변환한 수에서 0을 기준으로 자른 토큰들 중 소수라는 것을 알 수 있다. 진수 변환은 Java의 Wrapper 클래스의 API인 `Integer.toString()`을 이용하면 쉽게 진수 변환이 가능하다. 소수 판단은 다양한 방법이 있는데, 에라토스테네스의 체와 판단할 수의 제곱근까지 모두 나눠보는 방법이 알고리즘 문제에서 가장 많이 쓰인다. 다만 에라토스테네스의 체는 소수 판단을 할 수의 범위를 미리 알고 있고, 이를 메모리에 먼저 계산해 놓아야 한다는 점이 있다. 필자는 본 문제에서 소수 판단을 할 수의 범위를 미리 파악할 수 없다고 생각해 제곱근까지 모두 나눠보는 방법을 사용했다.

## 시간 복잡도

진수가 `k`라고 하면 10진수를 `k`진수로 변환하는데 걸리는 시간은 $O(log_k(n))$이다. 진수 변환은 10진수 `n`을 더 이상 나눌 수 없을 때까지 `k`로 계속 나누기 때문이다. `n`을 진수 변환한 `s`의 길이 또한 $O(log_k(n))$이다. (정확히 말하자면, $log_k(n)$가 정수라면 $log_k(n) + 1$이고 그렇지 않으면 $\lceil log_k(n) \rceil$이다.)

`P`의 개수는 `s`마다 다르겠지만, 최악을 생각해보면 0이 두 칸씩 모두 들어가 있는 경우인 `10101010101`와 같은 경우일 것이다. 즉 `P`는 최악의 경우 $\frac{log_k(n)}{2}$개인 것이다. 소수 판별의 시간 복잡도는 2부터 제곱근까지 나누어보니 $O(\sqrt{max(p)})$이다.

그러므로 전체 시간 복잡도는 $O(log_k(n)) + O(\frac{log_k(n)}{2} * \sqrt{max(p)}) = O(\frac{log_k(n)}{2} * \sqrt{max(p)})$이다.

```java
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
```