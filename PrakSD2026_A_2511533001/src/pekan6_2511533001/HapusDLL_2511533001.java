package pekan6_2511533001;

public class HapusDLL_2511533001 {
	// fungsi mebghapus node awal
	public static NodeDLL_2511533001 delHead_2511533001(NodeDLL_2511533001 head_3001) {
		if (head_3001 == null) {
			return null;}
		NodeDLL_2511533001 temp_3001 = head_3001;
		head_3001 = head_3001.next_3001;
		if (head_3001 != null) {
			head_3001.prev_3001 = null; }
		return head_3001;
		}
		// fungsi menghapus di akhir
	public static NodeDLL_2511533001 delLast_2511533001(NodeDLL_2511533001 head_3001) {
	    if (head_3001 == null) return null;
	    
	    // Jika hanya ada 1 node
	    if (head_3001.next_3001 == null) {
	        return null;
	    }

	    NodeDLL_2511533001 curr_3001 = head_3001;
	    while (curr_3001.next_3001 != null) {
	        curr_3001 = curr_3001.next_3001;
	    }
	    
	    // Putus hubungan dengan node terakhir
	    if (curr_3001.prev_3001 != null) {
	        curr_3001.prev_3001.next_3001 = null;
	    }
	    return head_3001;
	}
	// fungsi menghapus node posisi tertentu
	public static NodeDLL_2511533001 delPos_2511533001(NodeDLL_2511533001 head_3001, int pos_3001) {
		// jika DLL kosong
		if (head_3001 == null) {
			return head_3001; }
		NodeDLL_2511533001 curr_3001 = head_3001;
		// telusuri sampai ke node yag akan diapus
		for (int i = 1; curr_3001 != null && i < pos_3001; ++i) {
			curr_3001 = curr_3001.next_3001;}
			//jika posisi tidak ditemukan
		if (curr_3001 == null) {
			return head_3001; }
		// update pointer
		if (curr_3001.prev_3001 != null) {
		   curr_3001.prev_3001.next_3001 = curr_3001.next_3001; }
		if (curr_3001.next_3001 != null) {
			   curr_3001.next_3001.prev_3001 = curr_3001.prev_3001; }
		// jika yang dihapus head
		if (head_3001 == curr_3001) {
			head_3001 = curr_3001.next_3001;}
		return head_3001;
		}
	// fungsi mencetak DLL
	public static void printList_2511533001(NodeDLL_2511533001 head_3001) {
		NodeDLL_2511533001 curr_3001 = head_3001;
		while (curr_3001 != null) {
			System.out.print(curr_3001.data_3001 + " <->");
			curr_3001 = curr_3001.next_3001;
		}
		System.out.println();
	}
		public static void main(String[] args) {
			// buat sebuah DLL
			NodeDLL_2511533001 head_3001 = new NodeDLL_2511533001(1);
			head_3001.next_3001 = new NodeDLL_2511533001(2);
			head_3001.next_3001.prev_3001 = head_3001;
			head_3001.next_3001.next_3001 = new NodeDLL_2511533001(3);
			head_3001.next_3001.next_3001.prev_3001 = head_3001.next_3001;
			head_3001.next_3001.next_3001.next_3001 = new NodeDLL_2511533001(4);
			head_3001.next_3001.next_3001.next_3001.prev_3001 = head_3001.next_3001.next_3001;
			head_3001.next_3001.next_3001.next_3001.next_3001 = new NodeDLL_2511533001(5);
			head_3001.next_3001.next_3001.next_3001.next_3001.prev_3001 = head_3001.next_3001.next_3001.next_3001;
			
			System.out.print("DLL Awal:");
			printList_2511533001(head_3001);
			
			System.out.print("Setelah head dihapus: ");
			head_3001 = delHead_2511533001(head_3001);
			printList_2511533001(head_3001);
			
			System.out.print("Setelah node terakhir dihapus: ");
			head_3001 = delLast_2511533001(head_3001);
			printList_2511533001(head_3001);
			
			System.out.print("menghapus node ke 2: ");
			head_3001 = delPos_2511533001(head_3001, 2);
			
			printList_2511533001(head_3001);
		}
	}
