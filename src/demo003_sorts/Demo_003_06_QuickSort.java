package demo003_sorts;

import java.util.Arrays;

import demo000_utils.Utils;

/**
 * @author TuanFans
 * @time 2026年5月8日 16:53:58
 * <p>
 * 随机快速排序：时间复杂度：O(n*logn)；空间复杂度：O(logn)
 * </p>
 */
public class Demo_003_06_QuickSort {

	public static void main(String[] args) {
		System.out.println("----------------左右指针---------------");
		int[] testArr1 = {5,6,4,7,3,8,2,9,1,0};
		quickSort(testArr1);
		System.out.println("----------------快慢指针---------------");
		int[] testArr2 = {5,6,4,7,3,8,2,9,1,0};
		quickSort2(testArr2);
		System.out.println(Arrays.toString(testArr2));
		System.out.println("----------------荷兰国旗优化版---------------");
		int[] testArr3 = {5,6,4,7,3,8,2,9,1,0};
		quickSort3(testArr3);
		System.out.println(Arrays.toString(testArr3));
		System.out.println("----------------随机测试---------------");
		System.out.println("----------------左右指针---------------");
		Utils.testSort(array->quickSort(array), 10);
		System.out.println("----------------快慢指针---------------");
		Utils.testSort(array->quickSort2(array), 10);
		System.out.println("----------------荷兰国旗优化版---------------");
		Utils.testSort(array->quickSort3(array), 10);
	}
	
	public static void quickSort(int[] array) {
		quickSort(array,0,array.length-1);
	}
	
	public static void quickSort(int[] array,int l,int r) {
		if(l>=r) return;
		// 随机获取基准值索引
		int baseIndex = l+(int)Math.random()*(r-l+1);
		System.out.println("l,r,baseIndex = "+l+","+r+","+baseIndex);
		System.out.println(Arrays.toString(array));
		int baseValue = array[baseIndex];
		// 找到基准值的排序后的索引位置，并返回
		int mid = partition(array,l,r,baseValue);
		quickSort(array,l,mid-1);
		quickSort(array,mid+1,r);
	}
	
	// 左右指针分隔
	public static int partition(int[] array,int l,int r,int baseVal) {
		int lp=l,rp=r;
		while(lp<=rp) {
			while(lp<=rp && array[lp]<baseVal) {
				lp++;
			}
			while(lp<=rp && array[rp]>baseVal) {
				rp--;
			}
			// 交换索引值的位置
			if(lp<=rp) swap(array,lp,rp);
			// 如果左右指针的值等于baseVal，则保持该指针不动
			if(array[lp]==baseVal) rp--;
			else if(array[rp]==baseVal) lp++;
			else {
				lp++;
				rp--;
			}
			System.out.println(Arrays.toString(array));
		}
		return lp;
	}
	
	public static void swap(int[] array,int i,int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void quickSort2(int[] array) {
		quickSort2(array,0,array.length-1);
	}
	
	// 快慢指针实现
	public static void quickSort2(int[] array,int l,int r) {
		if(l>=r)return;
		int baseIndex = l+(int)Math.random()*(r-l+1);
		int baseValue = array[baseIndex];
		System.out.println("l,r,baseIndex = "+l+","+r+","+baseValue);
		int m = partition2(array,l,r,baseValue);
		quickSort2(array,l,m-1);
		quickSort2(array,m+1,r);
	}
	
	// 快慢指针进行分隔
	public static int partition2(int[] array,int l,int r,int base) {
		// mi用于分隔<=base的索引,cur为当前遍历的索引,index用于记录值等于base的索引
		int mi=l,cur=l,index=l;
		while(cur<=r) {
			if(mi==cur) {
				// 如果mi==cur：说明当前没有遇到大于base的数
				if(array[cur]<=base) {
					// 如果当前遍历的数依旧小于或等于base，mi++，cur++
					mi++;
					cur++;
				}else {
					// 如果当前遍历的数大于base，只cur++
					cur++;
				}
			}else {
				// 如果mi<cur：说明mi为当前>base的最小索引
				if(array[cur]<=base) {
					if(array[cur]==base) index=mi;
					// 如果当前遍历的数小于或等于base，交换mi索引和cur索引中数的位置，同时mi++，cur++
					swap(array,mi++,cur++);
					System.out.println(Arrays.toString(array));
				}else {
					// 如果当前遍历的数大于base，只cur++
					cur++;
				}
			}
		}
		swap(array,index,mi-1);
		return mi-1;
	}
	
	// 荷兰国旗问题优化随机快速排序算法
	public static void quickSort3(int[] array) {
		quickSort3(array,0,array.length-1);
	}
	
	public static void quickSort3(int[] array,int l,int r) {
		if(l>=r)return;
		int baseIndex = l+(int)Math.random()*(r-l+1);
		int baseValue = array[baseIndex];
		int[] result = partition3(array,l,r,baseValue);
		quickSort3(array,l,result[0]-1);
		quickSort3(array,result[1]+1,r);
	}
	
	// 荷兰国旗问题优化随机快速排序算法
	public static int[] partition3(int[] array,int l,int r,int base) {
		int[] ans = new int[2];
		// left：等于base的最小索引；right：等于base的最大索引；index：当前遍历索引
		int left=l,right=r,index=l;
		while(index<=right) {
			if(array[index]<base) {
				// 如果left<index,说明已经遇到等于base的数。
				// 并且如果当前索引的数小于base，交换left索引和index索引位置的数之后，left++，index++
				if(left<index) swap(array,left,index);
				// 如果left==base，说明当前没有遇到等于base的数，直接left++，index++
				left++;
				index++;
			}else if(array[index]==base) {
				// 如果当前遍历的数等于base，只index++，left索引不变
				index++;
			}else {
				// 如果当前遍历的数大于base，交换index索引和right索引文职的数之后，right--
				// 为什么不执行index++呢？因为交换前right索引位置的数并没有进行大小比较判断。
				swap(array,index,right--);
			}
		}
		ans[0] = left;
		ans[1] = right;
		System.out.println(Arrays.toString(ans));
		return ans;
	}

}
