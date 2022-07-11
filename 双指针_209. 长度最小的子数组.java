//https://leetcode.cn/problems/2VG8Kg/solution/he-da-yu-deng-yu-target-de-zui-duan-zi-s-ixef/
//209. 长度最小的子数组
//思路：双指针，开始都指向0，当和大于target时，更新size，更新和，更新左边界。否则更新右边界。不需要排序。
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums.length==1)  return nums[0]>=target ? 1 : 0;
        int i=0,j=0,sum=0,len=Integer.MAX_VALUE;
        while(j<nums.length){
            sum += nums[j];
            while (sum >= target){
                len = Math.min(len,j-i+1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return len==Integer.MAX_VALUE ? 0 : len;
    }
}