package leetcode.list;

/**
 * @author whl
 * @date 2019/10/12 4:14 下午
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {

    // 时间复杂度不达标
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        ListNode head0 = new ListNode(-1);
        head0.next = head;
        ListNode p = head,q = head.next;

        ListNode temp;
        while(q != null){
            if(q.val < p.val){
                temp = head0;
                while(temp.next != p && temp.next.val <= q.val){
                    temp = temp.next;
                }
                p.next = q.next;
                q.next = temp.next;
                temp.next = q;
                q = p.next;
            }else {
                p = p.next;
                q = q.next;
            }
        }
        return head0.next;
    }

    // TODO 归并排序
}
