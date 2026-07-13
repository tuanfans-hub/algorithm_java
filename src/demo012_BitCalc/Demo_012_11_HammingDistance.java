package demo012_BitCalc;

/**
 * @author TuanFans
 * @date 2026/7/7
 * <p>
 *     两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * </p>
 *
 * <p>
 *      给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * </p>
 */
public class Demo_012_11_HammingDistance {

    static void main(){
        System.out.println(hammingDistance(1, 4));// 2
        System.out.println(hammingDistance2(1, 4));// 2
    }

    static int hammingDistance(int x,int y){
        int num = x ^ y;
        int ans = 0;
        for(int i = 0;i < 32;i++){
            ans += ((num >>> i) & 1);
        }
        return ans;
    }

    static int hammingDistance2(int x,int y){
        int n = x ^ y;
        n = (n & 0x55555555)+((n>>>1) & 0x55555555);
        n = (n & 0x33333333)+((n>>>2) & 0x33333333);
        n = (n & 0x0f0f0f0f)+((n>>>4) & 0x0f0f0f0f);
        n = (n & 0x00ff00ff)+((n>>>8) & 0x00ff00ff);
        n = (n & 0x0000ffff)+((n>>>16) & 0x0000ffff);
        return n;
    }
}
