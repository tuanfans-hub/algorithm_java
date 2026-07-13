package demo006_QueueAndStack;

import java.lang.reflect.Array;
import java.util.Stack;

/**
 * @author TuanFans
 * @time 2025年12月7日 18:45:49
 * <p></p>
 */
@SuppressWarnings("unchecked")
public class Demo_006_02_StackWithArray {
	/**
	 * 数组实现栈结构
	 * @param <T> 栈存储的数据类型
	 */
	public static class StackWithArray<T>{
		private T[] stack;
		private int size;
		
		public StackWithArray(Class<T> clazz){
			this.stack = (T[])Array.newInstance(clazz,10);
		}
		
		public StackWithArray(Class<T> clazz,int cap) {
			this.stack = (T[])Array.newInstance(clazz, cap);
		}
		
		public int size() {
			return this.size;
		}
		
		public boolean isEmpty() {
			return size==0;
		}
		
		public void push(T e) {
			stack[size++] = e;
		}
		
		public T peek() {
			return stack[size-1];
		}
		
		public T pop() {
			return stack[--size];
		}
		
		public void print() {
			for(int i = 0;i<size;i++) {
				System.out.print(stack[i]+" ");
			}
			System.out.println();
		}
	}
	
	/**
	 * java自带的栈
	 * @param <T> 栈存储的数据类型
	 */
	public static class StackWithJDK<T>{
		private Stack<T> stack = new Stack<>();
		
		public int size() {
			return stack.size();
		}
		
		public boolean isEmpty() {
			return stack.isEmpty();
		}
		
		public void push(T e) {
			stack.push(e);
		}
		
		public T peek() {
			return stack.peek();
		}
		
		public T pop() {
			return stack.pop();
		}
	}
	
	public static void main(String[] args) {
		StackWithArray<Integer> s = new StackWithArray<>(Integer.class);
		
		for(int i = 0;i < 5;i++) {
			System.out.println("----push()----");
			s.push(i);
			System.out.println("isEmpty():"+s.isEmpty());
			System.out.println("size():"+s.size());
			s.print();
		}
		
		System.out.println("----peek()----");
		System.out.println("peek():"+s.peek());
		System.out.println("isEmpty():"+s.isEmpty());
		System.out.println("size():"+s.size());
		s.print();
		
		while(!s.isEmpty()) {
			System.out.println("----pop()----");
			System.out.println("poll():"+s.pop());
			System.out.println("isEmpty():"+s.isEmpty());
			System.out.println("size():"+s.size());
			s.print();
		}
	}
}
