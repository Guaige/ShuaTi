https://leetcode.cn/problems/daily-temperatures/solution/mei-ri-wen-du-by-leetcode-solution/
//739. 每日温度
//单调栈，只维护递减index，遇到高index，出栈，保持栈递减。出栈同时更新出栈位置的距离。

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> q = new ArrayDeque<>();
        int[] ans = new int[temperatures.length];
        for (int i=0;i<temperatures.length;i++){
            while(!q.isEmpty() && temperatures[i]>temperatures[q.peek()]){
                int pre = q.pop();
                ans[pre] = i-pre;
            }
            q.push(i);
        }
        return ans;
    }
}