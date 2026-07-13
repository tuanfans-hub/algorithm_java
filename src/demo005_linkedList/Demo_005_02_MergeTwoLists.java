package demo005_linkedList;

import demo000_utils.Utils;

/**
 * @author TuanFans
 * @time 2025年12月4日 23:52:34
 * <p>
 * 力扣21-合并两个有序链表
 * <a>https://leetcode.cn/problems/merge-two-sorted-lists/description/</a>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * </p>
 */
public class Demo_005_02_MergeTwoLists {
	public static void main(String[] args) {
		ListNode A3 = new ListNode(4,null);
		ListNode A2 = new ListNode(2,A3);
		ListNode A1 = new ListNode(1,A2);
		
		ListNode B2 = new ListNode(5,null);
		ListNode B1 = new ListNode(3,B2);
		System.out.println("链表合并前：");
		Utils.loop(A1);
		Utils.loop(B1);
		System.out.println("链表合并后：");
		Utils.loop(mergeTwoLists(A1,B1));
	}
	
	/**
	 * 合并两个有序链表
	 * @param list1 链表1的头节点
	 * @param list2 链表2的头节点
	 * @return 合并后的链表头节点
	 */
	public static ListNode mergeTwoLists(ListNode list1,ListNode list2) {
		if(list1==null) return list2;
		if(list2==null) return list1;
		ListNode ans = list1.val<=list2.val?list1:list2;
		ListNode from = null;
		while(list1!=null && list2!=null) {
			if(list1.val<=list2.val) {
				if(from!=null) from.next = list1;
				from = list1;
				list1 = list1.next;
			}else {
				if(from!=null) from.next = list2;
				from = list2;
				list2 = list2.next;
			}
		}
		from.next = list1!=null?list1:list2;
		return ans;
	}
}
