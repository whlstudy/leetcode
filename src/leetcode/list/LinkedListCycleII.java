package leetcode.list;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {

    // 需要额外的空间
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;
        while (p != null){
            if(!set.add(p))
                return p;
            p = p.next;
        }
        return null;
    }

    // TODO 不需要额外空间的
}
