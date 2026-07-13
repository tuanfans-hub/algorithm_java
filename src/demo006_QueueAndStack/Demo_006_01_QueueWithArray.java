package demo006_QueueAndStack;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author TuanFans
 * @time 2025年12月7日 17:41:57
 * <p></p>
 */
@SuppressWarnings("unchecked")
public class Demo_006_01_QueueWithArray {
	/**
	 * 数组实现队列
	 * @param <T> 存储的数据类型
	 */
	public static class QueueWithArray<T>{
		private T[] queue;
		// 头
		private int left;
		// 尾
		private int right;
		
		// 传递数组类型的Class对象，用于创建数组；默认初始化数组大小为10
		public QueueWithArray(Class<T> clazz){
			this.queue = (T[])Array.newInstance(clazz, 10);
		}
		// 传递数组类型的Class对象，用于创建数组；指定数组初始化的大小
		public QueueWithArray(Class<T> clazz,int cap){
			this.queue = (T[])Array.newInstance(clazz, cap);
		}
		
		/**
		 * 判断队列是否为空
		 * @return 判断结构
		 */
		public boolean isEmpty() {
			return right==left;
		}
		
		public int size() {
			return right-left;
		}
		
		public void offer(T element) {
			queue[right++] = element;
		}
		
		public T poll() {
			return queue[left++];
		}
		
		public T peek() {
			return queue[left];
		}
		
		public void print() {
			for(int i = left;i < right;i++) {
				System.out.print(queue[i]+" ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 使用Java自带的队列
	 * @param <T> 存储的数据类型
	 */
	public static class QueueWithJDK<T>{
		private Queue<T> queue = new LinkedList<>();
		
		public int size() {
			return queue.size();
		}
		
		public boolean isEmpty() {
			return queue.isEmpty();
		}
		
		public void offer(T element) {
			queue.offer(element);
		}
		
		public T peek() {
			return queue.peek();
		}
		
		public T poll() {
			return queue.poll();
		}
	}
	
	public static void main(String[] args) {
		QueueWithArray<Integer> q = new QueueWithArray<>(Integer.class);
		
		for(int i = 0;i < 5;i++) {
			System.out.println("----offer()----");
			q.offer(i);
			System.out.println("isEmpty():"+q.isEmpty());
			System.out.println("size():"+q.size());
			q.print();
		}
		
		System.out.println("----peek()----");
		System.out.println("peek():"+q.peek());
		System.out.println("isEmpty():"+q.isEmpty());
		System.out.println("size():"+q.size());
		q.print();
		
		while(!q.isEmpty()) {
			System.out.println("----poll()----");
			System.out.println("poll():"+q.poll());
			System.out.println("isEmpty():"+q.isEmpty());
			System.out.println("size():"+q.size());
			q.print();
		}
	}
}
