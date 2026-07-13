package demo003_sorts;

import java.util.Arrays;

import demo000_utils.Utils;

/**
 * @author TuanFans
 * @time 2026年5月12日 00:40:24
 * <p>
 * 堆排序：利用堆结构实现排序；
 * 向顶到底建大根堆：时间复杂度：logn+log(n-1)+...+log2+log1 = O(n*logn)
 * 向底到顶建大根堆：时间复杂度：(n/2)*1 + (n/4)*2 + ... + (n/n)*(logn) = O(n)
 * </p>
 */
public class Demo_003_07_HeapSort {

	public static void main(String[] args) {
		System.out.println("--------------从顶构建大根堆实现堆排序-------------");
		// 从顶构建大根堆：时间复杂度为O(n*logn)
		Utils.testSort(array->heapSort1(array), 10);
		System.out.println("--------------从底构建大根堆实现堆排序-------------");
		// 从底构建大根堆：时间复杂度为O(n)
		Utils.testSort(array->heapSort2(array), 10);
	}
	
	// 从顶到底建大根堆的方式实现堆排序
	public static void heapSort1(int[] array) {
		int size = array.length;
		// 构建大根堆
		for(int i=1;i<size;i++) {
			heapInsert(array,i);
		}
		System.out.println("heapInsert done:"+Arrays.toString(array));
		while(size>1) {
			swap(array,0,--size);
			heapify(array,size,0);
		}
	}
	
	// 从底到顶建大根堆的方式实现堆排序
	public static void heapSort2(int[] array) {
		int size = array.length;
		// 构建大根堆
		for(int i=size-1;i>=0;i--) {
			if(2*i+1<size) {
				heapify(array,size,i);
			}
		}
		System.out.println("heapify done:"+Arrays.toString(array));
		while(size>1) {
			swap(array,0,--size);
			heapify(array,size,0);
		}
	}
	
	// 向上调整，使其满足堆结构
	public static void heapInsert(int[] array,int i) {
		while(array[i]>array[(i-1)/2]) {
			swap(array,i,(i-1)/2);
			i = (i-1)/2;
		}
	}
	
	// 向下调整，使其满足堆结构
	public static void heapify(int[] array,int size,int i) {
		int l = 0;
		while(i<size) {
			l = 2*i+1;
			int bast = (l+1<size && array[l+1]>array[l])?l+1:l;
			// 如果bast索引超出size范围，或则当前待调整的数大于或等于较大的子节点的值，表示索引确定，退出循环
			if(bast>=size || array[i]>=array[bast]) break;
			// 否则交换索引位置，继续下一轮循环
			swap(array,i,bast);
			i = bast;
		}
	}
	
	public static void swap(int[] array,int i,int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
