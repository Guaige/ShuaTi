//https://leetcode.cn/problems/reorder-list/solution/zhong-pai-lian-biao-by-leetcode-solution/
//143. 重排链表
//找中mid，中节点收尾(mid.next=null),传中进反转，合并。

class Solution {
    public void reorderList(ListNode head) {
        ListNode mid = findMid(head);
        ListNode a = head;
        ListNode b = mid.next;
        mid.next = null;
        b = reverse(b);
        merge(a,b);
        /*
        List<Integer> l = new ArrayList<>();
        ListNode cu = head;
        while(cu!=null){
            l.add(cu.val);
            cu = cu.next;
        }
        ListNode hair = new ListNode();
        ListNode cur = hair;
        ListNode tail = new ListNode();
        int i=0,j=l.size()-1;
        while (i<j){
            if (i!=0)
                cur = tail;
            cur.next = new ListNode(l.get(i));
            cur.next.next = new ListNode(l.get(j));
            tail = cur.next.next;
            i++;j--;
        }
        if (i==j){
            tail.next = new ListNode(l.get(i));
            tail=tail.next;
        }
        tail.next=null;
        cur = hair.next;
        ListNode cur1 = head;
        while (cur!=null){
            cur1.next = cur.next;
            cur1 = cur1.next;
            cur = cur.next;
        }
        */   
    }

    ListNode findMid(ListNode head){
        ListNode i = head, j = head;
        while (j.next!=null && j.next.next!=null){
            i = i.next;
            j = j.next.next;
        }
        return i;
    }
    ListNode reverse(ListNode head){
        ListNode cur = head, pre = null;
        while (cur!=null){
            ListNode tem = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tem;
        }
        return pre;
    }

    void merge(ListNode a,ListNode b){
        ListNode t1,t2;
        while (a!=null && b!=null){
            t1 = a.next;
            t2 = b.next;
            a.next = b;
            a = t1;
            b.next = a;
            b = t2;
        }
    }
}