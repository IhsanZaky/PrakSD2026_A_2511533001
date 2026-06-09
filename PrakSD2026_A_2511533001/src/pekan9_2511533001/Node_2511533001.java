package pekan9_2511533001;

public class Node_2511533001 {
	int data_3001;
	Node_2511533001 left_3001;
	Node_2511533001 right_3001;
	
	public Node_2511533001(int data_3001) {
		this.data_3001 = data_3001;
		left_3001 = null;
		right_3001 = null;
	}
	
	public void setLeft_3001(Node_2511533001 node_3001) {
		if (left_3001 == null)
			left_3001 = node_3001;
	}
	
	public void setRight_3001(Node_2511533001 node_3001) {
		if (right_3001 == null)
			right_3001 = node_3001;
	}
	
	public Node_2511533001 getLeft_3001() {
		return left_3001;
	}
	
	public Node_2511533001 getRight_3001() {
		return right_3001;
	}
	
	public int getData_3001() {
		return data_3001;
	}
	
	public void setData_3001(int data_3001) {
		this.data_3001 = data_3001;
	}
	
	void printPreorder_3001(Node_2511533001 node_3001) {
		if (node_3001 == null)
			return;
		System.out.print(node_3001.data_3001 + " ");
		printPreorder_3001(node_3001.left_3001);
		printPreorder_3001(node_3001.right_3001);
	}
	
	void printPostorder_3001(Node_2511533001 node_3001) {
		if (node_3001 == null)
			return;
		printPostorder_3001(node_3001.left_3001);
		printPostorder_3001(node_3001.right_3001);
		System.out.print(node_3001.data_3001 + " ");
	}
	
	void printInorder_3001(Node_2511533001 node_3001) {
		if (node_3001 == null)
			return;
		printInorder_3001(node_3001.left_3001);
		System.out.print(node_3001.data_3001 + " ");
		printInorder_3001(node_3001.right_3001);
	}
	
	public String print_3001() {
		return this.print_3001("", true, "");
	}
	
	public String print_3001(String prefix_3001, boolean isTail_3001, String sb_3001) {
		if (right_3001 != null) {
			right_3001.print_3001(prefix_3001 + (isTail_3001 ? "|  " : "   "), false, sb_3001);
		}
		System.out.println(prefix_3001 + (isTail_3001 ? "\\--" : "/--") + data_3001);
		if (left_3001 != null) {
			left_3001.print_3001(prefix_3001 + (isTail_3001 ? "   " : "|  "), true, sb_3001);
		}
		return sb_3001;
	}
}