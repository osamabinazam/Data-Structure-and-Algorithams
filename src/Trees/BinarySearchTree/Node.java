package Trees.BinarySearchTree;

public class Node {
    public int data;

    //References to left and right children
    public Node leftNode;
    public Node rightNode;

    Node(int data){
        this.data=data;
        this.leftNode=null;
        this.rightNode=null;
    }
}
