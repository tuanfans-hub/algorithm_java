package demo012_BitCalc;


/**
 * @author TuanFans
 * @date 2026/7/6
 * <p>
 *     给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
 * </p>
 */
public class Demo_012_04_SingleNumberII {
    static void main(){
        int[] nums = {0,1,0,1,0,1,99};
        System.out.println(singleNumber(nums,3));
    }

    static int singleNumber(int[] nums,int m){
        int ans = 0;
        int[] counter = new int[32];
        for(int num:nums){
            for(int i = 0;i < 32;i++){
                counter[i] += ((num >> i) & 1);
            }
        }
        for(int i = 0;i < 32;i++){
            if(counter[i]%m!=0){
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
