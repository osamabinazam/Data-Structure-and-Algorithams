package Graphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class GraphUsingAdjacencyList {

    //Class Members
    ArrayList<GraphNode> orgList = new ArrayList<>();
    ArrayList<GraphNode> list = (ArrayList<GraphNode>) orgList.clone();
    
    

    //Constructor
     GraphUsingAdjacencyList(ArrayList<GraphNode> list){
        this.orgList=list;
     }
    
    //Method that build Undirected Graph
    public void addUndirectedGraph(int i , int j){
        GraphNode first = orgList.get(i);
        GraphNode second = orgList.get(j);
        first.neighbors.add(second);
        second.neighbors.add(first); 
    } 
    /*************************************************/
    /*              Implementing BFS Traversal       */
    /*************************************************/

    //Helper Method for BFS Original

    //BFS Internal Method
    private void visitedBFS (GraphNode node){
         LinkedList<GraphNode> queue = new LinkedList<>();
         queue.add(node);
         while(!queue.isEmpty()){
            GraphNode currentNode = queue.remove(0);
            currentNode.isVisited=true;
            System.out.print(currentNode.name + " ");
            for (GraphNode neighbor : currentNode.neighbors) {
                if(!neighbor.isVisited){
                    queue.add(neighbor);
                    neighbor.isVisited=true;
                }
            }
         }
    }

    //Original method of Breadth First Search
    public void BFS (){
        for (GraphNode graphNode : list) {
            if(!graphNode.isVisited)
                    visitedBFS(graphNode);
        }
        
    }


    /*************************************************/
    /*              Implementing DFS Traversal       */
    /*************************************************/

    //Helper Method of Original DFS

    private void visitedDFS(GraphNode node){
        Stack <GraphNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            GraphNode currentNode = stack.pop();
            currentNode.isVisited=true;
            System.out.print(currentNode.name + " ");
            for (GraphNode graphNode : currentNode.neighbors) {
                if(!graphNode.isVisited)
                    stack.push(graphNode);
                    graphNode.isVisited=true;
            }
        }
    }

    //Driver Method of Depth First Search
    public void DFS(){
        for (GraphNode graphNode : list) {
                if(!graphNode.isVisited)
                        visitedDFS(graphNode);
        }      
        list=orgList;     
    }



    //Method to print Graph
    public String toString(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            str.append(orgList.get(i).name +": ");
            for (int j = 0; j < list.get(i).neighbors.size(); j++) {
                if (j == orgList.get(i).neighbors.size() -1 ){
                    str.append(orgList.get(i).neighbors.get(j).name);
                }
                else{
                    str.append(orgList.get(i).neighbors.get(j).name + "->");
                }
            }

            str.append("\n");
        }
        return str.toString();

    }

    public static void main(String[] args) {
        ArrayList <GraphNode> list = new ArrayList<>();
        list.add(new GraphNode("A", 0));
        list.add(new GraphNode("B", 1));
        list.add(new GraphNode("C", 2));
        list.add(new GraphNode("D", 3));
        list.add(new GraphNode("E", 4));

        //Object of GraphUsingAdjacencyList
        GraphUsingAdjacencyList graph = new GraphUsingAdjacencyList(list);

        graph.addUndirectedGraph(0, 1);
        graph.addUndirectedGraph(0, 2);
        graph.addUndirectedGraph(0, 3);
        graph.addUndirectedGraph(1, 4);
        graph.addUndirectedGraph(2, 3);
        graph.addUndirectedGraph(2, 4);

        //Printing Graph
        System.out.println(graph.toString());

        //BFS Traversal
        System.out.println("Start Traversing");
        System.out.println("Breadth First Search");
        graph.BFS();

        System.out.println("\nDepth First Search");
        graph.DFS();

    }
    
}
