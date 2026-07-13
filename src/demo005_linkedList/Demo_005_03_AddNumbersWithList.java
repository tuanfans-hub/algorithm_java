package demo005_linkedList;

import java.io.*;

/**
 * @author TuanFans
 * @time 2025年12月6日 17:35:43
 * <p>
 * 两个链表，每个链表代表一个数，头节点表示数的个位；两个数相加，返回代表一个两数之和的链表头节点。
 * 测试用例：
 * 输入：
 * 1
 * 3 4
 * 4 8 9
 * 2 6 7 9
 * 输出：
 * 4->8->9
 * 2->6->7->9
 * 6->4->7->0->1
 * </p>
 */
public class Demo_005_03_AddNumbersWithList {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer in = new StreamTokenizer(br);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		in.nextToken();
		// 测试用例个数
		int n = (int)in.nval;
		while(n>0 && in.nextToken()!=StreamTokenizer.TT_EOF) {
			ListNode list1 = null;
			ListNode last1 = null;
			ListNode list2 = null;
			ListNode last2 = null;
			// 在这里为什么不用执行in.nextToken()呢？
			// 因为在while语句的判断语句中已经执行了一次in.nextToken()
			// 再执行将会跳过一个待读取的数据，导致读取数据错误！
			int l1 = (int)in.nval;
			in.nextToken();
			int l2 = (int)in.nval;
			for(int i = 0;i < l1;i++) {
				in.nextToken();
				int value = (int)in.nval;
				ListNode temp = new ListNode(value);
				if(i==0) {
					list1 = new ListNode(value);
					last1 = list1;
				}else {
					last1.next = temp;
					last1 = last1.next;
				}
			}
			for(int i = 0;i < l2;i++) {
				in.nextToken();
				int value = (int)in.nval;
				ListNode temp = new ListNode(value);
				if(i==0) {
					list2 = temp;
					last2 = list2;
				}else {
					last2.next = temp;
					last2 = last2.next;
				}
			}
			ListNode ans = addNumsWithList(list1,list2);
			testPrint(out,list1);
			testPrint(out,list2);
			testPrint(out,ans);
			n--;
		}
		out.flush();
		out.close();
		br.close();
	}
	
	/**
	 * 两个链表，每个链表代表一个数，头节点表示数的个位；两个数相加，返回代表一个两数之和的链表头节点。
	 * @param list1 链表1的头节点，头节点的val是数字1的个位
	 * @param list2 链表2的头节点，头节点的val是数字2的个位
	 * @return 两数之和的链表头节点
	 */
	public static ListNode addNumsWithList(ListNode list1,ListNode list2) {
		if(list1==null) return list2;
		if(list2==null) return list1;
		ListNode ans = null,pre = null;
		// carry：记录进位信息，有进位为true；没有进位为false
		boolean carry = false;
		ListNode cur1 = list1,cur2 = list2;
		int value = 0;
		while(cur1!=null && cur2!=null) {
			value = carry?cur1.val+cur2.val+1:cur1.val+cur2.val;
			carry = value>=10?true:false;
			if(pre==null) {
				pre = new ListNode(value%10);
				ans = pre;
			}else {
				pre.next = new ListNode(value%10);
				pre = pre.next;
			}
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		ListNode cur = cur1==null?cur2:cur1;
		while(cur!=null) {
			value = carry?cur.val+1:cur.val;
			carry = value>=10?true:false;
			pre.next = new ListNode(value%10);
			pre = pre.next;
			cur = cur.next;
		}
		pre.next = carry?new ListNode(1):null;
		return ans;
	}
	
	/**
	 * 测试打印函数
	 * @param out 输出流对象
	 * @param head 链表头节点
	 */
	public static void testPrint(PrintWriter out,ListNode head) {
		ListNode temp = head;
		while(temp!=null) {
			if(temp.next!=null) out.print(temp.val+"->");
			else out.println(temp.val);
			temp = temp.next;
		}
	}
	
	// 尾插法失败的典型案例
	public static void addElement(ListNode last,ListNode temp) {
		last.next = temp;
		// Java 只有值传递。对象参数传递的是引用副本，而非引用本身。
		// 方法内通过引用副本修改对象属性会影响原始对象。
		// 方法内对引用副本重新赋值（如指向新对象）不会影响原始引用。
		// 所以该方法无法实现尾插法
		last = last.next;
	}
}
