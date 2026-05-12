package pekan6_2511533001;

public class InsertDLL_2511533001 {
	// menambahkan node di awal DLL
	static NodeDLL_2511533001 insertBegin_2511533001(NodeDLL_2511533001 head_3001, int data_3001) {
		// buat node baru
		NodeDLL_2511533001 new_node_3001 = new NodeDLL_2511533001(data_3001);
		// jadikan pointer nextnya head
		new_node_3001.next_3001 = head_3001;
		// jadikan pointer prev head ke new_node
		if (head_3001 != null) {
			head_3001.prev_3001 = new_node_3001;
		}
		return new_node_3001;
	}
	// fungsi menambahkan node di akhir
public static NodeDLL_2511533001 insertEnd_2511533001(NodeDLL_2511533001 head_3001, int new_Data_3001) {
	// buat node baru
	NodeDLL_2511533001 newNode_3001 = new NodeDLL_2511533001(new_Data_3001);
	// jika dll null jadikan head
	if (head_3001 == null) {
		head_3001 = newNode_3001;
	}
	else {
		NodeDLL_2511533001 curr_3001 = head_3001;
		while (curr_3001.next_3001 != null) {
			curr_3001 = curr_3001.next_3001;
		}
		curr_3001.next_3001 = newNode_3001;
		newNode_3001.prev_3001 = curr_3001;
	}
	return head_3001;
 }
// fungsi menambahkan node dipoisisi tertentu
public static NodeDLL_2511533001 insertAtPosition_2511533001(NodeDLL_2511533001 head_3001, int pos_3001, int new_Data_3001) {
	// buat node baru
	NodeDLL_2511533001 new_node_3001 = new NodeDLL_2511533001(new_Data_3001);
	if (pos_3001 == 1) {
		new_node_3001.next_3001 = head_3001;
		if(head_3001 != null) {
			head_3001.prev_3001 = new_node_3001;}
	head_3001 = new_node_3001;
	return head_3001; }
NodeDLL_2511533001 curr_3001 = head_3001;
for (int i = 1; i< pos_3001 - 1 && curr_3001 != null; i++) {
	curr_3001 = curr_3001.next_3001;}
if( curr_3001 == null) {
	System.out.println("Posisi tidak ada");
	return head_3001; }
new_node_3001.prev_3001 = curr_3001;
new_node_3001.next_3001 = curr_3001.next_3001;
curr_3001.next_3001 = new_node_3001;
if (new_node_3001.next_3001 != null) {
	new_node_3001.next_3001.prev_3001 = new_node_3001; }
return head_3001;
}
public static void printList_2511533001(NodeDLL_2511533001 head_3001) {
	NodeDLL_2511533001 curr_3001 = head_3001;
	while (curr_3001 != null) {
	System.out.print(curr_3001.data_3001 + " <-> ");
	curr_3001 = curr_3001.next_3001;
	}
	System.out.println();
}
public static void main(String[] args) {
	// membuat dll 2 <-> 3 <-> 5
	NodeDLL_2511533001 head_3001 = new NodeDLL_2511533001(2);
	head_3001.next_3001 = new NodeDLL_2511533001(3);
	head_3001.next_3001.prev_3001 = head_3001;
	head_3001.next_3001.next_3001 = new NodeDLL_2511533001(5);
	// cetak DLL di awal
	System.out.print("DLL Awal: ");
	printList_2511533001(head_3001);
	// tambah 1 di awal
	head_3001 = insertBegin_2511533001(head_3001, 1);
	System.out.print (
			"simpul 1 ditambah di akhir: ");
	printList_2511533001(head_3001);
	// tambah 6 di akhir
	System.out.print (
			"simpul 6 ditambah di akhir: ");
	int data_3001 = 6;
	head_3001 = insertEnd_2511533001(head_3001, data_3001);
	printList_2511533001(head_3001);
	// menambahkan node 4 di posisi 4
	System.out.print("tambah node 4 di posisi 4: ");
	int data2_3001 = 4;
	int pos_3001 = 4;
	head_3001 = insertAtPosition_2511533001(head_3001, pos_3001, data2_3001);
	printList_2511533001(head_3001);
	}
}

