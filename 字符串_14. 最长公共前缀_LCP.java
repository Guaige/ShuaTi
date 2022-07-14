//https://leetcode.cn/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
//14. 最长公共前缀 longestCommonPrefix LCP
//纵向扫描 O（n2） 大循环遍历第一个string字符，小循环遍历其余string，if出口 i指针超过j字符长度 或 字符不相等，返回substring

class Solution {
    public String longestCommonPrefix(String[] strs) {
        for(int i=0;i<strs[0].length();i++){
            for (int j=1;j<strs.length;j++){
                if(i==strs[j].length() || strs[j].charAt(i)!=strs[0].charAt(i))
                    return strs[0].substring(0,i);
            }
        }
        return strs[0];
    }
}

