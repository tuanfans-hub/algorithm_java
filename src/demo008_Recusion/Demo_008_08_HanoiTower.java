package demo008_Recusion;

import java.util.List;

/**
 * @author TuanFans
 * @time 2026/7/21 21:10
 * <p><a href="https://leetcode.cn/problems/hanota-lcci/description/">面试题 08.06. 汉诺塔问题</a></p>
 */
public class Demo_008_08_HanoiTower {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        hanota(n,A,B,C);
    }

    public void hanota(int n,List<Integer> from,List<Integer> other,List<Integer> to){
        if(n==1) {
            move(from,to);
            return;
        }

        hanota(n-1,from,to,other);
        hanota(1,from,other,to);
        hanota(n-1,other,from,to);
    }

    public void move(List<Integer> from,List<Integer> to){
        to.addLast(from.removeLast());
    }



    // 存在问题的解法: 盘子超过3个时，栈溢出：StackOverflowError
    // 将所有盘子从第一根柱子移到最后一根柱子。
    public static void hanota2(List<Integer> A, List<Integer> B, List<Integer> C) {
        if(A.isEmpty()) return;
        if(A.size()==1) {
            move2(A,C);
            return;
        }

        // 本意：忽略最底层的盘子
        // A.removeFirst();取最底层的盘子存在问题：
        // 本来到达了C的盘子，不会在被移动。但是当ListC作为参数传递给A时，A.removeFirst()会将C中的本来已经排好的盘子移出C,打乱盘子的顺序
        // 问什么盘子超过3时，才会出问题呢？因为运气好
        int f = A.removeFirst();
        // 将A中除最底层的盘子移到B
        hanota2(A,C,B);
        // 将最底层的盘子移到C
        C.addLast(f);
        // 将B中的盘子移到C
        hanota2(B,A,C);
    }

    public static void move2(List<Integer> from, List<Integer> to){
        to.addLast(from.removeLast());
    }

    public static void printHanota(int n,String from,String other,String to){
        if(n==1) {
            System.out.println("移动盘子：从 " + from + " 到 " + to);
            return;
        }
        printHanota(n-1,from,to,other);
        printHanota(1,from,other,to);
        printHanota(n-1,other,from,to);
    }

    public static void main(String[] args) {
        printHanota(4,"A","B","C");
    }
}
