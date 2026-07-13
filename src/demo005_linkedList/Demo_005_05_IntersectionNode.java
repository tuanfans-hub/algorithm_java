package demo005_linkedList;

/**
 * @author TuanFans
 * @date 2026/7/10
 * <p><a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/">力扣160. 相交链表</a></p>
 */
public class Demo_005_05_IntersectionNode {
    static ListNode getIntersectionNode(ListNode headA,ListNode headB){
        if(headA==null || headB==null) return null;
        if(headA==headB) return headA;
        int AL = 0,BL = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;
        // 统计链表A与链表B的节点数
        while(tempA!=null || tempB!=null){
            if(tempA!=null){
                AL++;
                tempA = tempA.next;
            }
            if(tempB!=null) {
                BL++;
                tempB = tempB.next;
            }
        }

        // 计算差值步，并将较长链表的指针移动差值步个节点
        int delta = AL-BL;
        int step = delta>0?delta:-delta;
        for(int i = 0;i<step;i++){
            if(delta>0) headA=headA.next;
            if(delta<0) headB=headB.next;
        }

        // 同步移动链表指针，找到第一个相等的节点
        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    static void main(){
        // 创建链表A和链表B
        ListNode headA = ListNode.createHeadNode(1); // 创建链表A的头节点
        ListNode headB = ListNode.createHeadNode(3); // 创建链表B的头节点

        // 创建链表A的节点: 1->9->1->2->4
        ListNode node1 = headA.next(9);
        ListNode node2 = node1.next(1);
        ListNode node3 = node2.next(2);
        ListNode node4 = node3.next(4);

        // 创建链表B的节点: 3->2->4
        ListNode node5 = headB.next(node3);

        ListNode ans = getIntersectionNode(headA, headB);
        if(ans==node3) {
            IO.println("ans = "+ans);
            IO.println("node3 = "+node3);
            IO.println("相交节点为：" + node3);
        }
    }
}
