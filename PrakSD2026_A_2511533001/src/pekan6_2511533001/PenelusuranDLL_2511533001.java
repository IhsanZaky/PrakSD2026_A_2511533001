package pekan6_2511533001;

public class PenelusuranDLL_2511533001 {
	// fungsi penelusuran maju
	static void forwardTraversal(NodeDLL_2511533001 head_3001) {
		// memmulai penelusuran dari head
		NodeDLL_2511533001 curr_3001 = head_3001;
		// lamjutkan sampai akhir
		while (curr_3001 != null) {
			// print data
			System.out.print(curr_3001.data_3001 + " <->");
			// pindah ke node berikutnya
			curr_3001 = curr_3001.next_3001;
		}
		// print spasi
		System.out.println(); }
		// fungsi penelusuran mundu
		static void backwardTraversal(NodeDLL_2511533001 tail_3001) {
		// mulai dari akhir
			NodeDLL_2511533001 curr_3001 = tail_3001;
			// lanjut sampai head
			while (curr_3001 != null) {
				// cetak data
			System.out.print(curr_3001.data_3001 + " <->");
			curr_3001 = curr_3001.prev_3001;
		}
		// cetak spasi
			System.out.println();
	}
		public static void main(String[] args) {
			// cerak DLL
			NodeDLL_2511533001 head_3001 = new NodeDLL_2511533001(1);
			NodeDLL_2511533001 second_3001 = new NodeDLL_2511533001(2);
			NodeDLL_2511533001 third_3001 = new NodeDLL_2511533001(3);
			
			head_3001.next_3001 = second_3001;
			second_3001.prev_3001 = head_3001;
			second_3001.next_3001 = third_3001;
			third_3001.prev_3001 = second_3001;
			
			System.out.println("Penelusuran maju:");
			forwardTraversal (head_3001);
			
			System.out.println("Penelusuran mundur:");
			backwardTraversal (third_3001);
		}
}
