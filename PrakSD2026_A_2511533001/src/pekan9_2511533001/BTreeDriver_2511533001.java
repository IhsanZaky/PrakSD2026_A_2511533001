package pekan9_2511533001;

public class BTreeDriver_2511533001 {
    public static void main(String[] args){
        //Membuat Pohon
        BTree_2511533001 tree_3001 = new BTree_2511533001();
        System.out.printf("Jumlah Simpul awal pohon: ");
        System.out.println(tree_3001.countNodes_3001());
        
        //menambahkan simpul data 1
        Node_2511533001 root_3001 = new Node_2511533001(1);
        tree_3001.setRoot_3001(root_3001);
        
        //menjadikan simpul 1 sebagai root
        System.out.println("Jumlah simpul jika hanya ada root");
        System.out.println(tree_3001.countNodes_3001());
        
        Node_2511533001 node2_3001 = new Node_2511533001(2);
        Node_2511533001 node3_3001 = new Node_2511533001(3);
        Node_2511533001 node4_3001 = new Node_2511533001(4);
        Node_2511533001 node5_3001 = new Node_2511533001(5);
        Node_2511533001 node6_3001 = new Node_2511533001(6);
        Node_2511533001 node7_3001 = new Node_2511533001(7);
        Node_2511533001 node8_3001 = new Node_2511533001(8);
        Node_2511533001 node9_3001 = new Node_2511533001(9);
        
        root_3001.setLeft_3001(node2_3001);
        node2_3001.setLeft_3001(node4_3001);
        node2_3001.setRight_3001(node5_3001);
        node4_3001.setRight_3001(node8_3001);
        root_3001.setRight_3001(node3_3001);
        node3_3001.setLeft_3001(node6_3001);
        node3_3001.setRight_3001(node7_3001);
        node6_3001.setLeft_3001(node9_3001);
        
        //Set root
        tree_3001.setCurrent_3001(tree_3001.getRoot_3001());
        System.out.println("Menampilkan simpul terakhir: ");
        System.out.println(tree_3001.getCurrentNode_3001().getData_3001());
        
        System.out.println("Jumlah simpul; setelah simpul 7 ditambahkan");
        System.out.println(tree_3001.countNodes_3001());
        
        System.out.println("InOrder: ");
        tree_3001.printInorder_3001();
        
        System.out.println("\nPreorder: ");
        tree_3001.printPreOrder_3001();
        
        System.out.println("\nPostorder:");
        tree_3001.printPostOrder_3001();
        
        System.out.println("\nMenampilkan simpul dalam bentuk pohon");
        tree_3001.print_3001();
    }
}