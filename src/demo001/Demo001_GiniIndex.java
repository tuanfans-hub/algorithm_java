package demo001;
import java.util.Arrays;
import java.util.Scanner;
/**
 * @author TuanFans
 * @time 2025年11月29日 18:20:42
 * <p>基尼系数：描绘了一个国家或地区收入（或财富）的累积分布情况</p>
 * 基尼系数 = 差值绝对值的和 / （2 * 人数 * 财富总和）
 * 基尼系数取值0~1，基尼系数越小，财富分布越均匀。
 * 基尼系数>0.5时，说明财富分布已经非常不均匀了，犯罪率高。
 * 一开始有100个人，每个人都有100元在每一轮都做如下的事情：
 * 每个人都必须拿出1元钱给除自己以外的其他人，给谁完全随机。
 * 如果某个人在这一轮的钱数为0，那么他可以不给，但是可以接收发生。
 * 很多很多轮之后，这100人的社会财富分布很均匀吗？
 */
public class Demo001_GiniIndex {
	public static double[] wealth = new double[100];
	public static boolean[] zero = new boolean[100];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int initMoney = 100;
		Arrays.fill(wealth, initMoney);
		Arrays.fill(zero, false);
		System.out.print("轮数：");
		int count = sc.nextInt();
		experiment(count);
		double gini = calculateGini(wealth);
		Arrays.sort(wealth);
		System.out.println(Arrays.toString(wealth));
		System.out.println("基尼系数为："+gini);
		sc.close();
	}
	
	public static void experiment(int count) {
		int n = wealth.length;
		for(int s = 0;s < count;s++) {
			// 统计没钱的人
			for(int i = 0;i < n;i++) {
				zero[i] = wealth[i]>0?false:true;
			}
			// 给其他人钱
			for(int i = 0;i < n;i++) {
				if(!zero[i]) {
					int to = i;
					// do-while循环表示：如果随机的对象是自己，则重新选定随机对象
					do {
						// 等概率随机[0,n)的整数
						to = (int)(Math.random()*n);
					}while(to==i);
					wealth[i]--;
					wealth[to]++;
				}
			}
		}
	}
	
	/**
	 * 计算基尼系数
	 * @param wealth 财富数组
	 * @return 基尼系数
	 */
	public static double calculateGini(double[] wealth) {
		int n = wealth.length;
		double total = 0;
		double diff = 0;
		for(int i = 0;i < n;i++) {
			total += wealth[i];
			for(int j = 0;j < n;j++) {
				if(i!=j) {
					diff += Math.abs(wealth[i]-wealth[j]);
				}
			}
		}
		return diff/(2*n*total);
	}

}
