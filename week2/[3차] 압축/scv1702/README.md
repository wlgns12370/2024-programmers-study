# 문제 풀이

## 문제 해설

본 문제는 문자열 탐색을 기반으로 한 구현 문제이다. 사전에서 현재 입력과 일치하는 가장 긴 문자열 `w`를 찾은 후 해당 문자열의 사전 색인 번호를 출력하고, 입력에서 `w`를 제거하는 과정을 필자는 완전 탐색을 통해 해결했다.

`w` 탐색 시 시작 위치를 `j`, 탐색 위치를 `k`라고 하자. `msg[j:k+1]`가 사전에 포함된다고 했을때, 과연 `msg[j:k+1]`이 `w`임을 보장할 수 있을까? 이는 두 가지 방법으로 가능하다. 

첫 번째 방법은 `k`를 `msg`의 가장 끝인 `msg[:-1]`에서 `j`로 탐색을 하는 것이다. 두 번째 방법은 `msg[j:k+1]`이 사전에 포함되지 않을 때까지 탐색을 하는 것이다. `msg[j:k+1]`이 사전에 포함되지 않는다면 `msg[j:k]`가 `w`가 되기 때문이다. 이는 사전에 포함된 문자열들은 포함되기 전 사전에 존재하던 문자열에서 단어 하나를 이어서 저장을 하기 때문이다. `msg[j:k+1]`이 사전에 포함되지 않는데, 그 이후에 사전에 포함되는 문자열이 존재할 수 없다. `msg`의 길이가 매우 긴 경우에는 두 번째 방법이 더 효과적일 것 같다.

`w`가 `msg`의 마지막 문자열인 경우 포인터를 조작하는 과정에 있어서 엣지 케이스인 경우와 아닐때를 한 번에 처리하는 코드를 작성하기 조금 까다로웠다.

## 시간 복잡도

완전 탐색을 수행하기 때문에 $O(n^2)$이다.

```java
import java.util.*;

class Solution {
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dict = new HashMap<>();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int n = msg.length(); // n <= 1000
        
        // 1. 길이가 1인 모든 단어를 포함하도록 사전을 초기화한다. O(26)
        for (int i = 0; i < alphabet.length(); i++) {
            char c = alphabet.charAt(i);
            dict.put(Character.toString(c), i + 1);
        }
        
        int j = 0;
        while (j < n) { 
            StringBuilder w = new StringBuilder();
            int k = j;
            
            // 2. 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다.
            w.append(msg.charAt(k++));
            while (k < n && dict.containsKey(w.toString())) {
                w.append(msg.charAt(k++));
            }
            if (!dict.containsKey(w.toString())) {
                w.deleteCharAt(w.length() - 1);
                k -= 1;
            }
            
            // 3. w에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거한다.
            answer.add(dict.get(w.toString()));
            j = k;
            
            // 4. 입력에서 처리되지 않은 다음 글자가 남아있다면(c), w+c에 해당하는 단어를 사전에 등록한다.
            if (k < n) {
                char c = msg.charAt(k);
                w.append(c);
                dict.put(w.toString(), dict.size() + 1);
            }
        }
        
        return answer;
    }
}
```