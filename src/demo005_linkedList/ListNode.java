package demo005_linkedList;
/**
 * @author TuanFans
 * @time 2025年12月4日 21:41:38
 * <p></p>
 */
public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(){}
	public ListNode(int val){
		this.val = val;
	}
	public ListNode(int val,ListNode next){
		this.val = val;
		this.next = next;
	}

	public static ListNode createHeadNode(int val){
		return new ListNode(val);
	}

	public ListNode next(int val){
		ListNode newNode = new ListNode(val);
		this.next = newNode;
		return newNode;
	}

	public ListNode next(ListNode node){
		this.next = node;
		return node;
	}

	public static void  print(ListNode head){
		while(head!=null){
			if(head.next!=null) IO.println(head.val+"->");
			else IO.println(head.val);
			head = head.next;
		}
	}
}
