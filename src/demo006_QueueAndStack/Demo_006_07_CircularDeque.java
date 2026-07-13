package demo006_QueueAndStack;

import java.util.List;
import java.util.Random;
import java.util.Arrays;
import java.util.LinkedList;
/**
 * @author TuanFans
 * @time 2025年12月9日 20:41:04
 * <p>
 * 循环双端队列
 * 
 * </p>
 */
public class Demo_006_07_CircularDeque {
	/**
	 * 使用LinkedList实现循环双端队列
	 * @param <T> 队列存储的数据类型
	 */
	public static class CircularDeque<T>{
		private List<T> cd;
		private int limit;
		private int size;
		
		public CircularDeque(int k) {
			cd = new LinkedList<>();
			limit = k;
			size = 0;
		}
		
		public boolean insertFront(T value) {
			if(isFull()) return false;
			cd.addFirst(value);
			size++;
			return true;
		}
		
		public boolean insertLast(T value) {
			if(isFull()) return false;
			cd.add(value);
			size++;
			return true;
		}
		
		public boolean deleteFront() {
			if(isEmpty()) return false;
			cd.removeFirst();
			size--;
			return true;
		}
		
		public boolean deleteLast() {
			if(isEmpty()) return false;
			cd.removeLast();
			size--;
			return true;
		}
		
		public T getFront() {
			if(isEmpty()) return null;
			return cd.getFirst();
		}
		
		public T getRear() {
			if(isEmpty()) return null;
			return cd.getLast();
		}
		
		public boolean isEmpty() {
			return cd.size() == 0;
		}
		
		public boolean isFull() {
			return cd.size() == limit;
		}
		
		public int size() {
			return this.size;
		}
	}
	
	// 使用数组实现循环双端队列
	public static class CircularDeque2{
		private int[] queue;
		private int limit;
		private int size;
		private int start;
		private int end;
		
		public CircularDeque2(int limit) {
			this.limit = limit;
			this.queue = new int[limit];
			this.size = 0;
			this.start = 0;
			this.end = 0;
		}
		
		public boolean insertFront(int val) {
			if(isFull()) return false;
			if(isEmpty()) {
				start=end=0;
				queue[0] = val;
			}else {
				start = start==0?limit-1:start-1;
				queue[start] = val;
			}
			size++;
			return true;
		}
		
		public boolean insertLast(int val) {
			if(isFull()) return false;
			if(isEmpty()) {
				start=end=0;
				queue[0] = val;
			}else {
				queue[end] = val;
				end = end==limit-1?0:end+1;
			}
			size++;
			return true;
		}
		
		public boolean deleteFront() {
			if(isEmpty()) return false;
			start = start==limit-1?0:start+1;
			size--;
			return true;
		}
		
		public boolean deleteLast() {
			if(isEmpty()) return false;
			end = end==0?limit-1:end-1;
			size--;
			return true;
		}
		
		public int getFront() {
			if(isEmpty()) throw new RuntimeException();
			return queue[start];
		}
		
		public int getRear() {
			if(isEmpty()) throw new RuntimeException();
			return queue[end];
		}
		
		public boolean isEmpty() {
			return this.size == 0;
		}
		
		public boolean isFull() {
			return this.size == this.limit;
		}
		
		public int size() {
			return this.size;
		}
		
		public String toString() {
			return Arrays.toString(queue);
		}
	}
	
	public static void main(String[] args) {
		CircularDeque2 cd2 = new CircularDeque2(5);
		Random rand = new Random();
		for(int i = 0;i < 5;i++) {
			int value = rand.nextInt(100);
			System.out.println(i+"->"+value);
			cd2.insertFront(value);
		}
		System.out.println(cd2.toString());
		
		for(int j = 0;j < 5;j++) {
			int rear = cd2.getRear();
			System.out.println(j+"->"+rear);
			cd2.deleteLast();
		}
		System.out.println(cd2.toString());
	}
}
