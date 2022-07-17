class Solution {
    class Status implements Comparable<Status> {
        int val;
        ListNode ptr;

        Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        public int compareTo(Status status2) {
            return this.val - status2.val;
        }
    }
    PriorityQueue<Status> q = new PriorityQueue<>();
    public ListNode mergeKLists(ListNode[] lists) {
        for (ListNode n: lists)
            if (n!=null)    //注意
                q.offer(new Status(n.val,n));
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (!q.isEmpty()){
            Status s = q.poll();
            cur.next = s.ptr;
            cur = cur.next;
            if (s.ptr.next!=null)
                q.offer(new Status(s.ptr.next.val, s.ptr.next));
        }
        return head.next;

    }
}