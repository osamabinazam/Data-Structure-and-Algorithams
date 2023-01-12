package Trees.BinaryTree;

public class Node {
    String data;        // Hold Actual Data
    Node leftChild;     // Reference to left child of the node
    Node rightChild;    //Reference to the right child of the node


    //Constuctor to initialize class members
    public Node (String data){
        this.data=data;
        this.leftChild=null;
        rightChild=null;
    }
    
}
