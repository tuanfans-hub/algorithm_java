package demo012_BitCalc;

/**
 * @author TuanFans
 * @date 2026/7/7
 * <p>
 *     颠倒给定的 32 位有符号整数的二进制位。
 * </p>
 */
public class Demo_012_10_ReverseBits {
    static void main(){
        System.out.println(reverseBits(43261596));// 964176192
        System.out.println(reverseBits2(43261596));// 964176192
    }

    static int reverseBits(int n){
        int ans = 0;
        for(int i = 0;i < 32;i++){
            int t = (n >>> i) & 1;
            if(t==1){
                ans |= (1 << (31-i));
            }
        }
        return ans;
    }

    static int reverseBits2(int n){
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = (n >>> 16) | (n << 16);
        return n;
    }
}
