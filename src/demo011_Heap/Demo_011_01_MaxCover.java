package demo011_Heap;

import java.io.*;
import java.util.*;
/**
 * @author TuanFans
 * @time 2026年5月18日 20:07:44
 * <p>
 * 利用堆结构解决线段重合问题
 * https://www.nowcoder.com/practice/1ae8d0b6bb4e4bcdbf64ec491f63fc37
 * 
 * 描述：
 * 每一个线段都有start和end两个数据项，表示这条线段在X轴上从start位置开始到end位置结束。
 * 给定一批线段，求所有重合区域中最多重合了几个线段，首尾相接的线段不算重合。
 * 例如：线段[1,2]和线段[2.3]不重合。
 * 线段[1,3]和线段[2,3]重合
 * 
 * 输入描述：
 * 第一行一个数N，表示有N条线段
 * 接下来N行每行2个数，表示线段起始和终止位置
 * 输出描述：
 * 输出一个数，表示同一个位置最多重合多少条线段
 * 
 * 输入：
3
1 2
2 3
1 3
 * 
 * 输出：2
 * </p>
 */
public class Demo_011_01_MaxCover {
	public static int MAXN = 10001;
	public static int[][] array = new int[MAXN][2];
	public static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer in = new StreamTokenizer(br);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		in.nextToken();
		n = (int)in.nval;
		int i = 0;
		while(i<n && in.nextToken()!=StreamTokenizer.TT_EOF) {
			array[i][0] = (int)in.nval;
			in.nextToken();
			array[i][1] = (int)in.nval;
			i++;
		}
		out.println(findMaxCover());
		out.flush();
		out.close();
		br.close();
	}
	public static int findMaxCover() {
		// 排序：根据线段start数据，进行从小到大排序
		Arrays.sort(array,0,n,(a,b)->a[0]-b[0]);
		// 小根堆：存储线段的end数据
		PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->a-b);
		// 遍历每个线段
		int ans = 0;
		for(int i=0;i<n;i++) {
			int[] cur = array[i];
			// 将小根堆中所有小于或等于当前线段的start数据的end数据出队
			while(!heap.isEmpty() && cur[0]>=heap.peek()) {
				heap.poll();
				// 更新ans的值，保持最多的线段重合数
				ans = Math.max(ans, heap.size());
			}
			// 向小根堆中添加当前线段的end数据
			heap.add(cur[1]);
			ans = Math.max(ans, heap.size());
		}
		
		return ans;
	}
}
