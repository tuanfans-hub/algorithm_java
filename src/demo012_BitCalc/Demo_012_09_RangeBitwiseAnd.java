package demo012_BitCalc;

/**
 * @author TuanFans
 * @date 2026/7/7
 * <p>
 *     给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 * </p>
 */
public class Demo_012_09_RangeBitwiseAnd {
    static void main(){
        System.out.println(rangeBitwiseAnd(5,7));// 4
    }

    static int rangeBitwiseAnd(int left,int right){
        // 按位与运算：只会留下所有参与运算的数中二进制位都为1的进制位，因为0 & 0 = 0, 0 & 1 = 0, 1 & 1 = 1
        while(left<right){
            // right-1会将right最右边的1变为0,再与right进行按位与运算会消掉right最右边的1
            // 例如：right=7=00000111(2), right-1=6=00000110(2)
            right &= (right-1);
            // left<right时，right最右边的1会逐渐消掉，直到left和right相等
            // right &= (right-1)：消掉right最右边的1，此时right=00000110(2),大于left=00000101(2)
            // 说明num=right-1=00000101(2),还在[left, right]范围内,
            // 那么说明新的right最右边的1参与按位与运算之后也会被消掉，所以继续消掉新的right最右边的1
            // 重复以上步骤，知道left和right相等
        }
        return right;
    }
}
