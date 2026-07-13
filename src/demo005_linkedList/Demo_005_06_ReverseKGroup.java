package demo005_linkedList;

/**
 * @author TuanFans
 * @date 2026/7/10
 * <p><a href="https://leetcode.cn/problems/reverse-nodes-in-k-group/">力扣25. K 个一组翻转链表</a></p>
 */
public class Demo_005_06_ReverseKGroup {
    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode pre = head;
        ListNode cur = head;
        ListNode nxt;
        ListNode keep = new ListNode();

        int i = 1;
        while(cur!=null){
            // 如果当前节点为第一个k的节点，该节点为重构后的链表头节点
            if(i==k) head = cur;

            // 当i%k==0时，说明需要反转前一段链表了
            if(i%k==0){
                // 保存下一段链表的起始节点
                nxt = cur.next;
                // 将上一段链表的最后一个节点连接到当前段链表
                keep.next = cur;
                ListNode temp;
                // 反转链表
                while(cur!=pre){
                    temp = pre;
                    while(temp.next!=cur){
                        temp = temp.next;
                    }
                    cur.next = temp;
                    cur = temp;
                }
                // keep保存当前的最后一个节点
                keep = pre;
                cur = keep;
                // 连接下一段链表，便于cur指针移动
                pre.next = nxt;
                pre = nxt;
            }
            // 移动指针
            cur = cur.next;
            i++;
        }

        return head;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        // 第一个链表处理
        ListNode start = head;
        ListNode end = nodeWithEnd(start,k);
        if(end==null) return head;
        head = end;
        reverse(start,end);

        // 其他组的链表处理
        ListNode lastEnd = start;
        while(lastEnd.next!=null){
            start = lastEnd.next;
            end = nodeWithEnd(start,k);
            if(end==null) break;
            reverse(start,end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }

    // 返回改组的最后一个节点
    public ListNode nodeWithEnd(ListNode start,int k){
        ListNode temp = start;
        // 为什么时--k，而不是k--？
        // 因为k个节点只需要移动k-1 次指针
        while(--k !=0 && temp!=null){
            temp = temp.next;
        }
        return temp;
    }

    // 反转指定组的链表
    public void reverse(ListNode start,ListNode end){
        end = end.next;
        ListNode pre = null,cur = start,next = null;
        while(cur!=end){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }
}
