package demo005_linkedList;

/**
 * @author TuanFans
 * @date 2026/7/11
 * <p><a href="https://leetcode.cn/problems/linked-list-cycle-ii/">力扣142. 环形链表 II</a></p>
 */
public class Demo_006_09_DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) return null;

        ListNode slow = head.next;
        ListNode fast = head.next.next;

        // 快慢指针相遇
        while(fast!=slow){
            if(fast.next==null || fast.next.next==null) return null;
            slow = slow.next;
            fast = fast.next.next;
        }

        // 快指针重新指向头节点
        fast = head;
        // 快慢指针同步前进，相遇点即为环入口
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
