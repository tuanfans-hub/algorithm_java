package demo006_QueueAndStack;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author TuanFans
 * @time 2025年12月7日 19:25:53
 * <p></p>
 */
@SuppressWarnings("unchecked")
public class Demo_006_03_CircleQueue {
	/**
	 * 循环队列：只要队列大小小于队列的最大限制，就可以往队列中添加元素。
	 * @param <T> 存储数据类型
	 */
	public static class CircleQueue<T>{
		private T[] queue;
		private int size;
		private int limit;
		private int left;
		private int right;
		
		public CircleQueue(Class<T> clazz) {
			this.limit = 10;
			this.queue = (T[]) Array.newInstance(clazz, limit);
		}
		
		public CircleQueue(Class<T> clazz,int limit) {
			this.limit = limit;
			this.queue = (T[])Array.newInstance(clazz,limit);
		}
		
		public int size() {
			return this.size;
		}
		
		public boolean isEmpty() {
			return this.size==0;
		}
		
		public boolean isFull() {
			return this.size==this.limit;
		}
		
		public void offer(T e) throws Exception {
			if(size==limit) {
				throw new Exception("超出队列大小");
			}
			queue[right++] = e;
			right = right<limit?right:(right%limit);
			size++;
		}
		
		public T peek() throws Exception {
			if(isEmpty()) throw new Exception("队列为空，没有元素");
			return queue[left];
		}
		
		public T poll() throws Exception{
			if(isEmpty()) throw new Exception("队列为空，没有元素");
			T ans = queue[left++];
			left %= limit;
			size--;
			return ans;
		}
		
		public void print() {
			int i = left;
			while(i!=right) {
				System.out.print(queue[i++]+" ");
				i = i<limit?i:i%limit;
			}
			System.out.println();
		}
		
		public static void main(String[] args) throws Exception {
			CircleQueue<Integer> cq = new CircleQueue<>(Integer.class,5);
			
			for(int i = 0;i < 3;i++) {
				System.out.println("----offer()----");
				cq.offer(i);
				System.out.println("isEmpty():"+cq.isEmpty());
				System.out.println("size():"+cq.size());
				cq.print();
			}
			
			System.out.println("----peek()----");
			System.out.println("peek():"+cq.peek());
			System.out.println("isEmpty():"+cq.isEmpty());
			System.out.println("size():"+cq.size());
			cq.print();
			
			System.out.println("queue"+Arrays.toString(cq.queue));
			
			while(!cq.isEmpty()) {
				System.out.println("----poll()----");
				System.out.println("poll():"+cq.poll());
				System.out.println("isEmpty():"+cq.isEmpty());
				System.out.println("size():"+cq.size());
				cq.print();
				System.out.println("queue:"+Arrays.toString(cq.queue));
			}
			
			
			for(int i = 0;i < 3;i++) {
				System.out.println("----offer()----");
				cq.offer(i+10);
				System.out.println("isEmpty():"+cq.isEmpty());
				System.out.println("size():"+cq.size());
				cq.print();
				System.out.println("queue:"+Arrays.toString(cq.queue));
			}
			
			
		}
	}
}
