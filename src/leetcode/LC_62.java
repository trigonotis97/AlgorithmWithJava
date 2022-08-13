package leetcode;

public class LC_62 {
    public static void main(String[] args) {
        Solution_62 s = new Solution_62();
        System.out.println(s.uniquePaths(3,3));
    }
}


class Solution_62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0]=1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0&&j==0) continue;
                else if(i>0&&j>0){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
                else if(i==0){
                    dp[i][j] = dp[i][j - 1];
                }
                else if(j==0){
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}