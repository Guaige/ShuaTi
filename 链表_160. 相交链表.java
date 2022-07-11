//https://leetcode.cn/problems/3u1WK4/solution/liang-ge-lian-biao-de-di-yi-ge-zhong-he-0msfg/
//https://leetcode.cn/problems/intersection-of-two-linked-lists/solution/xiang-jiao-lian-biao-by-leetcode-solutio-a8jn/
//160. 相交链表
//判断两链表是否相交与某Node：一直循环，到tail时换到另一链表head，知道相等（相交或都为null）

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null || headB==null)
            return null;
        ListNode a = headA,b = headB;
        while (a!=b){
            a = a==null ? headB : a.next;
            b = b==null ? headA : b.next;
        }
        return b;        
    }
}