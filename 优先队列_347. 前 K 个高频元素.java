/*
https://leetcode.cn/problems/top-k-frequent-elements/solution/qian-k-ge-gao-pin-yuan-su-by-leetcode-solution/
347. 前 K 个高频元素
优先队列，维护堆。待调试
*/


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int i:nums)
            m.put(i,m.getOrDefault(i,0)+1);
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] m,int[] n){
                return m[1] - n[1];
            }
        });
        for(Map.Entry<Integer,Integer> entry : m.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();
            if(q.size() == k){
                if(q.peek()[1] < count){
                    q.poll();
                    q.offer(new int[]{num,count});
                }
            }
            else
                q.offer(new int[]{num,count});
        }
        int[] r = new int[k];
        for(int i=0;i<k;i++)
            r[i] = q.poll()[0];
        return r;
    }
}