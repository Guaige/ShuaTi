/*
https://leetcode.cn/problems/distinct-subsequences/solution/bu-tong-de-zi-xu-lie-by-leetcode-solutio-urw3/
115. 不同的子序列
动态规划，注意dp之前，右边赋1的边界，i<=m

*/



class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if(m<n)
            return 0;
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            dp[i][n] = 1;
        for(int i=m-1;i>-1;i--){
            char c1 = s.charAt(i);
            for(int j=n-1;j>-1;j--){
                char c2 = t.charAt(j);
                if(c1==c2)
                    dp[i][j] = dp[i+1][j+1] + dp[i+1][j];
                else
                    dp[i][j] = dp[i+1][j];
            }
        }
        return dp[0][0];
    }
}