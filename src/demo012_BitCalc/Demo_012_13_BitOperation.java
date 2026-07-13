package demo012_BitCalc;

/**
 * @author TuanFans
 * @date 2026/7/9
 * <p>使用位运算实现加减乘除运算</p>
 * <p><a href="https://leetcode.cn/problems/divide-two-integers/">力扣29. 两数相除</a></p>
 */
public class Demo_012_13_BitOperation {
    static class BitOperation{
        public static int bitAdd(int a,int b){
            int ans = a;
            // a+b = 不进位相加的结果 + 进位信息
            while(b!=0){
                // a ^ b: 不进位相加
                ans = a ^ b;
                // (a & b) << 1: a、b相加的进位信息
                b = (a & b) << 1;
                a = ans;
            }
            return ans;
        }

        public static int bitSub(int a,int b){
            // a-b = a+(-b)
            // -b = ~b+1
            return bitAdd(a,neg(b));
        }

        public static int bitMulti(int a, int b){
            // 原理：与小学数学相乘方法类似（竖乘法）
            int ans = 0;
            while(b!=0){
                if((b & 1) == 1){
                    ans = bitAdd(ans,a);
                }
                b >>>= 1;
                a <<= 1;
            }
            return ans;
        }

        public static int bitDiv(int a,int b){
            if(a==0) return 0;
            if(a==b) return 1;
            if(b==1) return a;
            if(b==-1){
                // 处理溢出情况: 如果 a==Integer.MIN_VALUE && b==-1，则结果为 Integer.MAX_VALUE
                // Integer.MIN_VALUE = -2147483648，Integer.MAX_VALUE = 2147483647
                // 特殊要求:
                // 当商<=Integer.MIN_VALUE时，返回Integer.MIN_VALUE
                // 当商>=Integer.MAX_VALUE时，返回Integer.MAX_VALUE
                if(a==Integer.MIN_VALUE) return Integer.MAX_VALUE;
                return neg(a);
            }
            if(a!=Integer.MIN_VALUE && b== Integer.MIN_VALUE) return 0;

            // 处理溢出情况: 如果 a==Integer.MIN_VALUE，a无法取反，需要进行特殊处理
            if(a == Integer.MIN_VALUE){
                if(b>0) return bitDiv(bitAdd(a,b),b)-1;
                else return bitDiv(bitSub(a,b),b)+1;
            }

            // 记录最终结果是否为负数
            boolean negative = (a < 0) ^ (b < 0);

            // 将除数和被除数都转为正数
            a = a<0?neg(a):a;
            b = b<0?neg(b):b;
            // 原理：
            // 如果 a = b*2^h + b*2^i + ... + b*2^n
            // 那么 a/b = 2^h + 2^i + ... + 2^n
            int ans = 0;
            for(int i = 30;i>=0;i=bitSub(i,1)){
                if(a>>>i >= b){
                    ans |= (1 << i);
                    // b<<i = b*2^i
                    a = bitSub(a,b << i);
                }
            }
            return negative?neg(ans):ans;
        }

        public static int neg(int n){
            return bitAdd(~n,1);
        }
    }

    static void main(){
        IO.println(BitOperation.bitAdd(-100,25));
        IO.println(BitOperation.bitSub(-100,-25));
        IO.println(BitOperation.bitMulti(-100,25));
        IO.println(Integer.MIN_VALUE);
        IO.println(BitOperation.bitDiv(Integer.MIN_VALUE,2));
    }
}
