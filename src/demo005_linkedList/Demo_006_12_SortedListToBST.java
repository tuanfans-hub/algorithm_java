package demo005_linkedList;

/**
 * @author TuanFans
 * @time 2026/7/14 17:48
 * <p><a href="https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/">109. 有序链表转换二叉搜索树</a></p>
 */
public class Demo_006_12_SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return new TreeNode(head.val);

        return buildBST(head,null);
    }

    // 分治
    public TreeNode buildBST(ListNode start,ListNode end){
        if(start==end) return null;

        ListNode m = findMid(start,end);
        TreeNode root = new TreeNode(m.val);
        root.left = buildBST(start,m);
        root.right = buildBST(m.next,end);
        return root;
    }

    public ListNode findMid(ListNode start,ListNode end){
        ListNode slow=start,fast=start;
        while(fast.next!=end && fast.next.next!=end){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

