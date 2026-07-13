package demo004_binarySearch;

import demo000_utils.Utils;

/**
 * @author TuanFans
 * @time 2025年12月1日 12:48:10
 * <p>目标元素是否存在？存在，返回索引；不存在返回-1</p>
 */
public class Demo_004_01_FindTarget {
	public static void main(String[] args) {
		Utils.testBinarySearch((array,target)->find(array,target), 10);
	}

	/**
	 * 从有序递增数组中，找到目标元素的索引
	 * @param array 有序递增数组
	 * @param target 目标元素
	 * @return 目标元素的索引
	 */
	public static int find(int[] array,int target) {
		if(array == null || array.length == 0) return -1;
		int left = 0;
		int right = array.length-1;
		int mid = 0;
		while(left<=right) {
			mid = left + (right - left)/2;
			if(target>array[mid]) left = mid+1;
			else if(target<array[mid]) right = mid-1;
			else return mid;
		}
		return -1;
	}
}
