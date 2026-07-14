package demo007_Tree;
/**
 * @author TuanFans
 * @time 2026年3月5日 13:56:50
 * <p></p>
 */
public class TreeNode<T> {
	public T value;
	public TreeNode<T> left;
	public TreeNode<T> right;
	
	public TreeNode(T value,TreeNode<T> left,TreeNode<T> right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public TreeNode(T value){
		this.value = value;
		this.left = null;
		this.right = null;
	}
}
