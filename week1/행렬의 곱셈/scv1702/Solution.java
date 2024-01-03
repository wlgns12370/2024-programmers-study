class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int m = arr1.length;
        int k = arr1[0].length;
        int n = arr2[0].length;
        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int p = 0; p < k; p++) {
                    answer[i][j] += arr1[i][p] * arr2[p][j];
                }
            }
        }
        return answer;
    }
}