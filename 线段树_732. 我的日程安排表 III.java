/*
https://leetcode.cn/problems/my-calendar-iii/solution/by-lfool-jnv9/
732. 我的日程安排表 III
线段树
找到最大冲突次数，直接返回线段树root（大顶堆）

*/


class MyCalendarThree {
    class Node{
        Node left, right;
        int val, add;
    }
    int N = (int)1e9;
    Node node = new Node();
    void pushUp(Node node){
        node.val =  Math.max(node.left.val, node.right.val);
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
    void update(Node node,int start,int end,int l,int r,int val){
        if(l<=start && end<=r){
            node.val += val;
            node.add += val;
            return;
        }
        pushDown(node);
        int m = start + end >> 1;
        if(l<=m)
            update(node.left,start,m,l,r,val);
        if(m<r)
            update(node.right,m+1,end,l,r,val);
        pushUp(node);
    }
    public MyCalendarThree() {

    }
    
    public int book(int start, int end) {
        update(node,0,N,start,end-1,1);
        return node.val;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */