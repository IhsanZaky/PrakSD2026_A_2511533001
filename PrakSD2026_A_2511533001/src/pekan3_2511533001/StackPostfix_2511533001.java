package pekan3_2511533001;
import java.util.Scanner;
import java.util.Stack;
public class StackPostfix_2511533001 {
	public static int postfixEvaluate(String expression) {
		Stack<Integer> s_3001 = new Stack<Integer>();
		Scanner input = new Scanner(expression);
		while (input.hasNext()) {
			if (input.hasNextInt()) {	// an operand (integer)
				s_3001.push (input.nextInt());
			} else {
				String operator = input.next();
				int operand2_3001 = s_3001.pop();
				int operand1_3001 = s_3001.pop();
				if (operator.equals("+")) {
					s_3001.push (operand1_3001 + operand2_3001);
				}else if (operator.equals("-")) {
					s_3001.push (operand1_3001 - operand2_3001);
				}else if (operator.equals("*")) {
					s_3001.push (operand1_3001 * operand2_3001);
				}else {
					s_3001.push (operand1_3001 / operand2_3001);
				}
			}
		}
		input.close();
		return s_3001.pop();
	}
	public static void main (String[] args) {
		System.out.println("hasil postfix= "+postfixEvaluate ("5 2 4 * + 7 -"));
	}
}
