package pekan3_2511533001;

public class stackArray_2511533001 {
	static final int MAX_3001 = 1000;
	int top_3001;
	int a_3001[] = new int [MAX_3001];
	boolean isEmpty_3001()
	{
			return (top_3001 < 0);
	}
	stackArray_2511533001()
	{
			top_3001 = -1;
	}
	boolean push_3001(int x)
	{
		if (top_3001 >= (MAX_3001 - 1)) {
			System.out.println("Stack Overflow");
			return false;
		}
		else {
			a_3001[++top_3001] = x;
			System.out.println(x + "dimasukkan dalam stack");
			return true;
		}
	}
	int pop_3001()
	{
		if (top_3001 < 0) {
			System.out.println("Stack Underflow");
			return 0;
		}
		else {
			int x = a_3001 [top_3001--];
			return x;
		}
	}
	int peek_3001()
	{
		if (top_3001 < 0) {
			System.out.println("Stack Underflow");
			return 0;
		}
		else {
			int x = a_3001 [top_3001];
			return x;
		}	
	}
	void print_3001() {
		for (int i = top_3001;i>-1;i--) {
			System.out.println(" "+ a_3001 [i]);
		}
	}
}
