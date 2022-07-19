/*
https://leetcode.cn/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
22. 括号生成
回溯 DFS，注意两个dfs判断入口，左括号小于总值，右括号小于左括号
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(ans,sb,0,0,n);
        return ans;
    }
    void dfs(List<String> ans, StringBuilder sb, int l, int r,int n){
        if(sb.length()==2*n){
            ans.add(sb.toString());
            return;
        }
        if(l<n){
            sb.append('(');
            dfs(ans,sb,l+1,r,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(r<l){
            sb.append(')');
            dfs(ans,sb,l,r+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}