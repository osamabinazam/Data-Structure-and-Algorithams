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

    //Search for specific value in the tree using level order traversal
    public void search(Node rootNode ,String value){
        if (rootNode == null)
            return;
        Queue<Node> treeNodes = new LinkedList<>();
        treeNodes.add(rootNode);
        while(!treeNodes.isEmpty()){
            Node currentNode = treeNodes.remove();
            if (currentNode.data.equals(value)){
                System.out.println("Value "+ value+" found in tree");
                return;
            }
            else{
                if(currentNode.leftChild != null)
                    treeNodes.add(currentNode.leftChild);
                if(currentNode.rightChild != null)
                    treeNodes.add(currentNode.rightChild);
            }
        }

        System.out.println("Value is not found.");

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


    //Remova a specific node from the tree Using Level Order Traversal
    //Three Methods
    //Get the deepest Node
    public Node getDeepestMethod (Node rootNode){
        Queue<Node> treeNodes = new LinkedList<>();
        treeNodes.add(rootNode);
        Node currentNode = null;
        while(!treeNodes.isEmpty()){
            currentNode = treeNodes.remove();
            if (currentNode.leftChild != null)
                treeNodes.add(currentNode.leftChild);
            if (currentNode.rightChild !=null)
                treeNodes.add(currentNode.rightChild); 
        }
        return currentNode;
    }

    public Node  deleteLeaves(Node rootNode, String data) { 
    if (rootNode == null) 
        return null; 
    rootNode.leftChild = deleteLeaves(rootNode.leftChild, data); 
    rootNode.rightChild = deleteLeaves(rootNode.rightChild, data); 
  
    if (rootNode.data.equals(data) && rootNode.leftChild == null && rootNode.rightChild == null) { 
  
        return null; 
    } 
    return rootNode; 
} 

    //Delete Deepest Node
    public void deleteDeepest(Node rootNode){
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(rootNode);
        Node prevNode, currentNode=null;

        //Doing Level Order Traversal
        while(!nodes.isEmpty()){
            prevNode =currentNode;
            currentNode =  nodes.remove();
            if(currentNode.leftChild == null){
                prevNode.rightChild=null;
                return;
            }
            else if (currentNode.rightChild == null){
                prevNode.leftChild = null;
                return;
            }
            if(currentNode.leftChild != null)
                nodes.add(currentNode.leftChild);
                if(currentNode.rightChild != null)
                nodes.add(currentNode.rightChild);
 

        }
    }

    //Delete specified node from the tree
    public boolean deteleNode (Node rootNode , String data){

        if (rootNode == null)   return false;
        if (rootNode.leftChild == null && rootNode.rightChild==null)
            return rootNode.data.equals(data) ? true:false;
        

        boolean flag =false;
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(rootNode);
        while(!nodes.isEmpty()){
            Node currentNode = nodes.remove();
            if (currentNode.data.equals(data)){
                currentNode.data = getDeepestMethod(rootNode).data; //Duplicate deepest node value
                deleteLeaves(rootNode, currentNode.data);    //Deleting Deepest node to remove redundancy
                
                flag = true;
                return flag;
                
            }
            else{
                if (currentNode.leftChild != null)
                    nodes.add(currentNode.leftChild);
                if (currentNode.rightChild != null)
                    nodes.add(currentNode.rightChild);
            }
        }
        if (!flag)
            System.out.println("Given node does not exists in the tree");
        return flag;
    }

    //Delete entire binary tree
    public void deleteBinary(){
        this.root=null;
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
        // System.out.println("\nPre-Order Traversal : ");
        // binaryTree.preOrderTraversal(binaryTree.root);
        // System.out.println("\n\nIn Order Traversal : ");
        // binaryTree.inOrderTraversal(binaryTree.root);
        // System.out.println("\n\nPost Order Traversal : ");
        // binaryTree.postOrderTraversal(binaryTree.root);
        // System.out.println("\n\nLevel Order Traversal :");
        // binaryTree.levelOrderTraversal(binaryTree.root);
        // System.out.println("\n\nSearching for Tea : ");
        // binaryTree.search(binaryTree.root, "Tea");

        // System.out.println("\n\nFinding Deepest Node ");
        // System.out.println("The Deepest Node is : "+
        // binaryTree.getDeepestMethod(binaryTree.root).data);
        // System.out.println("\nDeleting a deepest Node : ");
        // binaryTree.deleteDeepest(binaryTree.root);
        // binaryTree.levelOrderTraversal(binaryTree.root);

        // System.out.println("\nDeleteing a Specific Node from the tree");
        // System.out.println("Deleted : "+binaryTree.deteleNode(binaryTree.root, "Cold"));
        // binaryTree.levelOrderTraversal(binaryTree.root);
        // System.out.println("\nAgain Deleted : " + binaryTree.deteleNode(binaryTree.root, "Tea"));

        // binaryTree.levelOrderTraversal(binaryTree.root);
        // binaryTree.deteleNode(binaryTree.root,"Hot");
        // binaryTree.levelOrderTraversal(binaryTree.root);
        
        System.out.println("\nDeepest Node 1 is : "+binaryTree.getDeepestMethod(binaryTree.root).data);
        System.out.println("\nLevel Order Traversal 1 : " ); binaryTree.levelOrderTraversal(binaryTree.root);
        System.out.println("\nDeleting Cold : " + binaryTree.deteleNode(binaryTree.root, "Cold"));
        System.out.println("Deepest Node 2 : " +  binaryTree.getDeepestMethod(binaryTree.root).data);
        System.out.println("\nLevel Order Traversal 2: "); binaryTree.levelOrderTraversal(binaryTree.root);
        System.out.println("\nDeleting Tea :" + binaryTree.deteleNode(binaryTree.root, "Tea"));
        System.out.println("Deepest Node 3 : " +  binaryTree.getDeepestMethod(binaryTree.root).data);
        System.out.println("\nLevel Order Traversal  3: "); binaryTree.levelOrderTraversal(binaryTree.root);
        System.out.println("\nDeleting Hot : " + binaryTree.deteleNode(binaryTree.root, "Hot"));
        System.out.println("Deepest Node 4 : " +  binaryTree.getDeepestMethod(binaryTree.root).data);
        System.out.println("\nLevel Order Traversal  4: "); binaryTree.levelOrderTraversal(binaryTree.root);
        
    }
    
}
