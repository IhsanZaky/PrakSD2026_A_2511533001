package pekan4_2511533001;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseData_2511533001 {

	public static void main(String[] args) {
		Queue<Integer> q_3001 = new LinkedList<Integer>();
		q_3001.add(1);
		q_3001.add(2);
		q_3001.add(3);
		System.out.println("Sebelum reverse" + q_3001);
		Stack<Integer> s_3001 = new Stack<Integer>();
		while (!q_3001.isEmpty()) { // Q -> S
			s_3001.push(q_3001.remove());
		}
		while (!s_3001.isEmpty()) { // S -> Q
			q_3001.add(s_3001.pop());
	}
		System.out.println("Sesudah reverse= " + q_3001); // [3, 2, 1]
}
}
