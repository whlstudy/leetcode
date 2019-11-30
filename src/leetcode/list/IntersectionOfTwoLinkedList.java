package leetcode.list;

/**
 * @author whl
 * @date 2019/10/13 3:10 下午
 * <p>
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * A+B= B+A
 */
public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }
}
