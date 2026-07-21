package demo008_Recusion;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author TuanFans
 * @time 2026/7/21 19:01
 * <p>使用递归反转栈</p>
 */
public class Demo_008_06_ReverseStackWithRecursion {
    public static <T> void reverse(Deque<T> stack){
        if(stack.isEmpty()) return;
        T cur = popBottom(stack);
        reverse(stack);
        stack.push(cur);
    }

    public static <T> T popBottom(Deque<T> stack){
        T cur = stack.pop();
        if(stack.isEmpty()) {
            return cur;
        }else{
            T last = popBottom(stack);
            stack.push(cur);
            return last;
        }
    }

    static void main() {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        IO.println("反转前:"+stack);
        reverse(stack);
        IO.println("反转后:"+stack);
    }
}
