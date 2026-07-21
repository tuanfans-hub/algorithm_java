package demo008_Recusion;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author TuanFans
 * @time 2026/7/21 19:15
 * <p>使用递归排序栈</p>
 */
public class Demo_008_07_SortStackWithRecursion {
    // 方法一：先找到最小的元素
    public static void sort(Deque<Integer> stack){
        if(stack.isEmpty()) return;
        int min = popMin(stack);
        sort(stack);
        stack.push(min);
    }

    public static int popMin(Deque<Integer> stack){
        int cur = stack.pop();
        if(stack.isEmpty()) {
            return cur;
        }
        int min = popMin(stack);
        stack.push(Math.max(cur,min));
        return Math.min(cur,min);
    }

    // 方法二：先找到最大的元素，然后将最大的元素放到底部
    public static void sort2(Deque<Integer> stack){
        if(stack.isEmpty()) return;
        sort2(stack,stack.size());
    }

    public static void sort2(Deque<Integer> stack,int deep){
        if(deep==1) return;
        int max = max(stack,deep);
        int count = count(stack,deep,max);
        down(stack,deep,max,count);
        sort2(stack,deep-1);
    }

    public static int max(Deque<Integer> stack,int deep){
        if(deep==0) return Integer.MIN_VALUE;
        int cur = stack.pop();
        int max = max(stack,deep-1);
        stack.push(cur);
        return Math.max(cur,max);
    }

    public static int count(Deque<Integer> stack,int deep,int max){
        if(deep==0) return 0;
        int cur = stack.pop();
        int count = count(stack,deep-1,max);
        stack.push(cur);
        return cur==max?count+1:count;
    }

    public static void down(Deque<Integer> stack,int deep,int max,int count){
        if(deep==0){
            for(int i = 0 ;i<count;i++) stack.push(max);
            return;
        }
        int cur = stack.pop();
        down(stack,deep-1,max,count);
        if(cur!=max) stack.push(cur);
    }

    static void main() {
        IO.println("------------方法一------------");
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(10);
        stack.push(2);
        stack.push(15);
        stack.push(654);
        stack.push(57);
        IO.println("排序前:"+stack);
        sort(stack);
        IO.println("排序后:"+stack);

        IO.println("------------方法二------------");
        Deque<Integer> stack2 = new ArrayDeque<>();
        stack2.push(10);
        stack2.push(2);
        stack2.push(15);
        stack2.push(654);
        stack2.push(57);
        IO.println("排序前:"+stack2);
        sort2(stack2);
        IO.println("排序后:"+stack2);
    }
}
