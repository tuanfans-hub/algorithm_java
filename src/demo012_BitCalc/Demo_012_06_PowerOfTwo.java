package demo012_BitCalc;

/**
 * @author TuanFans
 * @date 2026/7/7
 */
public class Demo_012_06_PowerOfTwo {
    static void main(){
        System.out.println(isPowerOfTwo(128));
    }

    static boolean isPowerOfTwo(int n){
        return n>0 && (n&(n-1))==0;
    }
}
