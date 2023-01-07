package Graphs.Traversing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GraphUsingAdjacencyMatrix {
    //Class Members
    ArrayList<GraphNode> list;          //Original List of Graph
    ArrayList<GraphNode> copiedList;    //Copied Orignal list in it so that I can work on it without destroying the original One
    int [][] adjacencyMatrix;


    //Constructor
    GraphUsingAdjacencyMatrix(ArrayList<GraphNode> list){
        this.list=list;
        adjacencyMatrix = new int[this.list.size()][this.list.size()];  //Adjacent Matrix
        copiedList = copyList(list);
    }


    //Method which adds the edges to the node
    // i->index of first node
    // j->index of second node
    public void addUndirectedGraph(int i , int j){
        adjacencyMatrix[i][j] = 1;          //link/edge between i and j
        adjacencyMatrix[j][i] = 1;          //link/edge between j and i
    }


     /********************************************************************/
    //Implementing Breadth First Search
    /*******************************************************************/

    //Helper Methods
    //1. Getting Neighbors
    public ArrayList<GraphNode> getNeighbors (GraphNode node){
        ArrayList<GraphNode> neighbors = new ArrayList<>();
        int nodeIndex = node.index;
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[nodeIndex][i] == 1){
                    neighbors.add(copiedList.get(i));
            }
        }
        return neighbors;    
    }



    //2. Internal Function of Actual Breadth First Search 
    private void visitedBFS (GraphNode node){
        //Create Queue Using LinkedList
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);                                          //Enqueue arbitrary node
        while (!queue.isEmpty()){                                 //While queue is not empty
            GraphNode currentNode = queue.remove(0);        //dequeue an element from the queue
            currentNode.isVisited = true;                         //Set current node to be visited otherwise loop will run infinitely
            System.out.print(currentNode.name + " ");            //Print the visited vertex
            ArrayList<GraphNode> neighbors = getNeighbors(currentNode); //Getting neighbors associated with current node
            for (GraphNode neighbor : neighbors) {
                if (!neighbor.isVisited){                               //Checking neighbor to be visited, visited vertex will not add in the queue
                        queue.add(neighbor);                            //Adding neighbor in the queue for traversal
                        neighbor.isVisited=true;                        //Setting visited property to true
                }
            }
        }
    } 



    //Original BFS Method that traverse the Graph
    public void BFS (){
        
        for (GraphNode node : copiedList){
            if (!node.isVisited)
                    visitedBFS(node);
        }
        copiedList = copyList(list);
    }


     /********************************************************************/
    //Implementing Breadth First Search
    /*******************************************************************/


    //Helper Method
    private void visitedDFS(GraphNode node){
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            GraphNode currentNode = stack.pop();
            currentNode.isVisited = true;
            System.out.print(currentNode.name+" ");
            ArrayList<GraphNode> neighbors = getNeighbors(currentNode);
            for (GraphNode neighbor : neighbors){
                if (!neighbor.isVisited){
                    stack.push(neighbor);
                    neighbor.isVisited=true;
                }
            }
        }

    }


    //Driver method of Depth First Search
    public void DFS (){
        // ArrayList<GraphNode> copiedList= copyList(list);
        for (GraphNode node :  copiedList){
            if (!node.isVisited)
                visitedDFS(node);
        }
    }



    //****************************************/
    //*             Extra Functions          */
    //****************************************/
    
    //Coping ArrayList to Another List
    public ArrayList<GraphNode> copyList (ArrayList <GraphNode> list){
        ArrayList<GraphNode> copiedList = new ArrayList<>();

        for (int i =0 ; i< list.size();  i++){
            String name = list.get(i).name;
            int index = list.get(i).index;
            GraphNode newNode = new GraphNode(name, index);
            copiedList.add(newNode);
        }
        return copiedList;
    }



    //Overriding toString method to print the graph
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("   ");
        for (int i = 0; i < list.size(); i++) {
            str.append(list.get(i).name+" ");
        }
        str.append("\n");
        for (int i = 0; i < list.size(); i++) {
            str.append(list.get(i).name+": ");
            for (int is : adjacencyMatrix[i]) {
                str.append(is + " ");
            }
            str.append("\n");
        }

        return str.toString();

    }

    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList= new ArrayList<>();
        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));
        
        GraphUsingAdjacencyMatrix graph = new GraphUsingAdjacencyMatrix(nodeList);
        graph.addUndirectedGraph(0, 1);             //link from A to B and B to A
        graph.addUndirectedGraph(0, 2);             //link from A to C and C to A
        graph.addUndirectedGraph(0, 3);             //lint from A to D and D to A
        graph.addUndirectedGraph(1, 4);             //link from B to E and E to B
        graph.addUndirectedGraph(2, 3);             //link from C to D and D to C 
        graph.addUndirectedGraph(3, 4);             //link from D to E and E to D
        
        //Printing the Graph
        System.out.println(graph.toString());
        //BFS Traversing
        System.out.println("Start Traversing");
        System.out.println("Breadth First Search");
        graph.BFS();
        System.out.println("\nDepth first Search");
        graph.DFS();

    }

}
