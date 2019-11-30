package leetcode.list;

/**
 * 判断一个链表是否有环
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode p = head,q = head;
        while(p.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
            if(p == q) return true;
        }
        return false;
    }
}
