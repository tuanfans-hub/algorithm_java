package demo012_BitCalc;

/**
 * @author TuanFans
 * @date 2026/7/6
 */
public class Demo_012_02_MissNumber {
    static void main(){
        int[] nums = {0,1,2,3,4,5,6,8,9,10};
        System.out.println(getMissNumber(nums));
    }

    static int getMissNumber(int[] nums){
        int ans = 0;
        int n = nums.length;
        for(int i = 0;i <= n;i++){
            if(i<n) ans ^= i ^ nums[i];
            else ans ^= i;
        }
        return ans;
    }
}
