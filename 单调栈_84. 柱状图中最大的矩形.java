//https://leetcode.cn/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/
//84. 柱状图中最大的矩形
//单调栈。前后两个0哨兵，遍历每次都push，维护递增栈，while当前heights小于栈顶，height出栈，width与次高index相关，更新面积。


import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int largestRectangleArea(int[] heights) {
        int[] h = new int[heights.length+2];
        h[0] = 0;
        h[h.length-1] = 0;
        for (int i=1;i<h.length-1;i++)
            h[i] = heights[i-1];
        Deque<Integer> q= new ArrayDeque<>();
        q.push(0);
        int area = 0;
        for(int i=1;i<h.length;i++){
            while (h[i]<h[q.peek()]){
                int height = h[q.pop()];
                int width = i-q.peek()-1;
                area = Math.max(area,height*width);
            }
            q.push(i);
        }
        return area;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        //int[] heights = {1, 1};
        Solution solution = new Solution();
        int res = solution.largestRectangleArea(heights);
        System.out.println(res);
    }
}