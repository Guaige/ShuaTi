//https://leetcode.cn/problems/prefix-and-suffix-search/solution/by-ac_oier-ayej/
//745. 前缀和后缀搜索
/*
Trie字典树搜索，后缀字典树倒序建立，搜索时倒序查找遍历。
建树函数，先添加字符对应的idx，子节点为空，再添加idx。（正反两棵树）
查找：正反分别查找，最后看两个idx（两棵树分别遍历到两个尾部节点）的最大公共值。
历史最麻过程，分析：建树使用函数传入头节点，出函数时两棵树还是指向开始。搜索时再用新指针分别搜索
两树，这两个过程均不直接操作树的头节点。
还需透彻研究！
*/

class WordFilter {
    class Trie{
        Trie[] child;
        List<Integer> idxs;
        Trie(){
            child = new Trie[26];
            idxs = new ArrayList<>();
        }
    }
    Trie t1 = new Trie();
    Trie t2 = new Trie();
    void add(Trie cur, String s, int idx, boolean isPref) {
        cur.idxs.add(idx);
        for(int i= isPref ? 0 : s.length()-1;i>-1 && i<s.length();i += isPref ? 1 : -1){
            if(cur.child[s.charAt(i)-'a']==null)
                cur.child[s.charAt(i)-'a'] = new Trie();
            cur = cur.child[s.charAt(i)-'a'];
            cur.idxs.add(idx);
        }
    }

    public WordFilter(String[] ss) {
        for(int i=0;i<ss.length;i++){
            add(t1,ss[i],i,true);
            add(t2,ss[i],i,false);
        }
    }

    public int f(String pref, String suff) {
        Trie cur = t1;
        for(int i=0;i<pref.length();i++){
            if(cur.child[pref.charAt(i)-'a']==null)
                return -1;
            cur = cur.child[pref.charAt(i)-'a'];
        }
        List<Integer> l1 = cur.idxs;
        cur = t2;
        for(int i=suff.length()-1;i>-1;i--){
            if(cur.child[suff.charAt(i)-'a']==null)
                return -1;
            cur = cur.child[suff.charAt(i)-'a'];
        }
        List<Integer> l2 = cur.idxs;
        int i=l1.size()-1,j=l2.size()-1;
        while(i>-1&&j>-1){
            if(l1.get(i)>l2.get(j))
                i--;
            else if (l1.get(i)<l2.get(j))
                j--;
            else return l2.get(j);
        }
        return -1;

    }
}

