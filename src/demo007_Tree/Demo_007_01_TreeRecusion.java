package demo007_Tree;

import java.util.Stack;

/**
 * @author TuanFans
 * @time 2026年3月5日 14:00:55
 * <p></p>
 */
public class Demo_007_01_TreeRecusion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode<Integer> node7 = new TreeNode<>(7,null,null);
		TreeNode<Integer> node6 = new TreeNode<>(6,null,null);
		TreeNode<Integer> node5 = new TreeNode<>(5,null,null);
		TreeNode<Integer> node4 = new TreeNode<>(4,null,null);
		
		TreeNode<Integer> node3 = new TreeNode<>(3,node6,node7);
		TreeNode<Integer> node2 = new TreeNode<>(2,node4,node5);
		
		TreeNode<Integer> node1 = new TreeNode<>(1,node2,node3);
		
		System.out.print("先序遍历：");
		prevOrder(node1);

		System.out.print("中序遍历：");
		inOrder(node1);

		System.out.print("后序遍历1：");
		posOrderByTwoStack(node1);

		System.out.print("后序遍历2：");
		posOrderByOneStack(node1);
	}
	
	/**
	 * 二叉树的先序非递归遍历
	 * @param head 二叉树的根节点
	 */
	public static void prevOrder(TreeNode<Integer> head) {
		if(head == null) return;
		Stack<TreeNode<Integer>> stack = new Stack<>();
		stack.push(head);
		while(!stack.isEmpty()) {
			TreeNode<Integer> current = stack.pop();
			System.out.print(current.value + " ");
			if(current.right != null) stack.push(current.right);
			if(current.left != null) stack.push(current.left);
		}
		System.out.println();
	}
	
	/**
	 * 二叉树的中序非递归遍历
	 * @param head 二叉树的根节点
	 */
	public static void inOrder(TreeNode<Integer> head) {
		if(head == null) return;
		Stack<TreeNode<Integer>> stack = new Stack<>();
		stack.push(head);
		while(!stack.isEmpty()) {
			if(head.left != null) {
				head = head.left;
				stack.push(head);
			}else {
				TreeNode<Integer> current = stack.pop();
				System.out.print(current.value + " ");
				if(current.right != null) {
					head = current.right;
					stack.push(head);
				}
			}
		}
		System.out.println();
	}
	
	/**
	 * 二叉树的后序非递归遍历（使用2个栈）
	 * @param head 二叉树的根节点
	 */
	public static void posOrderByTwoStack(TreeNode<Integer> head) {
		if(head == null) return;
		Stack<TreeNode<Integer>> temp = new Stack<>();
		Stack<TreeNode<Integer>> stack = new Stack<>();
		temp.push(head);
		while(!temp.isEmpty()) {
			TreeNode<Integer> current = temp.pop();
			stack.push(current);
			if(current.left != null) temp.push(current.left);
			if(current.right != null) temp.push(current.right);
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop().value+" ");
		}
		System.out.println();
	}
	
	/**
	 * 二叉树的后序非递归遍历（使用1个栈）
	 * @param head 二叉树的根节点
	 */
	public static void posOrderByOneStack(TreeNode<Integer> head) {
		if(head == null) return;
		Stack<TreeNode<Integer>> stack = new Stack<>();
		stack.push(head);
		// 如果一直没有打印节点，则head已知指向根节点
		// 当打印节点之后，head指向当前打印的节点
		// 在后续的操作中，head表示上次打印的节点
		while(!stack.isEmpty()) {
			TreeNode<Integer> current = stack.peek();
			// 如果当前节点有左节点，并且左节点与有节点都没有被打印过，说明当前节点没有进栈处理过，可以将当前节点进栈
			if(current.left != null && current.left != head && current.right != head) {
				stack.push(current.left);
			}else if(current.right != null && current.right != head) {
				stack.push(current.right);
			}else {
				// 如果当前节点没有左节点和右节点或者左右节点都已经处理过，则处理当前节点，并记录head为当前节点
				System.out.print(current.value + " ");
				head = stack.pop();
			}
		}
		System.out.println();
	}
}
