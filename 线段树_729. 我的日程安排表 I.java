/*
https://leetcode.cn/problems/my-calendar-i/solution/by-lfool-xvpv/
729. 我的日程安排表 I
线段树模板
	pushUp 	返回左右子树最大值（模版是和）
	pushDown 左右空，新建
				节点add为0（标记），直接返回
				左右val += add
				左右add += add
				节点add 为0
	update	 传入当前节点val
		二分已在当前区间内部
			更新node.val
				node.add
			返回
		pushDown
		二分递归更新左右子树
		pushUp
	query	不传val，须返回val
		二分在区间内
			返回val
		pushDown
		二分递归查找左右子树
		右子树继续维护最大返回值

题目：
	先看当前区间能否查询，不为0，说明冲突，直接返回
	更新线段树，返回


注：大N 1e9 不能更改
    递归右子树为闭区间


*/


class MyCalendar {
    class TreeNode{
        TreeNode left,right;
        int val,add;
    }
    int N = (int)1e9;
    TreeNode node = new TreeNode();
    void puUp(TreeNode node){
        node.val = Math.max(node.left.val, node.right.val);
    }
    void puDown(TreeNode node){
        if(node.left==null)
            node.left = new TreeNode();
        if(node.right==null)
            node.right = new TreeNode();
        if(node.add==0)
            return;
        node.left.val += node.add;
        node.right.val += node.add;
        node.left.add += node.add;
        node.right.add += node.add;
        node.add = 0;
    }
    void update(TreeNode node, int start, int end, int l, int r, int val){
        if(l<=start && r >=end){
            node.val += val;
            node.add += val;
            return;
        }
        puDown(node);
        int m = start + end >> 1;
        if(l<=m)
            update(node.left,start, m,l,r,val);
        if(r>m)
            update(node.right,m+1,end,l,r,val);
        puUp(node);
    }
    int query(TreeNode node,int start, int end, int l, int r){
        if(l<=start && r >= end)
            return node.val;
        puDown(node);
        int m = start + end >> 1, ans = 0;
        if(l<=m)
            ans = query(node.left,start,m,l,r);
        if(r>m)
            ans = Math.max(ans, query(node.right,m+1,end,l,r));
        //puUp(node);
        return ans;
    }
    public MyCalendar() {

    }
    
    public boolean book(int start, int end) {
        if(query(node, 0, N, start, end-1)!=0)
            return false;
        update(node,0,N,start,end-1,1);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */