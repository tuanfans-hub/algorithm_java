package demo003_sorts;

import java.util.Arrays;

import demo000_utils.Utils;

/**
 * @author TuanFans
 * @time 2026年5月6日 14:26:10
 * <p>
 * 归并排序（递归版）：
 * T(n)=2 * T(n/2) + O(n) => a=2,b=2,c=1 => 时间复杂度：O(n * logn)
 * 空间复杂度：O(n)
 * </p>
 */
public class Demo_003_04_MergeSort {

	public static void main(String[] args) {
		int[] testArr = {5,6,4,7,3,8,2,9,1,0};
		mergeSort(testArr);
		System.out.println("------------------随机测试-----------------");
		Utils.testSort(array->mergeSort(array), 10);
	}
	
	public static void mergeSort(int[] array) {
		// 临时数组，排序后的数组
		int[] result = new int[array.length];
		System.out.println("sort start array="+Arrays.toString(array));
		System.out.println("sort start result="+Arrays.toString(result));
		// 开始归并排序
		mergeSort(array,result,0,array.length-1);
		System.out.println("sort finally array="+Arrays.toString(array));
		System.out.println("sort finally result="+Arrays.toString(result));
	}
	
	public static void mergeSort(int[] array,int[] result,int l,int r) {
		// 如果数组分割只有一个数字，不再分割，并将数字放到临时数组result中
		if(l==r) return;
		// 如果数组还可分，继续对数组进行分割
		int mid = l+(r-l)/2;
		// 对数组左边部分进行归并排序
		mergeSort(array,result,l,mid);
		// 对数组右边部分进行归并排序
		mergeSort(array,result,mid+1,r);
		// 将左边有序部分和右边有序部分进行合并
		merge(array,result,l,mid,r);
	}
	
	public static void merge(int[] array,int[] result,int l,int mid,int r) {
		System.out.println("-------------merge start---------------");
		System.out.println("merge start array="+Arrays.toString(array));
		System.out.println("merge start result="+Arrays.toString(result));
		// ls:待合并的左部分的索引；rs：待合并的右部分的索引；index：临时数组result的索引
		int ls = l,rs=mid+1,index=l;
		// 如果左边和右边部分都还有未排序的数字，则继续进行归并处理
		while(ls<=mid&&rs<=r) {
			// 比较左右索引的数字大小，较小的数字放入到临时数组result中
			if(array[ls]<=array[rs]) {
				result[index++]=array[ls++];
			}else {
				result[index++]=array[rs++];
			}
			System.out.println("merging result="+Arrays.toString(result));
		}
		// 如果左边索引小于或等于mid，表示右边所有数字已经排序，直接将左边剩余数字放入临时数组result中
		while(ls<=mid) result[index++]=array[ls++];
		// 如果右边索引小于或等于r，表示左边所有数字已经排序，直接将右边剩余数字放入临时数组result中
		while(rs<=r) result[index++]=array[rs++];
		System.out.println("merge finally result="+Arrays.toString(result));
		// 完成以上步骤，说明临时数组result中在[l,r]索引范围内有序
		// 将临时数组result中在[l,r]索引范围中的数字复写到array数组的对应索引中
		for(int i=l;i<=r;i++) array[i]=result[i];
		System.out.println("merge finally array="+Arrays.toString(array));
	}
}
