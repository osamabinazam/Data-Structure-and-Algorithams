package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;


public class BinaryTreeUsingLinkedList {
    Node root; //root node of the tree

    //Constructor
    BinaryTreeUsingLinkedList(){
        this.root=null;
    }

    //Check root node
    public boolean  isEmpty(){
        return root ==null;
    }

    //Insert Node to binary Tree   
    public boolean add(String data){

        Node newNode = new Node(data);
        if (isEmpty()){
            root=newNode;       //Making first node as a root node
            System.out.println("Inseted new node at root");
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node currentNode = queue.remove();
            if(currentNode.leftChild ==null){
                currentNode.leftChild = newNode;
                System.out.println("Insert Successfully at left");
                return true;
            }
            else if (currentNode.rightChild == null){
                currentNode.rightChild= newNode;
                System.out.println("Insert Successfully at right");
                return true;
            }
            else{
                queue.add(currentNode.leftChild);
                queue.add(currentNode.rightChild);
            }
        }
        return false;    
    }



    //Main Driver Method
    public static void main(String[] args) {
        BinaryTreeUsingLinkedList binaryTree = new BinaryTreeUsingLinkedList();
        binaryTree.add("Drinks");
        binaryTree.add("Hot");
        binaryTree.add("Cold");
        binaryTree.add("Coffee");
        binaryTree.add("Tea");
        binaryTree.add("Wine");
        binaryTree.add("Bear");
    }
    
}
