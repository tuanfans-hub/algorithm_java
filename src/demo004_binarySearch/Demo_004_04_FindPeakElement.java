package demo004_binarySearch;

import java.util.Arrays;

/**
 * @author TuanFans
 * @time 2025年12月2日 17:52:00
 * <p>
 * 力扣169-峰值问题:https://leetcode.cn/problems/find-peak-element/
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * </p>
 */
public class Demo_004_04_FindPeakElement {
	public static void main(String[] args) {
		int[] array = {1,2,3,1};
		System.out.println(Arrays.toString(array)+"峰值为："+findPeakElement(array));// 2
		int[] array2 = {1,2,1,3,5,6,4};
		System.out.println(Arrays.toString(array2)+"峰值为："+findPeakElement(array2));// 1或5
	}
	
	/**
	 * 通过二分搜索的方法解决峰值问题
	 * @param array 数组
	 * @return 任意一个峰值的索引
	 */
	public static int findPeakElement(int[] array) {
		int n = array.length;
		// 分析索引0是否符合条件。符合，返回索引0；不符合，确定0~1之间为递增趋势。
		if(n==1 || array[0]>array[1]) return 0;
		// 分析索引n-1是否符合条件。符合，返回索引n-1；不符合，确定n-2~n-1之间为递减趋势。
		if(array[n-1]>array[n-2]) return n-1;
		// 二分搜索
		int left = 1;
		int right = n-2;
		int mid = 0;
		while(left<=right) {
			// 中点索引
			mid = left+(right-left)/2;
			// 0~1递增，mid~mid+1递增，n-2~n-1递减，所以mid+1~n-2之间必有峰值。移动左指针。
			if(array[mid]<array[mid+1]) left = mid+1;
			// 0~1递增，mid-1~mid递减，n-2~n-1递减，所以1~mid-1之间必有峰值。移动右指针。
			else if(array[mid]<array[mid-1]) right = mid-1;
			// mid-1~mid递增，mid~mid+1递减，mid为峰值索引。
			else return mid;
		}
		return -1;
	}
}
