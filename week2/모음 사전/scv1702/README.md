# 문제 풀이

## 문제 해설

본 문제는 완전 탐색 문제로 사전의 처음부터 원하는 문자열 `word`가 등장할 때까지 모두 세려가는 문제이다. 완전 탐색은 깊이 우선 탐색(Depth-First Search)을 통해 가능하다. 필자는 `alphabets`이라는 배열을 만든 후, 해당 배열에 존재하는 문자들을 통해 만들 수 있는 모든 단어들을 탐색했다. 탐색 도중 `word`에 해당하는 단어를 만나게 되면 탐색을 일찍 종료시켰다. 완전 탐색이 가능한 이유는 탐색 공간의 크기가 $5^5 + 5^4 + 5^3 + 5^2 + 5 = \frac{5^6-5}{4} = 3905$로 아주 작기 때문이다.

## 시간 복잡도

시간 복잡도는 모음의 개수가 $n$이라고 할 때 등비수열의 합 공식인 $O(\frac{n^{n+1}-1}{n-1})$이다.

```java
import java.util.*;

class Solution {
    static final char[] alphabets = { 'A', 'E', 'I', 'O', 'U' }; 
    
    int answer = 0;
    boolean flag = false;
    char[] bukit = new char[5];

    public String bukitToString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= depth; i++) {
            sb.append(bukit[i]);
        }
        return sb.toString();
    }
    
    public void dfs(String word, int depth) {
        if (flag || depth == alphabets.length) {
            return ;    
        }
        
        for (int i = 0; i < alphabets.length; i++) {
            if (!flag) {
                answer += 1;
                bukit[depth] = alphabets[i];
                if (word.equals(bukitToString(depth))) {
                    flag = true;
                    return ;
                }
                dfs(word, depth + 1);
            }
        }
    }
    
    public int solution(String word) {
        dfs(word, 0);
        return answer;
    }
}
```