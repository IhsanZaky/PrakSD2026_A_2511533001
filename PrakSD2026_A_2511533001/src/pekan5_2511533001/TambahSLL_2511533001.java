package pekan5_2511533001;

class NodeSLL_2511533001{
    int data_3001;
    NodeSLL_2511533001 next_3001;

    NodeSLL_2511533001(int data_3001) {
        this.data_3001 = data_3001;
        this.next_3001 = null;
    }
}

public class TambahSLL_2511533001 {

    // tambah di depan
    public static NodeSLL_2511533001 insertAtFront_3001(NodeSLL_2511533001 head_3001, int value_3001) {
        NodeSLL_2511533001 new_node_3001 = new NodeSLL_2511533001(value_3001);
        new_node_3001.next_3001 = head_3001;
        return new_node_3001;
    }

    // tambah di belakang
    public static NodeSLL_2511533001 insertAtEnd_3001(NodeSLL_2511533001 head_3001, int value_3001) {
        NodeSLL_2511533001 newNode_3001 = new NodeSLL_2511533001(value_3001);

        if (head_3001 == null) 
        	return newNode_3001;

        NodeSLL_2511533001 temp_3001 = head_3001;
        while (temp_3001.next_3001 != null) {
            temp_3001 = temp_3001.next_3001;
        }

        temp_3001.next_3001 = newNode_3001;
        return head_3001;
    }

    // tambah di posisi (FIX sesuai modul)
    static NodeSLL_2511533001 insertPos_3001(NodeSLL_2511533001 head_3001, int position_3001, int value_3001) {

        if (position_3001 < 1) {
            System.out.println("Invalid position");
            return head_3001;
        }

        // jika di depan
        if (position_3001 == 1) {
            NodeSLL_2511533001 new_node_3001 = new NodeSLL_2511533001(value_3001);
            new_node_3001.next_3001 = head_3001;
            return new_node_3001;
        }

        NodeSLL_2511533001 temp_3001 = head_3001;

        // maju ke node sebelum posisi
        for (int i = 1; i < position_3001 - 1; i++) {
            if (temp_3001 == null) {
                System.out.println("Posisi di luar jangkauan");
                return head_3001;
            }
            temp_3001 = temp_3001.next_3001;
        }

        NodeSLL_2511533001 newNode_3001 = new NodeSLL_2511533001(value_3001);

        // bagian inti (yang sebelumnya salah di kode kamu)
        newNode_3001.next_3001 = temp_3001.next_3001;
        temp_3001.next_3001 = newNode_3001;

        return head_3001;
    }

    // print list
    public static void printList_3001(NodeSLL_2511533001 head_3001) {
        NodeSLL_2511533001 curr_3001 = head_3001;

        while (curr_3001 != null) {
            System.out.print(curr_3001.data_3001);
            if (curr_3001.next_3001 != null) {
                System.out.print("-->");
            }
            curr_3001 = curr_3001.next_3001;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // list awal: 2->3->5->6
        NodeSLL_2511533001 head_3001 = new NodeSLL_2511533001(2);
        head_3001.next_3001 = new NodeSLL_2511533001(3);
        head_3001.next_3001.next_3001 = new NodeSLL_2511533001(5);
        head_3001.next_3001.next_3001.next_3001 = new NodeSLL_2511533001(6);

        System.out.print("Senarai berantai awal: ");
        printList_3001(head_3001);

        // tambah depan
        System.out.print("tambah 1 simpul di depan: ");
        head_3001 = insertAtFront_3001(head_3001, 1);
        printList_3001(head_3001);

        // tambah belakang
        System.out.print("tambah 1 simpul di belakang: ");
        head_3001 = insertAtEnd_3001(head_3001, 7);
        printList_3001(head_3001);

        // tambah posisi (4 di posisi ke-4)
        System.out.print("tambah 1 simpul ke data 4: ");
        head_3001 = insertPos_3001(head_3001, 4, 4);
        printList_3001(head_3001);
    }
}