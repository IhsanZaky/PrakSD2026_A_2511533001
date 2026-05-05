package pekan5_2511533001; 

public class PencarianSLL_2511533001 {
		static boolean searchKey_3001 (NodeSLL_2511533001 head_3001, int key_3001) {
			NodeSLL_2511533001 curr_3001 = head_3001;
			while (curr_3001 != null) {
				if (curr_3001.data_3001 == key_3001 )	
				return true;
				curr_3001 = curr_3001.next_3001; }
			return false; }
				public static void traversal_3001 (NodeSLL_2511533001 head_3001) {
					NodeSLL_2511533001 curr_3001 = head_3001;
					while (curr_3001 != null) {
						System.out.print(" " + curr_3001.data_3001);
						curr_3001 = curr_3001.next_3001;
					}
						System.out.println();
				}
		public static void main(String[] args) {
			NodeSLL_2511533001 head_3001 = new NodeSLL_2511533001(14);
			head_3001.next_3001 = new NodeSLL_2511533001(21);
			head_3001.next_3001.next_3001 = new NodeSLL_2511533001(13);
			head_3001.next_3001.next_3001.next_3001 = new NodeSLL_2511533001(30);
			head_3001.next_3001.next_3001.next_3001.next_3001 = new NodeSLL_2511533001(10);
			System.out.print("Penulusuran SSL: ");
			traversal_3001(head_3001);
			int key_3001 = 30;
			System.out.print("cari data " + key_3001 + " = ");
			if (searchKey_3001 (head_3001, key_3001))
				System.out.println("ketemu");
			else
				System.out.println("tidak ada");
			}}