package demo005_linkedList;

/**
 * @author TuanFans
 * @date 2026/7/11
 * <p><a href="https://leetcode.cn/problems/palindrome-linked-list/">力扣234. 回文链表</a></p>
 */
public class Demo_006_08_Palindrome {
    public boolean isPalindrome(ListNode head){
        if(head==null || head.next==null) return true;
        // 确定中点位置
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode pre = slow;
        ListNode cur = pre.next;
        ListNode next;
        // 断开前半段和后半段
        slow.next = null;
        // 反转后半段链表
        while(cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        ListNode start = head;
        ListNode end = pre;
        boolean ans = true;
        // 判断回文
        while(start!=null){
            if(start.val!=end.val){
                ans = false;
                break;
            }
            start = start.next;
            end = end.next;
        }

        // 恢复链表
        cur = pre;
        pre = null;
        while(cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return ans;
    }
}
