package leetcode.list;

/**
 * @author whl
 * @date 2019/10/14 4:08 下午
 *
 *
 * Given a singly linked list, determine if it is a palindrome.
 * 判断单链表是否回文
 *
 * time: O(n) space: O(1)
 *
 * 拆分成二个遍历比较
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode head0 = new ListNode(-1);
        head0.next = head;
        ListNode slow = head,quick = head;
        while(slow.next != null && quick.next != null && quick.next.next != null){
            slow = slow.next;
            quick = quick.next.next;
        }
        ListNode head1 = new ListNode(-1);
        quick = slow.next;
        while(quick != null){
            slow = quick;
            quick = quick.next;
            slow.next = head1.next;
            head1.next = slow;
        }
        slow = head0.next;
        quick = head1.next;
        while(slow != null && quick != null){
            if(slow.val != quick.val) return false;
            slow = slow.next;
            quick = quick.next;
        }

        return true;
    }
}
