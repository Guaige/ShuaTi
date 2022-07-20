/*
https://leetcode.cn/problems/palindrome-partitioning/solution/hui-su-you-hua-jia-liao-dong-tai-gui-hua-by-liweiw/
131. 分割回文串
找出所有分割方案，每个方案都是回文
ans存分割方案，每个方案是Deque，存String（子串）
dfs 出口：指针撞len
剪枝：dfs中出口后for循环，非回文，剪
q里直接加substring

*/

class Solution {
    List<List<String>> ans = new ArrayList<>();
    Deque<String> q = new ArrayDeque<>();
    String s;
    public List<List<String>> partition(String s) {
        this.s = s;
        dfs(0);
        return ans;
    }
    boolean isPalindrome(int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    void dfs(int c){
        if(c==s.length()){
            ans.add(new ArrayList<>(q));
            return;
        }
        for(int i=c;i<s.length();i++){
            if(!isPalindrome(c,i))
                continue;
            q.addLast(s.substring(c,i+1));
            dfs(i+1);
            q.removeLast();
        }
    }
}

//dp
//结果显示，使用string.charAt String.substring dp时间还不如直接判断
//速度上还是应该string.toCharArray
class Solution {
    List<List<String>> ans = new ArrayList<>();
    Deque<String> q = new ArrayDeque<>();
    String s;
    public String[][] partition(String s) {
        this.s = s;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for(int i=0;i<len;i++)
            for(int j=0;j<=i;j++)
                if(s.charAt(i)==s.charAt(j) && (i-j<=2 || dp[j+1][i-1]))
                    dp[j][i] = true;
        dfs(0,dp);
        String[][] r = new String[ans.size()][];
        for(int i=0;i<ans.size();i++){
            r[i] = new String[ans.get(i).size()];
            for(int j=0;j<r[i].length;j++)
                r[i][j] = new String(ans.get(i).get(j));
        }
        return r;
    }
    boolean isPalindrome(int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    void dfs(int c, boolean[][] dp){
        if(c==s.length()){
            ans.add(new ArrayList<>(q));
            return;
        }
        for(int i=c;i<s.length();i++){
            if(!dp[c][i])
                continue;
            q.addLast(s.substring(c,i+1));
            dfs(i+1, dp);
            q.removeLast();
        }
    }
}