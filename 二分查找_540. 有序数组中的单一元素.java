/*
https://leetcode.cn/problems/single-element-in-a-sorted-array/solution/you-xu-shu-zu-zhong-de-dan-yi-yuan-su-by-y8gh/
540. 有序数组中的单一元素
m^1 异或^ 当m为偶数是为m+1， 否则m-1。二分找到分界点。

*/


class Solution {
    public int singleNonDuplicate(int[] nums) {
        int i=0, j = nums.length-1;
        while(i<j){
            int m = i+j >> 1;
            if(nums[m]== nums[m^1])
                i = m+1;
            else
                j = m;
        }
        return nums[i];
    }
}