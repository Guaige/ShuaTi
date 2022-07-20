/*
https://leetcode.cn/problems/restore-ip-addresses/solution/hui-su-suan-fa-hua-tu-fen-xi-jian-zhi-tiao-jian-by/
93. 复原 IP 地址
回溯，reside表示剩余block（Valid IP四个分段）
dfs出口：cur遍历到输入s末尾，且剩余分段0
for循环遍历当前cur后三位，减枝：cur到string尾，剩余长度比分段*3大
进dfs，先判断isValid（0~255），dfs（cur向右，reside-1） 

*/


class Solution {
    List<String> ans = new ArrayList<>();
    Deque<String> q = new ArrayDeque<>();
    String s;
    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        dfs(0,4);
        return ans;
    }
    boolean isValid(int begin, int i){
        if(i-begin>0 && s.charAt(begin)=='0')
            return false;
        int t = Integer.valueOf(s.substring(begin,i+1));
        return t>=0 && t<=255;
    }
    void dfs(int c, int reside){
        if(c==s.length() && reside==0){
            ans.add(String.join(".", q));
            return;
        }
        for(int i=c;i<c+3;i++){
            if(i==s.length())
                break;
            if(s.length()-i > reside*3)
                continue;
            if(isValid(c,i)){
                q.addLast(s.substring(c,i+1));
                dfs(i+1, reside-1);
                q.removeLast();
            }
        }
    }

}