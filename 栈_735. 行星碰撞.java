//https://leetcode.cn/problems/asteroid-collision/solution/xing-xing-peng-zhuang-by-leetcode-soluti-u3k0/
//735. 行星碰撞
//713-每日一题-栈模拟


class Solution {
    public int[] asteroidCollision(int[] asteroids) {        
        Deque<Integer> q = new ArrayDeque<>();
        for (int i:asteroids){
            boolean isExist=true;
            while (isExist && i<0 && !q.isEmpty() && q.peek()>0){
                isExist = -i > q.peek();
                if (q.peek() <= -i)
                    q.pop();
            }
            if (isExist)
                q.push(i);
        }
        int[] r = new int[q.size()];
        int cur=q.size()-1;
        while(!q.isEmpty())
            r[cur--] = q.pop();
        return r;
    }
}