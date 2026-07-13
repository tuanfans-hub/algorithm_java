package demo008_Recusion;

import java.util.Arrays;

/**
 * @author TuanFans
 * @time 2026年3月6日 15:17:42
 * <p></p>
 */
public class Demo_008_01_MaxValue {
	public static void main(String[] args) throws Exception {
		int[] testArray = {2,1,7,1,3,4,3,8,5,6,9};
		int max = findMaxValue(testArray);
		System.out.println(Arrays.toString(testArray)+" max is "+max);
	}
	
	public static int findMaxValue(int[] array) throws Exception {
		if(array == null) throw new Exception("Array is null.");
		int max = findMaxValue(array,0,array.length-1);
		return max;
	}
	
	private static int findMaxValue(int[] array,int left,int right) {
		if(left == right) return array[left];
		int l = left,r = right,mid = (r - l)/2 + l;
		int maxL = findMaxValue(array,l,mid);
		int maxR = findMaxValue(array,mid+1,right);
		return Math.max(maxL, maxR);
	}
}
