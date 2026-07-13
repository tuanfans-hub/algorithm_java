package demo003_sorts;

import demo000_utils.Utils;

/**
 * @author TuanFans
 * @time 2025年11月30日 20:29:32
 * <p>
 * 选择排序：
 * i从0开始，循环遍历i~n-1范围内的所有数，找到最小的数放到i位置中，i++,进行n-1轮。
 * </p>
 */
public class Demo_003_02_SelectSort {

	public static void main(String[] args) {
		Utils.testSort(array->selectSort(array),10);
	}
	
	public static void selectSort(int[] array) {
		if(array==null || array.length<2) return;
		int n = array.length;
		for(int minIndex,i = 0;i < n;i++) {
			minIndex = i;
			for(int j = i+1;j < n;j++) {
				if(array[minIndex]>array[j]) {
					minIndex = j;
				}
			}
			Utils.swap(array, i, minIndex);
		}
	}

}
