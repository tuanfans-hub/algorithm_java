package demo012_BitCalc;

import java.util.Arrays;

/**
 * @author TuanFans
 * @date 2026/7/6
 * <p>
 *     给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
 * </p>
 */
public class Demo_012_05_SingleNumberIII {
    static void main(){
        int[] nums = {1,2,1,3,2,5};
        System.out.println(Arrays.toString(singleNumber(nums)));
    }

    static int[] singleNumber(int[] nums){
        int ans0=0,eor=0;
        for(int num:nums) eor^=num;
        int rightOne = eor&(-eor);
        for(int num:nums){
            if((num&rightOne)==0) ans0^=num;
        }
        return new int[]{ans0,ans0^eor};
    }
}
