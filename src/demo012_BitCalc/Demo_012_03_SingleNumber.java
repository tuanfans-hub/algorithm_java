package demo012_BitCalc;

/**
 * @author TuanFans
 * @date 2026/7/6
 * <p>
 *     给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 * </p>
 */
public class Demo_012_03_SingleNumber {
    static void main(){
        int[] nums = {4,1,2,1,2};
        System.out.println(findSingleNumber(nums));
    }

    static int findSingleNumber(int[] nums){
        int ans = 0;
        for(int num:nums){
            ans ^= num;
        }
        return ans;
    }
}
