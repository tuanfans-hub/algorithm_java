package demo005_linkedList;

/**
 * @author TuanFans
 * @time 2026/7/14 15:18
 * <p><a href="https://leetcode.cn/problems/reverse-linked-list-ii/">力扣92. 反转链表 II</a></p>
 */
public class Demo_006_11_ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null || left==right) return head;

        int n = 0;
        ListNode cur = head,LNode=null,RNode=null,LPrev=null,RNext=null;
        while(cur!=null){
            n++;
            if(n+1==left) LPrev = cur;
            if(n==left) LNode = cur;
            if(n==right) RNode = cur;
            if(n-1==right) RNext = cur;
            cur = cur.next;
        }

        if(LPrev!=null) LPrev.next = null;
        if(RNode!=null) RNode.next = null;

        ListNode pre = LNode;
        cur = LNode.next;
        ListNode next = cur.next;
        while(cur!=null){
            cur.next  = pre;
            pre = cur;
            cur = next;
            if(cur!=null) next = cur.next;
        }

        if(LPrev!=null) LPrev.next = RNode;
        LNode.next = RNext;

        return LNode==head?RNode:head;
    }
}
