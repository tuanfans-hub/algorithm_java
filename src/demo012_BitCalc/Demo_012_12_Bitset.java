package demo012_BitCalc;

import java.util.HashSet;
import java.util.Set;

/**
 * @author TuanFans
 * @date 2026/7/8
 */
public class Demo_012_12_Bitset {
    static void main(){
        IO.println("==============对数器校验==============");
        int n = 1000;
        int testCount = 10000;
        double rand = 0;
        int num = 0;
        Bitset bitset = new Bitset(n);
        Set<Integer> hashSet = new HashSet<>();
        for(int i = 0;i < testCount;i++){
            rand = Math.random();
            num = (int)(Math.random()*n);
            if(rand<0.33){
                bitset.add(num);
                hashSet.add(num);
            }else if(rand<0.66){
                bitset.remove(num);
                hashSet.remove(num);
            }else{
                bitset.reverse(num);
                if(hashSet.contains(num)) hashSet.remove(num);
                else hashSet.add(num);
            }
        }
        IO.println("bitset size: " + bitset.size() + ", hashSet size: " + hashSet.size());
        boolean success = true;
        for(int i = 0;i < n;i++){
            if(bitset.contains(i) != hashSet.contains(i)){
                success = false;
                IO.println("Error is happened");
            }
        }
        if(success) IO.println("Test is success");
        IO.println("Test is end");
    }

    /**
     * 位图: 一种数据结构，用于表示一个整数集合。
     * 相当于一个数组，数组的每个元素是一个整数，整数的每一位表示一个布尔值，0或1。
     * 通过位运算操作，可以高效地进行集合的添加、删除和查询操作。
     * 可以把它当作HashSet的替代品，用于表示一个整数集合。
     */
    public static class Bitset{
        private final int[] set;
        private int size;
        public Bitset(int n){
            set = new int[(n+31)/32];
            size = 0;
        }

        public void add(int num){
            if(!contains(num)) size++;
            set[num/32] |= 1<<(num%32);
        }

        public void remove(int num){
            if(contains(num)) size--;
            set[num/32] &= ~(1<<(num%32));
        }

        public void reverse(int num){
            if(contains(num)) size--;
            else size++;
            set[num/32] ^= 1<<(num%32);
        }

        public boolean contains(int num){
            return ((set[num/32]>>>(num%32)) & 1) == 1;
        }

        public int size(){
            return size;
        }
    }
}
