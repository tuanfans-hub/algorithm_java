package demo006_QueueAndStack;

import java.util.Stack;
/**
 * @author TuanFans
 * @time 2025年12月8日 21:09:13
 * <p>
 * 使用栈实现队列
 * </p>
 */
public class Demo_006_04_ImplementQueueUseStack {
	public static class QueueUseStack<T>{
		private Stack<T> in;
		private Stack<T> out;
		
		public QueueUseStack() {
			this.in = new Stack<>();
			this.out = new Stack<>();
		}
		
		public void inque(T e) {
			in.push(e);
		}
		
		public T deque() {
			if(!out.isEmpty()) return out.pop();
			while(!in.isEmpty()) {
				out.push(in.pop());
			}
			return out.pop();
		}
		
		public T peek() {
			if(!out.isEmpty()) return out.peek();
			while(!in.isEmpty()) {
				out.push(in.pop());
			}
			return out.pop();
		}
		
		public int size() {
			return in.size()+out.size();
		}
		
		public boolean isEmpty() {
			return in.size()+out.size()==0;
		}
	}
}
