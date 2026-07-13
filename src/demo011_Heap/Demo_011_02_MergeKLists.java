package demo011_Heap;

import java.util.PriorityQueue;

/**
 * @author TuanFans
 * @time 2026年5月30日 17:32:26
 * <p>
 * 合并 K 个升序链表
 * 力扣23：https://leetcode.cn/problems/merge-k-sorted-lists/description/
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
示例 1：
输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6
 * </p>
 */
public class Demo_011_02_MergeKLists {
	public static void main(String[] args) {
		ListNode list1_node3 = new ListNode(5,null);
		ListNode list1_node2 = new ListNode(4,list1_node3);
		ListNode list1_node1 = new ListNode(1,list1_node2);
		
		ListNode list2_node3 = new ListNode(4,null);
		ListNode list2_node2 = new ListNode(3,list2_node3);
		ListNode list2_node1 = new ListNode(1,list2_node2);
		
		ListNode list3_node2 = new ListNode(6,null);
		ListNode list3_node1 = new ListNode(2,list3_node2);
		
		ListNode[] lists = {list1_node1,list2_node1,list3_node1};
		ListNode head = mergeKLists(lists);
		while(head!=null) {
			System.out.print(head.val+"->");
			head = head.next;
		}
		System.out.println("null");
		System.out.println("------------------------------------");
		ListNode list1_node3_2 = new ListNode(5,null);
		ListNode list1_node2_2 = new ListNode(4,list1_node3_2);
		ListNode list1_node1_2 = new ListNode(1,list1_node2_2);
		
		ListNode list2_node3_2 = new ListNode(4,null);
		ListNode list2_node2_2 = new ListNode(3,list2_node3_2);
		ListNode list2_node1_2 = new ListNode(1,list2_node2_2);
		
		ListNode list3_node2_2 = new ListNode(6,null);
		ListNode list3_node1_2 = new ListNode(2,list3_node2_2);
		
		ListNode[] lists2 = {list1_node1_2,list2_node1_2,list3_node1_2};
		ListNode head2 = mergeKLists2(lists2);
		while(head2!=null) {
			System.out.print(head2.val+"->");
			head2 = head2.next;
		}
		System.out.println("null");
	}
	
	private static class ListNode{
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { 
			this.val = val; 
		}
		ListNode(int val, ListNode next) { 
			this.val = val; 
			this.next = next; 
		}
	}
	
	/**
	 * 利用小根堆实现
	 * @param lists 链表数组
	 * @return 合并后的链表头节点
	 */
	public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode node:lists) {
        	if(node!=null) heap.add(node);
        }
        ListNode head = null;
        ListNode pre = head;
        while(!heap.isEmpty()) {
        	ListNode cur = heap.poll();
        	if(head==null) {
        		head = cur;
        		pre = cur;
        	}else {
        		pre.next = cur;
        		pre = pre.next;
        	}
        	if(cur.next!=null) heap.add(cur.next);
        }
        return head;
    }
	
	// 使用分治归并思想实现
	public static ListNode mergeKLists2(ListNode[] lists) {
		return mergeKList2(lists,0,lists.length-1);
	}
	
	private static ListNode mergeKList2(ListNode[] lists,int left,int right) {
		if(left==right) return lists[left];
		if(left>right) return null;
		int mid = left+(right-left)/2;
		ListNode head1 = mergeKList2(lists,left,mid);
		ListNode head2 = mergeKList2(lists,mid+1,right);
		return mergeTwoLists(head1,head2);
	}
	
	private static ListNode mergeTwoLists(ListNode head1,ListNode head2) {
		if(head2==null) return head1;
		if(head1==null) return head2;
		ListNode sentry = new ListNode();
		ListNode pre = sentry;
		while(head1!=null&&head2!=null) {
			if(head1.val<=head2.val) {
				pre.next = head1;
				head1 = head1.next;
			}else {
				pre.next = head2;
				head2 = head2.next;
			}
			pre = pre.next;
		}
		pre.next = head1!=null?head1:head2;
		return sentry.next;
	}
}
