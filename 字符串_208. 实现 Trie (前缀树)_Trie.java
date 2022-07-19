//https://leetcode.cn/problems/implement-trie-prefix-tree/solution/shi-xian-trie-qian-zhui-shu-by-leetcode-ti500/
//208. 实现 Trie (前缀树)

/*
Trie字典树，搜索和匹配前缀及字符串。
数据结构：26个子node，boolean结尾标识（只在insert更新）
辅助函数 搜前缀，返回尾部node，同insert相同版式：
    获取当前node：cur
    如果子树对应字符节点为空，新建（插入）或直接退出
    遍历到对应子节点

注意：insert更新isEnd，search全字符判断isEnd
*/



class Trie {
    Trie[] child;
    boolean isEnd;

    public Trie() {
        child = new Trie[26];
        isEnd = false;
    }
    Trie searchPrefix(String pref){
        Trie cur = this;
        for(int i=0;i<pref.length();i++){
            if (cur.child[pref.charAt(i)-'a']==null)
                return null;
            cur = cur.child[pref.charAt(i)-'a'];
        }
        return cur;
    }
    
    public void insert(String word) {
        Trie cur = this;
        for(int i=0;i<word.length();i++){
            if(cur.child[word.charAt(i)-'a']==null)
                cur.child[word.charAt(i)-'a'] = new Trie();
            cur = cur.child[word.charAt(i)-'a'];
        }
        cur.isEnd = true;
    }
    
    public boolean search(String word) {
        //Trie root = this;
        return searchPrefix(word)!=null && searchPrefix(word).isEnd;
    }
    
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix)!=null;
    }
}

