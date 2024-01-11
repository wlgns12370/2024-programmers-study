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