package demo003_sorts;

import demo000_utils.Utils;

/**
 * @author TuanFans
 * @time 2025年11月30日 20:27:41
 * <p>
 * 冒泡排序：
 * 0~i范围上，相邻位置较大的数滚下去，最大值最终来到i位置，然后0~i-1范围上继续
 * </p>
 */
public class Demo_003_01_BubbleSort {
	public static void main(String[] args) {
		Utils.testSort(array->bubbleSort(array), 10);
	}
	
	public static void bubbleSort(int[] array) {
		if(array==null || array.length<2) return;
		int n = array.length;
		for(int end = n-1;end > 0;end--) {
			for(int j = 1;j <= end;j++) {
				if(array[j-1]>array[j]) {
					Utils.swap(array, j-1, j);
				}
			}
		}
	}
}
