package demo005_linkedList;


/**
 * @author TuanFans
 * @time 2025年12月4日 20:48:13
 * <p>
 * 反转链表:<a>https://leetcode.cn/problems/reverse-linked-list/</a>
 * </p>
 * 
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
 */
public class Demo_005_01_ListReverse {
	public static void main(String[] args) {
		ListNode node5 = new ListNode(5,null);
		ListNode node4 = new ListNode(4,node5);
		ListNode node3 = new ListNode(3,node4);
		ListNode node2 = new ListNode(2,node3);
		ListNode head = new ListNode(1,node2);
		System.out.println("反转前的链表：");
		loop(head);
		System.out.println("反转后的链表：");
		head = reverseList(head);
		loop(head);
		System.out.println("再反转后的链表：");
		head = reverseList2(head);
		loop(head);
	}

	/**
	 * 反转链表（递归实现）
	 * @param head 链表头节点
	 * @return 反转后的链表头节点
	 */
	public static ListNode reverseList(ListNode head) {
		if(head==null) return head;
		return reverseList(head,null);
	}
	/**
	 * 辅助方法：递归函数
	 * @param from 开始节点
	 * @param to 开始节点指向的节点
	 * @return 反转后的链表头节点
	 */
	public static ListNode reverseList(ListNode from,ListNode to) {
		if(from.next==null) {
			from.next=to;
			return from;
		}
		ListNode pre = from.next;
		from.next=to;
		return reverseList(pre,from);
	}
	
	/**
	 * 反转链表（循环结构实现）
	 * @param head 链表头节点
	 * @return 反转后的头节点
	 */
	public static ListNode reverseList2(ListNode head) {
		ListNode pre = null;
		ListNode to = null;
		while(head!=null) {
			pre = head.next;
			head.next = to;
			to = head;
			head = pre;
		}
		return to;
	}
	
	/**
	 * 测试辅助方法：从指定节点开始打印节点的val值
	 * @param head 开始节点
	 */
	public static void loop(ListNode head) {
		ListNode temp = head;
		while(temp!=null) {
			if(temp.next!=null) System.out.print(temp.val+"->");
			else System.out.print(temp.val);
			temp=temp.next;
		}
		System.out.println();
	}
}
