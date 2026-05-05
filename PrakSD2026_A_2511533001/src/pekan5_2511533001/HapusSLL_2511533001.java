package pekan5_2511533001;

public class HapusSLL_2511533001 {
	public static NodeSLL_2511533001 deleteHead_3001(NodeSLL_2511533001 head_3001) {
		if (head_3001 == null)
			return null;
		head_3001 = head_3001.next_3001;
		return head_3001;
	}
	
	public static NodeSLL_2511533001 removeLastNode_3001 (NodeSLL_2511533001 head_3001) {
		if (head_3001 == null) {
			return null;
		}
		if (head_3001.next_3001 == null) {
			return null;
		}
		NodeSLL_2511533001 secondLast_3001 = head_3001;
		while (secondLast_3001.next_3001.next_3001 != null) {
			secondLast_3001 = secondLast_3001.next_3001;
		}
		secondLast_3001.next_3001 = null;
		return head_3001;
	}
	
	public static NodeSLL_2511533001 deleteNode_3001 (NodeSLL_2511533001 head_3001, int position_3001) {
		NodeSLL_2511533001 temp_3001 = head_3001;
		NodeSLL_2511533001 prev_3001 = null;
		if (temp_3001 == null)
			return head_3001;
		if (position_3001 == 1) {
			head_3001 = temp_3001.next_3001;
			return head_3001;
		}
		 for (int i = 1; temp_3001 != null && i< position_3001; i++) {
			 prev_3001 = temp_3001;
			 temp_3001 = temp_3001.next_3001;
		 }
		 if (temp_3001 != null) {
			 prev_3001.next_3001 = temp_3001.next_3001;
		 }else {
			 System.out.println("Data tidak ada");
			 return head_3001;
		 }
		 return prev_3001;
	}	 
		 public static void printList_3001 (NodeSLL_2511533001 head_3001) {
			 NodeSLL_2511533001 curr_3001 = head_3001;
			 while (curr_3001.next_3001 != null) {
				 System.out.print(curr_3001.data_3001+"-->");
				 curr_3001 = curr_3001.next_3001;
			 }
			 if (curr_3001.next_3001 == null) {
				 System.out.print(curr_3001.data_3001);
				 System.out.println();
			 }
		 
	}

	public static void main(String[] args) {
		NodeSLL_2511533001 head_3001 = new NodeSLL_2511533001(1);
		head_3001.next_3001 = new NodeSLL_2511533001(2);
		head_3001.next_3001.next_3001 = new NodeSLL_2511533001(3);
		head_3001.next_3001.next_3001.next_3001 = new NodeSLL_2511533001(4);
		head_3001.next_3001.next_3001.next_3001.next_3001 = new NodeSLL_2511533001(5);
		head_3001.next_3001.next_3001.next_3001.next_3001.next_3001 = new NodeSLL_2511533001(6);
		System.out.println("list awal: ");
		printList_3001(head_3001);
		head_3001 = deleteHead_3001(head_3001);
		System.out.println("List setelah head dihapus: ");
		printList_3001(head_3001);
		head_3001 = removeLastNode_3001(head_3001);
		System.out.println("List setelah simpul terakhir dihapus: ");
		printList_3001(head_3001);
		int position_3001 = 2;
		head_3001 = deleteNode_3001(head_3001, position_3001);
		System.out.println("List setelah posisi 2 dihapus: ");
		printList_3001(head_3001);

	}

}
