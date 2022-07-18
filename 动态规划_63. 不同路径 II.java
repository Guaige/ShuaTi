/*
https://leetcode.cn/problems/unique-paths-ii/solution/bu-tong-lu-jing-ii-by-leetcode-solution-2/
63. 不同路径 II
机器人路径总数，有障碍。
构造边界起点数组，当遇到障碍，后边所有均赋0.
*/


class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1)
            return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m && obstacleGrid[i][0]==0;i++)
            dp[i][0] = 1;
        for(int i=0;i<n && obstacleGrid[0][i]==0;i++)
            dp[0][i] = 1;
        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++)
                if(obstacleGrid[i][j]==1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
        return dp[m-1][n-1];
    }
}