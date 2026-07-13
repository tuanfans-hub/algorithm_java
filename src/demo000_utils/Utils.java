package demo000_utils;

import java.io.PrintWriter;
import java.util.Arrays;

import demo005_linkedList.ListNode;

/**
 * @author TuanFans
 * @time 2025年11月29日 19:35:42
 * <p>工具类</p>
 */
public class Utils {
	// main方法主要用于测试各个方法的正确性
	public static void main(String[] args) {
		int[] arr = {0,1};
		swap(arr,0,1);
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * 交换数组中的两位元素
	 * @param array 数组
	 * @param i 元素1的索引
	 * @param j 元素2的索引
	 */
	public static void swap(int[] array,int i,int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	/**
	 * 通过位运算交换数组中的两个元素
	 * @param array 数组
	 * @param i 元素1的索引
	 * @param j 元素2的索引
	 */
	public static void bitSwap(int[] array,int i,int j) {
		// 通过异或运算实现交换的局限性：
		// 1. 当交换的两个元素指向同一内存地址时，会导致数据被清零。即i==j时，异或进行交换之后，array[i]=0。
		// 2. 不支持非整形数据
		// 3. 代码可读性差
		// 4. 性能优势不显著
		// 5. 调试不友好
		// 综上：不推荐使用异或进行数组元素的交换！！！
		if(i == j) return;
		array[i] ^= array[j];
		array[j] ^= array[i];
		array[i] ^= array[j];
	}
	
	/**
	 * 获得随机数组：元素范围[0,Integer.MAX_VALUE)
	 * @param length 数组长度
	 * @return 随机数组
	 */
	public static int[] randomArray(int length) {
		int[] array = new int[length];
		int max = 100;
		for(int i = 0;i < length;i++) {
			array[i] = (int)(Math.random()*max);
		}
		return array;
	}
	
	/**
	 * 判断数组是否有序
	 * @param array 目标数组
	 * @return 是否有序
	 */
	public static boolean isSorted(int[] array) {
		boolean isSorted = true;
		for(int i = 1;i < array.length;i++) {
			if(array[i-1]>array[i]) {
				isSorted = false;
				break;
			}
		}
		return isSorted;
	}
	
	/**
	 * 测试数组的排序算法
	 * @param sort 排序算法函数
	 * @param length 数组长度，用于生成随机数组
	 */
	public static void testSort(Sort sort,int length) {
		if(length==0) return;
		int[] array = randomArray(length);
		System.out.println(Arrays.toString(array));
		sort.toSort(array);
		System.out.println(Arrays.toString(array)+",有序?:"+isSorted(array));
	}
	
	/**
	 * 测试二分搜索算法
	 * @param bs 二分搜索算法
	 * @param length 数组长度，用于生成随机数组
	 */
	public static void testBinarySearch(BinarySearch bs,int length) {
		if(length == 0) return;
		int[] array = Utils.randomArray(length);
		System.out.println(Arrays.toString(array));
		int target = array[0];
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		int index = bs.find(array,target);
		System.out.println(target+"的索引为："+index);
	}
	
	/**
	 * 打印链表节点：从指定节点开始打印节点的val值
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
	
	/**
	 * 使用指定的PrintWriter输出流遍历打印链表节点
	 * @param out 输出流
	 * @param head 链表头节点
	 */
	public static void printList(PrintWriter out,ListNode head) {
		ListNode temp = head;
		while(temp!=null) {
			if(temp.next!=null) out.print(temp.val+"->");
			else out.println(temp.val);
			temp = temp.next;
		}
	}
}

