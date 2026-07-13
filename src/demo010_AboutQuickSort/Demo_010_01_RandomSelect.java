package demo010_AboutQuickSort;

import java.util.Arrays;

import demo000_utils.Utils;

/**
 * @author TuanFans
 * @time 2026年5月11日 20:51:57
 * <p>
 * 随机选择算法：在随机快排的基础上的选择算法。时间复杂度O(n);空间复杂度：O(1)
 * 使用场景：在一个无序数组中，找到第几大/小的数
 * </p>
 */
public class Demo_010_01_RandomSelect {

	public static void main(String[] args) {
		System.out.println("---------------------递归实现----------------------");
		int[] array = Utils.randomArray(10);
		System.out.println(Arrays.toString(array));
		// 返回数组中第5大的数
		int result = randomSelect(array,5,0,array.length-1);
		System.out.println("第5大的数是"+result);
		
		System.out.println("---------------------非递归实现----------------------");
		int[] array2 = Utils.randomArray(10);
		System.out.println(Arrays.toString(array2));
		// 返回数组中第5大的数
		int result2 = randomSelect(array2,5,0,array2.length-1);
		System.out.println("第5大的数是"+result2);
	}
	
	// 递归实现
	public static int randomSelect(int[] array,int pos,int l,int r) {
		if(l==r) return array[l]; 
		int targetIndex = pos - 1;
		int baseIndex = l+(int)Math.random()*(r-l+1);
		int baseValue = array[baseIndex];
		int[] result = partition(array,l,r,baseValue);
		if(targetIndex<result[0]) {
			return randomSelect(array,pos,l,result[0]-1);
		}else if(targetIndex>result[1]) {
			return randomSelect(array,pos,result[1]+1,r);
		}else {
			return baseValue;
		}
	}
	
	// 非递归实现
	public static int randomSelect2(int[] array,int pos) {
		int targetIndex = pos - 1;
		int ans = 0;
		int lp = 0, rp = array.length-1;
		while(lp<=rp) {
			int baseIndex = lp+(int)Math.random()*(rp-lp+1);
			int baseValue = array[baseIndex];
			int[] result = partition(array,lp,rp,baseValue);
			if(targetIndex<result[0]) {
				rp = result[0]-1;
			}else if(targetIndex>result[1]) {
				lp = result[1]+1;
			}else {
				ans =  array[result[0]];
				break;
			}
		}
		return ans;
	}
	
	// 核心算法
	public static int[] partition(int[] array,int l,int r,int base) {
		int[] ans = new int[2];
		int left = l,right=r,index=l;
		while(index<=right) {
			if(array[index]<base) {
				if(left<index) swap(array,left,index);
				left++;
				index++;
			}else if(array[index]==base) {
				index++;
			}else {
				swap(array,index,right--);
			}
		}
		ans[0] = left;
		ans[1] = right;
		return ans;
	}
	
	public static void swap(int[] array,int i,int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
