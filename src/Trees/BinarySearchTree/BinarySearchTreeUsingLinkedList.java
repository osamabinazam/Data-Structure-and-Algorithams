package Trees.BinarySearchTree;

import java.util.Currency;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeUsingLinkedList {

    Node rootNode;
    BinarySearchTreeUsingLinkedList(){
        rootNode = null;
    }


    public boolean isEmpty(){
        return rootNode==null ? true:false;
    }

    //Insert a node into binary search Tree
    public boolean insert(int key){
        Node newNode = new Node (key);
        if(isEmpty())
            rootNode=newNode;
        else{
            Node currentNode = rootNode;
            while (true){
                if (key<currentNode.data){
                    if(currentNode.leftNode==null){
                        currentNode.leftNode= newNode;
                        System.out.println("Inserted at left of Node " + currentNode.data);
                        return true;
                }
                    else
                        currentNode =currentNode.leftNode;
                }
                if(key> currentNode.data){
                    if(currentNode.rightNode==null){
                        currentNode.rightNode=newNode;
                        System.out.println("Inserted at right of Node " + currentNode.data);
                        return true;
                    }
                    else
                        currentNode =currentNode.rightNode;
                }
            }
        }
        return false;

    }
    
    //Inseting a node into binary search tree using recursion
    public Node insert (Node rootNode,int key){

        if(rootNode== null){
            Node newNode = new Node(key);
            System.out.println("Successfully added ");
            return newNode;
        }
        else if (key <=rootNode.data)   {
            rootNode.leftNode = insert(rootNode.leftNode, key);
            return rootNode;
        }
        else {
            rootNode.rightNode = insert(rootNode.rightNode, key);
            return rootNode;
        }


    }

    //Traversal
    //Pre-Order Traversal
    public void preOrderTraversal(Node rootNode){
   
        
        //Base condition 
        //Stop recursion 
        if (rootNode == null)
                return;
        System.out.print(rootNode.data+" ");
        preOrderTraversal(rootNode.leftNode);
        preOrderTraversal(rootNode.rightNode);

    }
    //In-Order Traversal
    public void inOrderTraversal (Node rootNode){
        
        //Base  Condition
        if (rootNode==null)
                return;
        
        inOrderTraversal(rootNode.leftNode);
        System.out.print(rootNode.data+" ");
        inOrderTraversal(rootNode.rightNode);
        
    }

    //Post-Order Traversal
    public void postOrderTraversal(Node rootNode){

        //Base condition
        if (rootNode == null)
            return;
        postOrderTraversal(rootNode.leftNode);
        postOrderTraversal(rootNode.rightNode);
        System.out.print( rootNode.data+" ");

    }

    //Level Order Traversal
    public void levelOrderTraversal (Node rootNode){
        Queue<Node> treeNodes = new LinkedList<>();
        treeNodes.add(rootNode);
        while(!treeNodes.isEmpty()){
            Node currentNode = treeNodes.remove();
            System.out.print(currentNode.data+" ");
            if (currentNode.leftNode !=  null)
                treeNodes.add(currentNode.leftNode);
            if (currentNode.rightNode != null)
                treeNodes.add(currentNode.rightNode);
        }

    }

    
    public static void main(String[] args) {
        BinarySearchTreeUsingLinkedList bt = new BinarySearchTreeUsingLinkedList();
        bt.insert(50);
        bt.insert(30);
        bt.insert(20);
        bt.insert(60);
        bt.insert(70);
        bt.insert(25);
        bt.insert(35);
        bt.insert(55);
        bt.insert(65);
        
        System.out.println("Traversing\n");
        System.out.print("Pre-Order  : ");
        bt.preOrderTraversal(bt.rootNode);
        System.out.print("\nIn-Order  : ");
        bt.inOrderTraversal(bt.rootNode);
        System.out.print("\nPost-Order  : ");
        bt.postOrderTraversal(bt.rootNode);


    }


}

