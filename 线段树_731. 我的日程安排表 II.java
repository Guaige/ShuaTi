/*
https://leetcode.cn/problems/my-calendar-ii/solution/by-lfool-nodi/
731. 我的日程安排表 II
线段树，本题要求处理三次冲突，因为本线段树每次+1，故main中query返回值查2，则冲突
注意模板实现的细节，如递归的是左右子树，二分是辅助区间的二分，而不是当前查询区间
pushDown 用add判断，更新左右子树的val和add，并且当前节点add标0
update 	 同时更新val和add
main里传区间右值的闭区间，递归右子树也是闭区间
总结:关键还是要理解

*/


class MyCalendarTwo {
    class Node{
        Node left, right;
        int val, add;
    }
    int N = (int)1e9;
    Node node = new Node();
    void pushUp(Node node){
        node.val = Math.max(node.left.val, node.right.val);
    }
    void pushDown(Node node){
        if(node.left==null)
            node.left = new Node();
        if(node.right==null)
            node.right = new Node();
        if(node.add==0)
            return;
        node.left.val += node.add;
        node.right.val += node.add;
        node.left.add += node.add;
        node.right.add += node.add;
        node.add = 0;
    }
    void update(Node node,int start, int end, int l, int r, int val){
        if(l<= start && end <= r){
            node.val += val;
            node.add += val;
            return;
        }
        pushDown(node);
        int m = start + end >> 1;
        if(l<=m)
            update(node.left,start,m,l,r,val);
        if(r>m)
            update(node.right,m+1,end,l,r,val);
        pushUp(node);
    }
    int query(Node node,int start, int end, int l, int r){
        if(l<=start && end<=r)
            return node.val;
        pushDown(node);
        int m = start + end >> 1,ans = 0;
        if(l<=m)
            ans = query(node.left,start,m,l,r);
        if(m<r)
            ans = Math.max(ans, query(node.right,m+1,end,l,r));
        return ans;
    }
    public MyCalendarTwo() {

    }
    
    public boolean book(int start, int end) {
        if(query(node,0,N,start,end-1)==2)
            return false;
        update(node,0,N,start,end-1,1);
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */