package demo006_QueueAndStack;

import java.util.Queue;
import java.util.LinkedList;
/**
 * @author TuanFans
 * @time 2025年12月8日 21:17:51
 * <p>
 * 使用队列实现栈
 * </p>
 */
public class Demo_006_05_ImplementStackUseQueue {
	public static class StackUseQueue<T>{
		private Queue<T> queue;
		
		public StackUseQueue() {
			this.queue = new LinkedList<>();
		}
		
		public void push(T e) {
			int n = queue.size();
			queue.offer(e);
			for(int i = 0;i < n;i++) {
				queue.offer(queue.poll());
			}
		}
		
		public T pop() {
			return queue.poll();
		}
		
		public T peek() {
			return queue.peek();
		}
		
		public boolean isEmpty() {
			return queue.isEmpty();
		}
		
		public int size() {
			return queue.size();
		}
	}
}
