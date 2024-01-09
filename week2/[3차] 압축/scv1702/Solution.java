import java.util.*;

class Solution {
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dict = new HashMap<>();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int n = msg.length();
        
        // 1. 길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.
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