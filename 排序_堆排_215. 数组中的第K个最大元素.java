//https://leetcode.cn/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode-/
//215. 数组中的第K个最大元素

class Solution {
    int[] n;
    public int findKthLargest(int[] nums, int k) {
        n = nums;
        for (int i=n.length/2-1;i>-1;i--)
            adjustHeap(i,n.length);
        for (int i=nums.length-1;i!=nums.length-k;i--){
            int t = n[0];
            n[0] = n[i];
            n[i] = t;
            adjustHeap(0,i);
        }
        return n[0];
    }
    void adjustHeap(int cur,int len){
        int t = n[cur];
        for(int i=2*cur+1;i<len;i=2*i+1){
            if (i+1<len && n[i+1]>n[i])
                i++;
            if (n[i]>t){
                n[cur] = n[i];
                cur = i;
            }
            else break;
        }
        n[cur] = t;
    }
}