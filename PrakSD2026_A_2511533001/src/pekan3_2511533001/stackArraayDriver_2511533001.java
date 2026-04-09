package pekan3_2511533001;

public class stackArraayDriver_2511533001 {

	public static void main(String[] args) {
		stackArray_2511533001 s = new stackArray_2511533001();
		s.push_3001(10);
		s.push_3001(20);
		s.push_3001(30);
		System.out.println(s.pop_3001() + " dikeluarkan dari srack");
		System.out.println("Elemen teratas adalah :" + s.peek_3001());
		System.out.println("Elemen pada stack :");
		s.print_3001();
	}
}
