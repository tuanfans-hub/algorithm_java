package demo003_sorts;

import java.util.Arrays;

import demo000_utils.Utils;

/**
 * @author TuanFans
 * @time 2026年5月6日 19:00:36
 * <p>
 * 归并排序（非递归版）
 * 时间复杂度：O(n * logn)
 * 空间复杂度:O(n)
 * </p>
 */
public class Demo_003_05_MergeSortNoRecusion {

	public static void main(String[] args) {
		int[] testArr = {5,6,4,7,3,8,2,9,1,0};
		mergeSort(testArr);
		System.out.println(Arrays.toString(testArr));
		Utils.testSort(array->mergeSort(array), 10);
	}
	
	public static void mergeSort(int[] array) {
		// 临时数组，存储已排序的数组序列
		int[] temp = new int[array.length];
		// step：步长，控制从开始索引起取2^n个数字，即1，2，4，8，16……
		for(int l,r,step = 1;step<array.length;step<<=1) {
			// 每次step发生变化，从以索引0为左边起始索引，取step个数作为左边序列
			l=0;
			while(l < array.length) {
				// 中间索引
				int mid=l+step-1;
				// 如果中间索引+1超过数组长度，即右边没有数字，则此次归并结束
				if(mid+1>=array.length) break;
				// 右边结束索引从【l+2*step-1】和数组最后索引取较小值
				r = Math.min(l+2*step-1, array.length-1);
				// 合并左右序列
				merge(array,temp,l,mid,r);
				// 进行同步长的下一轮合并操作
				l = r + 1;
			}
		}
	}
	
	// 左右序列合并处理函数
	public static void merge(int[] array,int[] temp,int l,int mid,int r) {
		int ls=l,rs=mid+1,index=l;
		while(ls<=mid && rs<=r) temp[index++]=array[ls]<=array[rs]?array[ls++]:array[rs++];
		while(ls<=mid) temp[index++]=array[ls++];
		while(rs<=r) temp[index++]=array[rs++];
		for(int i=l;i<=r;i++) array[i]=temp[i];
	}
}
