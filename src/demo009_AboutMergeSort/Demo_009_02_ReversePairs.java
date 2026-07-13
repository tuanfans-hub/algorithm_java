package demo009_AboutMergeSort;

/**
 * @author TuanFans
 * @time 2026年5月8日 00:08:03
 * <p>
 * Leetcode 439.翻转对
 * https://leetcode.cn/problems/reverse-pairs/
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 * 你需要返回给定数组中的重要翻转对的数量。
 * </p>
 */
public class Demo_009_02_ReversePairs{
	public static void main(String[] args){
		int[] testArr1 = {1,3,2,3,1};
		int[] testArr2 = {2,4,3,5,1};
		int[] testArr3 = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
		System.out.println(reversePairs(testArr1));// 2
		System.out.println(reversePairs(testArr2));// 3
		System.out.println(reversePairs(testArr3));// 0
	}
	
	public static int reversePairs(int[] nums) {
		int[] temp = new int[nums.length];
		return reversePairs(nums,temp,0,nums.length-1);
	}
	
	public static int reversePairs(int[] array,int[] temp,int l,int r) {
		if(l==r) return 0;
		int m = l+(r-l)/2;
		return reversePairs(array,temp,l,m)+reversePairs(array,temp,m+1,r)+merge(array,temp,l,m,r);
	}
	
	public static int merge(int[] array,int[] temp,int l,int m,int r) {
		int total = 0;
		// 统计翻转对个数
		for(int i=l,j=m+1;i<=m;i++) {
			// 防止溢出：进行类型强转为long类型
			while(j<=r && (long)array[i]<=(long)2*array[j]) {
				j++;
			}
			total+=(r-j+1);
		}
		// 从大到小排序归并
		int ls=l,rs=m+1,index=l;
		while(ls<=m && rs<=r) {
			temp[index++] = array[ls]>=array[rs]?array[ls++]:array[rs++];
		}
		while(ls<=m) {
			temp[index++] = array[ls++];
		}
		while(rs<=r) {
			temp[index++] = array[rs++];
		}
		for(int i=l;i<=r;i++) {
			array[i] = temp[i];
		}
		return total;
	}
}
