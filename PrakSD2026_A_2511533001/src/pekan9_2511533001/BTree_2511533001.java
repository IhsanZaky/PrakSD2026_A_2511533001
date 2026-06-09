package pekan9_2511533001;

public class BTree_2511533001 {
    private Node_2511533001 root_3001;
    private Node_2511533001 currentNode_3001;

    public BTree_2511533001(){
        root_3001 = null;
    }

    public boolean search_3001(int data_3001){
        return search_3001(root_3001, data_3001);
    }

    private boolean search_3001(Node_2511533001 node_3001, int data_3001){
        if (node_3001 == null)
            return false;
        if (node_3001.getData_3001() == data_3001)
            return true;
        if (node_3001.getLeft_3001() != null)
            if (search_3001(node_3001.getLeft_3001(), data_3001))
                return true;
        if (node_3001.getRight_3001() != null)
            if (search_3001(node_3001.getRight_3001(), data_3001))
                return true;
        return false;
    }

    public void printInorder_3001(){
        if (root_3001 != null) root_3001.printInorder_3001(root_3001);
    }

    public void printPreOrder_3001(){
        if (root_3001 != null) root_3001.printPreorder_3001(root_3001);
    }

    public void printPostOrder_3001(){
        if (root_3001 != null) root_3001.printPostorder_3001(root_3001);
    }

    public Node_2511533001 getRoot_3001(){
        return root_3001;
    }

    public boolean isEmpty_3001(){
        return root_3001 == null;
    }

    public int countNodes_3001(){
        return countNodes_3001(root_3001);
    }

    public int countNodes_3001(Node_2511533001 node_3001){
        if (node_3001 == null){
            return 0;
        } else {
            int count_3001 = 1;
            count_3001 += countNodes_3001(node_3001.getLeft_3001());
            count_3001 += countNodes_3001(node_3001.getRight_3001());
            return count_3001;
        }
    }

    public void print_3001(){
        if (root_3001 != null) root_3001.print_3001();
    }

    public Node_2511533001 getCurrentNode_3001(){
        return currentNode_3001;
    }

    public void setCurrent_3001(Node_2511533001 currentNode_3001) {
        this.currentNode_3001 = currentNode_3001;
    }

    public void setRoot_3001(Node_2511533001 root_3001) {
        this.root_3001 = root_3001;
    }
}