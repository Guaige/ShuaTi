//https://leetcode.cn/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetc-2/
//3. 无重复字符的最长子串
//双指针，遍历之前去掉set前一个字符（i-1），同时更新j和set



class Solution {
    public int lengthOfLongestSubstring(String s) {
        int r=0;
        Set<Character> set = new HashSet<>();
        int j=0;
        for(int i=0;i<s.length();i++){
            if (i!=0)
                set.remove(s.charAt(i-1));
            while (j<s.length() && !set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
            }
            r = Math.max(r,j-i);
        }
        return r;
    }
}