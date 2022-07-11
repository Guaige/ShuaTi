//https://leetcode.cn/problems/valid-triangle-number/solution/you-xiao-san-jiao-xing-de-ge-shu-by-leet-t2td/
//双指针，在数组中判断构成三角形个数

class Solution {
    public int triangleNumber(int[] nums) {
    int ans=0;
    Arrays.sort(nums);
     for(int i=nums.length-1;i>=2;i--){
        int x3=nums[i];
        int j=i-1,k=0;
        while(k<j){
            if(nums[k]+nums[j]>x3){
             ans+=j-k;
             j--;
            }
            else k++;
        }
     }
     return ans;
    }
}