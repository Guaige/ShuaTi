//https://leetcode.cn/problems/kth-largest-element-in-a-stream/solution/shu-ju-liu-zhong-de-di-k-da-yuan-su-by-l-woz8/
//703. 数据流中的第 K 大元素
//堆，优先队列解决TopK


class KthLargest {
    int k;
    PriorityQueue<Integer> q;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>();
        for (int i:nums)
            add(i);
    }
    
    public int add(int val) {
        q.add(val);
        if (q.size()>k)
            q.poll();
        return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */