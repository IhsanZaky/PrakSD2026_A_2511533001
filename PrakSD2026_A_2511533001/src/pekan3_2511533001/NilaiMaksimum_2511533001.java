package pekan3_2511533001;

import java.util.Stack;

public class NilaiMaksimum_2511533001 {
	public static int max_3001(Stack<Integer> s_3001) {
		Stack<Integer> backup_3001 = new Stack<Integer>();
		int maxValue_3001 = s_3001.pop();
		backup_3001.push(maxValue_3001);
		while (!s_3001.isEmpty()) {
			int next_3001 = s_3001.pop();
			backup_3001.push(next_3001);
			maxValue_3001 = Math.max(maxValue_3001, next_3001);
		}
		while (!backup_3001.isEmpty()) {
			s_3001.push(backup_3001.pop());
		}
		return maxValue_3001;
			
	}
	public static void main(String[] args) {
		Stack<Integer> s_3001 = new Stack<Integer>();
		s_3001.push(70);
		s_3001.push(12);
		s_3001.push(20);
		System.out.println("isi stack "+s_3001);
		System.out.println("Stack Teratas "+s_3001.peek());
		System.out.println("NIlai maksimum "+max_3001(s_3001));
	}

}
