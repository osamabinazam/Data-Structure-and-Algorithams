package Trees.BinarySearchTree;

import java.util.Currency;
import java.util.LinkedList;
import java.util.Queue;

import javax.xml.crypto.Data;

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

    //Searching in bst
    public boolean search (Node rootNode, int data){

        if(rootNode ==null){
            System.out.println("Tree is Empty");
            return false;
        }
        else if (rootNode.data == data){
            // System.out.println("Value found in bst");
            return true;
        }
        else if (data < rootNode.data)
            return search(rootNode.leftNode, data);
        else 
            return search(rootNode.rightNode, data);


    }

    //Deletion in BST 
    //Three Cases:
    //  1 -> Node to be deleted is a leaf node
    //  2 -> Node has one child
    //  3 -> Node has two children

    //Find the minumun Node
    public Node minmumNode(Node rootNode){
        return rootNode.leftNode==null ? rootNode : minmumNode(rootNode.leftNode);
    }
    
    //Find Successor in the right subtree

    //find and delete node from the BST
    public Node delete(Node rootNode, int data){
        if (rootNode == null)
            return null;
        else if (data < rootNode.data) 
            rootNode.leftNode = delete(rootNode.leftNode, data);
        else if (data > rootNode.data)
            rootNode.rightNode= delete(rootNode.rightNode, data);
        //Implementing logic of above 3 cases
        //case 3
        else {
            if (rootNode.leftNode !=null && rootNode.rightNode != null){
                //Finding Successor of rootNode
                Node tempNode = rootNode;
                Node succssorNode = minmumNode(tempNode.rightNode);
                rootNode.data = succssorNode.data;                  //Replace with successor node

                //Deleting minmum node from Right Subtree of rootNode
                rootNode.rightNode = delete(rootNode.rightNode, succssorNode.data);
            
            }

            //Case 2
            //For Left Child Only
            else if (rootNode.leftNode !=null){
                rootNode= rootNode.leftNode;
            }
            //for right Child only
            else if (rootNode.rightNode !=null)
                rootNode = rootNode.rightNode;
            
            //case 1
            else
                rootNode=null;

        }

        return rootNode;

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

        System.out.println("\nSearching in BST \n");
        System.out.println("Searching 25 : " + bt.search(bt.rootNode, 25));

        System.out.println("Deleting a node\n");
        System.out.println("Deleting 60  :"+bt.delete(bt.rootNode, 60).data);

        System.out.print("\nPost-Order  : ");
        bt.levelOrderTraversal(bt.rootNode);


    }


}

