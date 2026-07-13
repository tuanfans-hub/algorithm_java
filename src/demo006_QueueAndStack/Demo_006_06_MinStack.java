package demo006_QueueAndStack;

import java.util.Stack;
/**
 * @author TuanFans
 * @time 2025年12月9日 18:42:35
 * <p>
 * 最小栈
 * </p>
 */
public class Demo_006_06_MinStack {
	public static class MinStack<T extends Comparable<T>>{
		// 存放数据的栈
		private Stack<T> data;
		// 存放当前data栈中的最小元素
		private Stack<T> min;
		
		public MinStack() {
			data = new Stack<>();
			min = new Stack<>();
		}
		
		public int size() {
			return data.size();
		}
		
		public boolean isEmpty() {
			return data.isEmpty();
		}
		
		public void push(T e) {
			// data为空，即min也为空，data的最小值就是添加的当前值
			if(data.isEmpty()) min.push(e);
			// min栈顶的元素<=待添加元素，说明即使添加了当前元素，最小值依旧是min的当前栈顶元素，所以向min栈中再次添加min的栈顶元素
			else if(min.peek().compareTo(e)<=0) min.push(min.peek());
			// min栈顶元素>待添加元素，说明添加当前元素后，最小值为当前待添加元素，所以向min栈中添加当前待添加元素
			else min.push(e);
			data.push(e);
		}
		
		public T peek() {
			return data.peek();
		}
		
		public T pop() {
			min.pop();
			return data.pop();
		}
		
		public T getMin() {
			return min.peek();
		}
	}
}
