class Solution {
    public int[] solution(String s) {
        Set<Integer> visited = new HashSet<>(); // 튜플의 모든 원소를 저장하는 집합. 원소 방문 시 해당 원소는 삭제된다.
        List<List<Integer>> setList = new ArrayList<>(); // s를 ArrayList로 변환한 자료구조
        
        // s를 parsing하여 ArrayList로 변환한다. O(s)
        int i = 1;
        while (i < s.length()) {
            List<Integer> set = new ArrayList<>();
            // s의 원소 하나를 StringBuilder에 담는다.
            StringBuilder sb = new StringBuilder();
            if (s.charAt(i) == '{') {
                i += 1;
                while (s.charAt(i) != '}') {
                    sb.append(s.charAt(i++));
                }
            }
            i += 2;
            StringTokenizer st = new StringTokenizer(sb.toString(), ",");
            while (st.hasMoreTokens()) {
                Integer e = Integer.parseInt(st.nextToken());
                set.add(e);
                visited.add(e);
            }
            setList.add(set);
        }
        
        // setList를 길이 순으로 정렬한다. O(slog(s))
        Collections.sort(setList, (List<Integer> s1, List<Integer> s2) -> s1.size() - s2.size());
        
        // 기존의 튜플을 계산한다. O(s)
        int[] answer = new int[visited.size()];
        int answerIdx = 0;
        for (List<Integer> set: setList) {
            for (Integer e: set) {
                if (visited.contains(e)) {
                    answer[answerIdx++] = e;
                    visited.remove(e);
                }
            }
        }
        
        return answer;
    }
}