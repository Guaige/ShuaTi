//只出现一次的数字，其他数字出现三次，构造新门电路
//https://leetcode.cn/problems/WGki4K/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-0vrt/
class Solution {
    public int singleNumber(int[] nums) {
        int a = 0,b = 0;
        for (int n : nums){
            b = ~a & (b ^ n);
            a = ~b & (a ^ n);
        }
        return b;
    }
}