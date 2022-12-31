package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortUsingAdjacenctMatrix {

    //Class members
    ArrayList<GraphNode> nodes;
    int [][] adjacencyMatrix; 

    //Constructor
    TopologicalSortUsingAdjacenctMatrix(ArrayList<GraphNode> nodes){
        this.nodes=nodes;
        adjacencyMatrix = new int[nodes.size()][nodes.size()];
    }

    //Add Direct Edge between Vertices 
    public void addDirectedEdge(int i, int j ){
        //edge from ith vertex to jth vertex
        adjacencyMatrix[i][j] = 1;
    }

    //Get neighbors

    public ArrayList<GraphNode> getNeighbors(GraphNode node){
        ArrayList<GraphNode> neighbors = new ArrayList<>();
        int i = node.index;
        for(int j=0; j<adjacencyMatrix.length; j++){
            if(adjacencyMatrix[i][j] == 1){
                neighbors.add(nodes.get(j));
            }
        }

        return neighbors;

    }


    /*****************************************/
    /*      Implementing Topological Sort    */
    /*****************************************/

    //Helper method
    private void topologicalVisit(GraphNode node, Stack<GraphNode> stack){
        ArrayList<GraphNode> neighbors = getNeighbors(node);
        for (GraphNode graphNode : neighbors) {
            if(!graphNode.isVisited){
                topologicalVisit(graphNode, stack);     //Recursively Calling topologicalVisit with graphNode
            }
        }
        node.isVisited = true;
        stack.push(node);
    }

    //Driver Method
    public void topologicalSort(){
        Stack <GraphNode> stack = new Stack<>();
        for (GraphNode node : nodes) {
            if(!node.isVisited){
                topologicalVisit(node, stack);
            }
        }
        while(!stack.isEmpty())
            System.out.print(stack.pop().name +" ");
        System.out.println("");

    }



    //Overriding toString method to print the graph
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("   ");
        for (int i = 0; i < nodes.size(); i++) {
            str.append(nodes.get(i).name+" ");
        }
        str.append("\n");
        for (int i = 0; i < nodes.size(); i++) {
            str.append(nodes.get(i).name+": ");
            for (int is : adjacencyMatrix[i]) {
                str.append(is + " ");
            }
            str.append("\n");
        }

        return str.toString();

    }

    public static void main(String[] args) {
        ArrayList<GraphNode> nodes = new ArrayList<>();
        nodes.add(new GraphNode("A", 0));
        nodes.add(new GraphNode("B", 1));
        nodes.add(new GraphNode("C", 2));
        nodes.add(new GraphNode("D", 3));
        nodes.add(new GraphNode("E", 4));
        nodes.add(new GraphNode("F", 5));
        nodes.add(new GraphNode("G", 6));
        nodes.add(new GraphNode("H", 7));
        TopologicalSortUsingAdjacenctMatrix graphSort = new TopologicalSortUsingAdjacenctMatrix(nodes);
         
        //Building Graph usind vertices and edgers
        graphSort.addDirectedEdge(0, 2);
        graphSort.addDirectedEdge(2, 4);
        graphSort.addDirectedEdge(4, 7);
        graphSort.addDirectedEdge(4, 5); 
        graphSort.addDirectedEdge(5, 6);
        graphSort.addDirectedEdge(1, 2);
        graphSort.addDirectedEdge(1, 3);
        graphSort.addDirectedEdge(3, 5);

       //Printing the Graph
       System.out.println(graphSort.toString());

       //Calling TopologicalSort
       graphSort.topologicalSort();
    }

    
}
