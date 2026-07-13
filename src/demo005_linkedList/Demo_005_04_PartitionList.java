package demo005_linkedList;

import java.io.*;
import demo000_utils.Utils;
/**
 * @author TuanFans
 * @time 2025年12月6日 21:35:47
 * <p>
 * 力扣86-分隔链表
 * <a>https://leetcode.cn/problems/partition-list/description/</a>
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，
 * 使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * 测试用例：
 * 输入：
 * 1
 * 6 3
 * 1 4 3 2 5 2
 * 输出：
 * 1->4->3->2->5->2
 * 1->2->2->4->3->5
 * </p>
 */
public class Demo_005_04_PartitionList {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer in = new StreamTokenizer(br);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		in.nextToken();
		// 测试用例的个数
		int n = (int)in.nval;
		while(n>0 && in.nextToken()!=StreamTokenizer.TT_EOF) {
			ListNode head = null;
			ListNode last = null;
			int len = (int)in.nval;
			in.nextToken();
			int x = (int)in.nval;
			for(int i = 0;i < len;i++) {
				in.nextToken();
				int val = (int)in.nval;
				if(i==0) {
					head=new ListNode(val);
					last = head;
				}else {
					last.next = new ListNode(val);
					last = last.next;
				}
			}
			Utils.printList(out,head);
			ListNode ans = partition(head,x);
			Utils.printList(out, ans);
			n--;
		}
		out.flush();
		out.close();
		br.close();
	}
	
	/**
	 * 分隔链表
	 * @param head 链表的头节点
	 * @param x 分隔链表的分界值
	 * @return 分隔后的链表头节点
	 */
	public static ListNode partition(ListNode head,int x) {
		// 优先判空！！！
		if(head==null || head.next==null) return head;
		ListNode leftHead = null,leftTail = null;
		ListNode rightHead = null,rightTail = null;
		ListNode temp = head;
		while(temp!=null) {
			if(temp.val>=x) {
				if(rightHead==null) {
					rightHead = temp;
					rightTail = rightHead;
				}else {
					rightTail.next = temp;
					rightTail = rightTail.next;
				}
			}else {
				if(leftHead==null) {
					leftHead = temp;
					leftTail = leftHead;
				}else {
					leftTail.next = temp;
					leftTail = leftTail.next;
				}
			}
			temp = temp.next;
		}
		// 分离左右链表，使其保持链表结构，不会成为图
		// 访问一个对象的属性时，应保证它不为null
		if(leftTail!=null) leftTail.next = null;
		if(rightTail!=null) rightTail.next = null;
		if(leftHead==null) return rightHead;
		else leftTail.next = rightHead;
		return leftHead;
	}
}
