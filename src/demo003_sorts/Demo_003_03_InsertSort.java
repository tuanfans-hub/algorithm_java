package demo003_sorts;

import demo000_utils.Utils;

/**
 * @author TuanFans
 * @time 2025年11月30日 20:36:19
 * <p>
 * 插入排序：
 * 0~i范围上已经有序，新来的数从右到左滑到正确的位置中插入，然后下一个数继续插入
 * </p>
 */
public class Demo_003_03_InsertSort {

	public static void main(String[] args) {
		Utils.testSort(array->insertSort(array), 10);
	}

	public static void insertSort(int[] array) {
		if(array==null || array.length<2) return;
		int n = array.length;
		for(int i = 1;i < n;i++) {
			int temp = array[i];
			int j = i-1;
			while(j>=0 && temp<array[j]) {
				// temp==array[j]时，不进行交换，则可以使该排序稳定
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = temp;
		}
	}
}
