package demo005_linkedList;

/**
 * @author TuanFans
 * @date 2026/7/11
 * <p><a href="https://leetcode.cn/problems/sort-list/">148. 排序链表</a></p>
 */
public class Demo_006_10_SortList {
    // 记录当前两段链表合并之后（排序之后）的头尾节点
    // 记录当前两端链表合并之后的头节点
    ListNode start;
    // 记录当前两端链表合并之后的尾节点
    ListNode end;
    public ListNode sortList(ListNode head) {
        // 统计链表长度
        int n = 0;
        ListNode cur = head;
        while(cur!=null){
            cur = cur.next;
            n++;
        }

        // 链表一：l1->...->r1->null
        // 链表二：l2->...->r2->null
        // next: 下一段链表的头节点（待合并的链表的头节点）
        // lastEnd: 上一次合并之后的尾节点
        ListNode l1,r1,l2,r2,next,lastEnd;
        // 从长度为1开始，每次翻倍，直到大于等于链表长度
        for(int i = 1;i < n;i <<= 1){
            // 第一次合并会确定新链表的头节点，所以特殊处理
            l1 = head;
            r1 = findEnd(l1,i);
            l2 = r1.next;
            r2 = findEnd(l2,i);
            // 记录下一段链表的头节点，便于后续合并
            next = r2.next;
            // 断开链表
            r1.next = null;
            r2.next = null;
            // 合并两段链表
            merge(l1,r1,l2,r2);
            // 记录新链表的新头节点
            head = start;
            // 记录当前合并操作之后的尾节点
            lastEnd = end;
            // 如果后面还有链表继续合并
            while(next !=null){
                l1 = next;
                r1 = findEnd(l1,i);
                l2 = r1.next;
                // 如果没有下一段链表，无需合并操作，直接连接退出
                if(l2==null){
                    // 后面没有链表，直接连接
                    lastEnd.next = l1;
                    break;
                }
                r2 = findEnd(l2,i);
                // 记录下一段链表的头节点，便于后续合并
                next = r2.next;
                // 断开链表
                r1.next = null;
                r2.next = null;
                // 合并两段链表
                merge(l1,r1,l2,r2);
                // 连接之前已经合并之后的链表
                lastEnd.next = start;
                // 更新尾节点
                lastEnd = end;
            }
        }

        return head;
    }

    // 找到链表中指定节点之后（包含该节点）的第k个节点
    public ListNode findEnd(ListNode node,int k){
        // 为什么是--k而不是k--？
        // 包含开始节点的第k个节点，指针只需要移动k-1次，所以使用--k
        while(node.next!=null && --k!=0){
            node = node.next;
        }
        return node;
    }

    // 合并两段链表
    public void merge(ListNode l1,ListNode r1,ListNode l2,ListNode r2){
        // 记录已经合并的链表的尾节点，即待合并节点的前驱节点
        ListNode pre;
        // 第一次合并操作需要记录新链表的头节点，所以特殊处理
        if(l1.val>l2.val){
            start = l2;
            pre = l2;
            l2 = l2.next;
        }else{
            start = l1;
            pre = l1;
            l1 = l1.next;
        }
        // 合并后续节点
        while(l1!=null && l2!=null){
            if(l1.val>l2.val){
                pre.next = l2;
                pre = l2;
                l2 = l2.next;
            }else{
                pre.next = l1;
                pre = l1;
                l1 = l1.next;
            }
        }
        // 连接剩余节点，并记录当前合并之后的链表尾节点
        if(l1!=null){
            pre.next = l1;
            end = r1;
        }else{
            pre.next = l2;
            end = r2;
        }
    }
}
