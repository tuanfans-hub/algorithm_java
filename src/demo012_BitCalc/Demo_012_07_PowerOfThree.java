package demo012_BitCalc;

/**
 * @author TuanFans
 * @date 2026/7/7
 */
public class Demo_012_07_PowerOfThree {

    static void main(){
        System.out.println(isPowerOfThree(1));
    }
    public static boolean isPowerOfThree(int n) {
        // 如果一个数字是3的某次幂，那么这个数一定只含有3这个质数因子
        // 1162261467是int型范围内，最大的3的幂，它是3的19次方
        // 这个1162261467只含有3这个质数因子，如果n也是只含有3这个质数因子，那么1162261467 % n == 0
        // 反之如果1162261467 %n！=0 说明n一定含有其他因子
        // return n>0 && (1162261467%n)==0;

        if(n==0) return false;
        while(n%3==0){
            n /= 3;
        }
        return n==1;
    }
}
