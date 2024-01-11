# 문제 풀이

## 문제 해설

본 문제는 단순한 구현 문제로 진수 변환만 잘 해결하면 아주 쉽게 풀 수 있다. 매 순간마다 진수 변환한 것을 `stream`의 뒤에 덧붙이고, 튜브의 순서가 될 때마다 `answer`에 들어갈 문자를 구하면 된다.

## 시간 복잡도

진수가 `n`라고 하면 10진수를 `i`진수로 변환하는데 걸리는 시간은 $O(log_n(i))$이다. 진수 변환은 10진수 `i`을 더 이상 나눌 수 없을 때까지 `n`로 계속 나누기 때문이다.

진수 변환 $O(log_n(i))$를 `while` 문 안에서 `(t - 1) * m + p`번 하기 때문에, 전체 시간 복잡도는 $O(log_n(i) \times ((t - 1) * m + p))$이다. `i`의 최대값은 `(t - 1) * m + p - 1`이므로 이를 정리하면 $O(log_n(tm) \times tm)$이라고 할 수 있다. `t * m`은 최대 $10^5$이므로 시간 내 계산 가능하다.

```java
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
```