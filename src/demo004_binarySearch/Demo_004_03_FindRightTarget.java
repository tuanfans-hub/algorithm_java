package demo004_binarySearch;

import java.util.Arrays;

import demo000_utils.Utils;

/**
 * @author TuanFans
 * @time 2025年12月1日 14:29:01
 * <p>从有序递增数组中，找到等于target的最大索引</p>
 */
public class Demo_004_03_FindRightTarget {

	public static void main(String[] args) {
		System.out.println("-------------------------find Test-------------------------");
		Utils.testBinarySearch((array,target)->find(array,target), 10);
		int[] test = {0,1,5,5,5,6,7,8,8,9,10};
		int target = 5;
		int index = find(test,target);
		System.out.println(Arrays.toString(test));
		System.out.println(target+"的最大索引为："+index);
		System.out.println("-------------------------findLeftGtTarget Test-------------------------");
		Utils.testBinarySearch((arr,tar)->findRightLtTarget(arr,tar), 10);
		int target2 = 3;
		int index2 = findRightLtTarget(test,target2);
		System.out.println(Arrays.toString(test));
		System.out.println("<="+target2+"的最大索引为："+index2);// 1
	}
	
	/**
	 * 从有序递增数组中，找到等于target的最大索引
	 * @param array 有序递增数组
	 * @param target 待查找的目标元素
	 * @return 找到返回最大索引；没找到返回-1
	 */
	public static int find(int[] array,int target) {
		if(array == null || array.length == 0) return -1;
		int left = 0;
		int right = array.length-1;
		int mid = 0;
		int index = -1;
		while(left<=right) {
			mid = left + (right-left)/2;
			if(target<array[mid]) {
				right = mid - 1;
			}else if(target>array[mid]) {
				left = mid + 1;
			}else {
				index = mid;
				left = mid + 1;
			}
		}
		return index;
	}
	
	/**
	 * 从有序递增序列中找到<=target的元素最大索引，并返回。
	 * @param array 有序递增序列
	 * @param target 目标
	 * @return 索引
	 */
	public static int findRightLtTarget(int[] array,int target) {
		if(array==null || array.length==0) return -1;
		int left = 0;
		int right = array.length-1;
		int mid = 0;
		int index = -1;
		while(left<=right) {
			mid = left+(right-left)/2;
			if(target<array[mid]) {
				right = mid-1;
			}else {
				index = mid;
				left = mid+1;
			}
		}
		return index;
	}
}
