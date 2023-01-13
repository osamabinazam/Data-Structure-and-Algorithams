package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;


public class BinaryTreeUsingLinkedList {
    Node root; //root node of the tree

    //Constructor
    BinaryTreeUsingLinkedList(){
        this.root=null;
    }

    //Pre-Order Traversal
    public void preOrderTraversal(Node rootNode){

        //Base condition 
        //Stop recursion 
        if (rootNode == null)
                return;
        System.out.print(rootNode.data+" ");
        preOrderTraversal(rootNode.leftChild);
        preOrderTraversal(rootNode.rightChild);

    }

    //In-Order Traversal
    public void inOrderTraversal (Node rootNode){
        
        //Base  Condition
        if (rootNode==null)
                return;
        
        inOrderTraversal(rootNode.leftChild);
        System.out.print(rootNode.data+"");
        inOrderTraversal(rootNode.rightChild);
        
    }

    //Post-Order Traversal
    public void postOrderTraversal(Node rootNode){

        //Base condition
        if (rootNode == null)
            return;
        postOrderTraversal(rootNode.leftChild);
        postOrderTraversal(rootNode.rightChild);
        System.out.print( rootNode.data+" ");

    }

    //Level Order Traversal
    public void levelOrderTraversal (Node rootNode){
        Queue<Node> treeNodes = new LinkedList<>();
        treeNodes.add(rootNode);
        while(!treeNodes.isEmpty()){
            Node currentNode = treeNodes.remove();
            System.out.print(currentNode.data+" ");
            if (currentNode.leftChild !=  null)
                treeNodes.add(currentNode.leftChild);
            if (currentNode.rightChild != null)
                treeNodes.add(currentNode.rightChild);
        }

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
        System.out.println("\nPre-Order Traversal : ");
        binaryTree.preOrderTraversal(binaryTree.root);
        System.out.println("\n\nIn Order Traversal : ");
        binaryTree.inOrderTraversal(binaryTree.root);
        System.out.println("\n\nPost Order Traversal : ");
        binaryTree.postOrderTraversal(binaryTree.root);
        System.out.println("\n\nLevel Order Traversal :");
        binaryTree.levelOrderTraversal(binaryTree.root);
    }
    
}
