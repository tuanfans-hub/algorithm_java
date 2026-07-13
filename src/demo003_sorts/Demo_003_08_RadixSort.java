package demo003_sorts;

import java.util.Arrays;

/**
 * @author TuanFans
 * @date 2026/7/4
 * <p>基数排序</p>
 */
public class Demo_003_08_RadixSort {
    static void main(){
        for(int base = 10;base <= Integer.MAX_VALUE/10;base*=10){
            System.out.println("------------------------\tBASE: " + base + "\t----------------------");
            // int[] nums = {132123,1123,1,123,1234,12345,123456,1234567,12345678,123456789};
            int[] nums = {651651,74985,4165,123,165,1654,15656,92552,136545,98652,132123,1123,1,123,1234,12345};
            System.out.println(Arrays.toString(nums));
            long start = System.nanoTime();
            radixSort(nums,base,getBits(nums, base));
            long end = System.nanoTime();
            System.out.println(Arrays.toString(nums));
            System.out.println("Time: " + (end - start) + " ns");
        }
    }

    static int getBits(int[] nums,int base){
        int max = nums[0];
        for(int num : nums){
            max = Math.max(max, num);
        }
        int bits = 0;
        while(max>0){
            max = max / base;
            bits++;
        }
        return bits;
    }

    static void radixSort(int[] array,int base,int bits){
        int[] helper = new int[array.length];
        int[] counter = new int[base];
        for(int offset = 1;bits>0;offset*=base,bits--){
            Arrays.fill(counter,0);
            for (int num : array) {;
                counter[(num / offset) % base]++;
            }
            for (int i = 1; i < counter.length; i++) {
                counter[i] += counter[i - 1];
            }
            for(int i = array.length-1;i>=0;i--){
                helper[--counter[(array[i]/offset)%base]] = array[i];
            }
            System.arraycopy(helper, 0, array, 0, array.length);
        }
    }
}
