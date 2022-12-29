package Graphs;

import java.util.ArrayList;

public class GraphDemo {
    //Class Members
    ArrayList<GraphNode> list = new ArrayList<GraphNode>();
    int [][] adjacencyMatrix;

    //Constructor
    GraphDemo(ArrayList<GraphNode> list){
        this.list=list;
        adjacencyMatrix = new int[this.list.size()][this.list.size()];  //Adjacent Matrix
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
            if (adjacencyMatrix[nodeIndex][i] == 1)
                    neighbors.add(list.get(nodeIndex));
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
    } //end of the method

    //Original BFS Method that traverse the Graph
    public void BFS (){
        for (GraphNode node : list){
            if (!node.isVisited)
                    visitedBFS(node);
        }
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
        
        GraphDemo graph = new GraphDemo(nodeList);
        graph.addUndirectedGraph(0, 1);             //link from A to B and B to A
        graph.addUndirectedGraph(0, 2);             //link from A to C and C to A
        graph.addUndirectedGraph(0, 3);             //lint from A to D and D to A
        graph.addUndirectedGraph(1, 4);             //link from B to E and E to B
        graph.addUndirectedGraph(2, 3);             //link from C to D and D to C 
        graph.addUndirectedGraph(3, 4);             //link from D to E and E to D
        
        //Printing the Graph
        System.out.println(graph.toString());

    }

}
