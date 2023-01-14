package Trees.BinaryTree;

public class BinaryTreeUsingArray {
    String [] treeArray ;
    int top;
    BinaryTreeUsingArray(int size){
        this.top =0;
        this.treeArray = new String[size+1];            //Because we can not use Zeroth index
    } 

    //Check array 
    public boolean isFull(){
        return this.treeArray.length == this.top ? true:false;
    }

    //check for empty array
    public boolean isEmpty(){
        return top==0 ?true:false;
    }
    
    //Insert an element to array
    public void insert(String data){
        if (!isFull()){
            treeArray[++top] =  data;
            System.out.println("Sucessfully Added ");

        }
        else
            System.out.println("Tree is Full");
    }

    //Left child index
    private int leftChild (int index){
        return (2*index);
    }
    private int rightChild (int index){
        return ((2*index) +1);
    }

    //Traversal
    //Pre-Order Traversal
    public void preOrderTraversal (int rootIndex){
        if (rootIndex > top)
            return;
        System.out.print(treeArray[rootIndex]+" ");
        preOrderTraversal(leftChild(rootIndex));
        preOrderTraversal(rightChild(rootIndex));
        if(rootIndex==1)
            System.out.println("");
    }

    //In-Order Traversal
    public void inOrderTraversal(int rootIndex){
        if (rootIndex > top)
            return;
        inOrderTraversal(leftChild(rootIndex)); 
        System.out.print( treeArray[rootIndex]+" ");
        inOrderTraversal(rightChild(rootIndex));
        if(rootIndex==1)
            System.out.println("");
    }

    //Post-Order Traversal
    public void postOrderTraversal(int rootIndex){
        if (rootIndex > top)
            return;
        postOrderTraversal(leftChild(rootIndex));
        postOrderTraversal(rightChild(rootIndex));
        System.out.print(treeArray[rootIndex]+" ");
        if(rootIndex==1)
            System.out.println("");
    }

    //level order traversal
    public void levelOrderTraversal (){
        for(int i=1; i<=top; i++)
            System.out.print(treeArray[i]+ " " );

    }

    public int search(String key){
        for(int i=1; i<=top; i++){
            if (treeArray[i].equals(key)){
                System.out.println("Value exit at location "+ i);
                return i;
            }
        }
        System.out.println("Value does not exists");
        return -1;

    }

    //Delete specified node from the tree
    public boolean deleteNode(String key){
        if(isEmpty()){
            System.out.println("Tree is empty.");
            return false;
        }
        for(int i=1; i<=top; i++){
            if(treeArray[i].equals(key)){
                System.out.println("Value found at location " + i +" now replacing with deepest node");
                treeArray[i] = treeArray[top];
                top--;
                return true;
            }
        }
        System.out.println("Value does not exits in binary tree");
        return false;


    }
    
    //Driver Method or Main Method of the tree
    public static void main(String[] args) {
        BinaryTreeUsingArray tree = new BinaryTreeUsingArray(10);
        tree.insert("Drinks");
        tree.insert("Hot");
        tree.insert("Cold");
        tree.insert("Tea");
        tree.insert("Coffee");
        tree.insert("Bear");
        tree.insert("Wine");
        System.out.println("Pre Order Traversal: ");
        tree.preOrderTraversal(1);
        System.out.println("In Order Traversal: ");
        tree.inOrderTraversal(1);
        System.out.println("Post Order Traversal: ");
        tree.postOrderTraversal(1);
        System.out.println("Level Order Traversal: ");
        tree.levelOrderTraversal();
        System.out.println("Searching for Cold : ");
        tree.search("Cold");
        System.out.println("Deleting Cold : " + tree.deleteNode("Cold"));
        tree.levelOrderTraversal();


    }
    
}
