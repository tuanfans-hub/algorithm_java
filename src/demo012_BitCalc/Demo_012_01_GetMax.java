package demo012_BitCalc;

/**
 * @author TuanFans
 * @date 2026/7/4
 * <p>
 *     给定两个有符号32位整数a和b，返回a和b中较大的。（不使用if-else语句，不使用比较运算符）
 * </p>
 */
public class Demo_012_01_GetMax {
    static void main(){
        int a = Integer.MIN_VALUE;
        int b = Integer.MAX_VALUE;
        System.out.println(getMax1(a,b));
        System.out.println(getMax2(a,b));
    }

    static int getMax1(int a,int b){
        int delta = a-b;
        // delta<0 => mask=0XFFFFFFFF
        // delta>=0 => mask=0X00000000
        int mask = delta >> 31;
        return (a & mask) | (b & ~mask);
    }

    static int getMax2(int a,int b){
        // a-b的差值
        int delta = a - b;
        // a的正负：负数为0，正数为1
        int sa = (a >>> 31) ^ 1;
        // b的正负：负数为0，正数为1
        int sb = (b >>> 31) ^ 1;
        // delta的正负：负数为0，正数为1
        int s_delta = (delta >>> 31) ^ 1;
        // a与b的正负符号不同的情况
        int diffAB = sa ^ sb;
        // a与b的正负符号相同的情况
        int sameAB = 1 ^ diffAB;
        // 什么时候返回a呢？
        // 1. a与b的正负符号不同，且a为正数
        // 2. a与b的正负符号相同，且delta为正数
        int returnA = diffAB * sa + sameAB * s_delta;
        // 什么时候返回b呢？
        // 不返回a，即返回b
        int returnB = 1 ^ returnA;
        return a * returnA + b * returnB;
    }

}
