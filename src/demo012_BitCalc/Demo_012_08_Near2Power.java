package demo012_BitCalc;

/**
 * @author TuanFans
 * @date 2026/7/7
 */
public class Demo_012_08_Near2Power {
    static void main(){
        System.out.println(near2power(10));
        System.out.println(near2power2(10));
    }

    static int near2power(int n){
        int res = 1;
        while(res < n) res *= 2;
        return res;
    }

    static int near2power2(int n){
        if(n<=0) return 1;
        // 为什么要n--？
        // 如果n已经是2的幂，则n--后n变为2的幂-1，这样n++后就是2的幂。否则位数都刷成1之后，再加1就不是2的幂了
        n--;
        // 例如：n=10=00001010(2)，n-1=00001001(2)
        // n |= (n>>>1), n=00001100(2)
        n |= (n>>>1);
        // n |= (n>>>2), n=00001111(2)
        n |= (n>>>2);
        // n |= (n>>>4), n=00001111(2)
        n |= (n>>>4);
        // n |= (n>>>8), n=00001111(2)
        n |= (n>>>8);
        // n |= (n>>>16), n=00001111(2)
        n |= (n>>>16);
        // n+1=00010000(2)=16
        return n+1;
    }
}
