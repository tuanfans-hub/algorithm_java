package demo005_linkedList;

/**
 * @author TuanFans
 * @date 2026/7/10
 * <p><a href="https://leetcode.cn/problems/copy-list-with-random-pointer/">力扣138. 随机链表的复制</a></p>
 */
public class Demo_005_07_CopyRandomList {
    public static class Node{
        int val;
        Node next;
        Node random;

        public Node(int val){
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node cur = head;
        Node next;
        Node ans = null;

        // 复制节点插入到原节点之后
        // 方便后续找到对应的复制节点
        // 原链表：1->2->3->4->5
        // 复制节点后链表：1->1'->2->2'->3->3'->4->4'->5->5'
        while(cur!=null){
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }

        // 复制随机指针
        cur = head;
        while(cur!=null){
            // 判断当前节点的random是否为空
            if(cur.random!=null) cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        // 拆分链表
        cur = head;
        while(cur!=null){
            if(cur==head) ans=cur.next;
            Node t = cur.next;
            // 判断当前节点的next是否为空
            if(cur.next!=null) cur.next = cur.next.next;
            cur = t;
        }

        return ans;
    }
}
