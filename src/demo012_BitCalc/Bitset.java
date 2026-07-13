package demo012_BitCalc;

/**
 * @author TuanFans
 * @date 2026/7/8
 * <p><a href="https://leetcode.cn/problems/design-bitset">力扣2166. 设计位集</a></p>
 */
public class Bitset {
    private final int[] set;
    private int n;
    private int zeros;
    private int ones;
    private boolean reverse;

    public Bitset(int size) {
        set = new int[(size+31)/32];
        n = size;
        zeros = size;
    }

    public void fix(int idx) {
        int index = idx/32;
        int bits = idx%32;
        if(!reverse){
            // 正常状态：
            // 1表示存在
            // 0表示不存在
            if((set[index] & (1<<bits))==0){
                set[index] |= (1<<bits);
                zeros--;
                ones++;
            }
        }else{
            // 反转后的状态
            // 1表示不存在
            // 0表示存在
            if((set[index] & (1<<bits))!=0){
                set[index] ^= (1<<bits);
                zeros--;
                ones++;
            }
        }
    }

    public void unfix(int idx) {
        int index = idx/32;
        int bits = idx%32;
        if(!reverse){
            // 正常状态：
            // 1表示存在
            // 0表示不存在
            if((set[index] & (1<<bits))!=0){
                set[index] ^= (1<<bits);
                zeros++;
                ones--;
            }
        }else{
            // 反转后的状态
            // 1表示不存在
            // 0表示存在
            if((set[index] & (1<<bits))==0){
                set[index] |= (1<<bits);
                zeros++;
                ones--;
            }
        }
    }

    public void flip() {
        reverse = !reverse;
        int temp = zeros;
        zeros = ones;
        ones = temp;
    }

    public boolean all() {
        return ones==n;
    }

    public boolean one() {
        return ones>0;
    }

    public int count() {
        return ones;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0,k=0,number,status;i<n;k++){
            number = set[k];
            for(int j=0;j<32&&i<n;j++,i++){
                status = (number>>>j)&1;
                status ^= (reverse?1:0);
                sb.append(status);
            }
        }
        return sb.toString();
    }
}
