package Graphs.TopologicalSort;

import java.util.ArrayList;
import java.util.Stack;

import Graphs.GraphNode;

public class TopologicalSortUsingAdjacencyList {

    
    ArrayList<GraphNode> nodes ;   

    //Constructor
    TopologicalSortUsingAdjacencyList(ArrayList<GraphNode> nodes){
        this.nodes = nodes;
    }
    //Constructor
    TopologicalSortUsingAdjacencyList(){
        this.nodes=null;
    }

    //Add Direct edge Between Vertices
    public void addDirectedEdge(int i , int j ){
        GraphNode first = nodes.get(i);
        GraphNode second = nodes.get(j);

        //Adding Direct edge from ith to j
        first.neighbors.add(second);
    }

    //helper method for topological sort
    private void topologicalVisit(GraphNode node , Stack<GraphNode> stack){
        //first check the neighbours of given node
        //If not visited then call topologicalvisit method recursively
        for (GraphNode neighbor : node.neighbors) {
            if(!neighbor.isVisited){
                topologicalVisit(neighbor, stack);
            }
        }

        node.isVisited=true;
        stack.push(node);
    }
    void topologicalSort(){
        Stack<GraphNode> stack = new Stack<>();
        for(GraphNode node : nodes){
            if(!node.isVisited){
                topologicalVisit(node, stack);
            }
        }

        //Printing our stack
        while(!stack.isEmpty()){
            System.out.print(stack.pop().name +" ");
        }
        System.out.println("");

    }

        //Overriding toString method to print graph
        public String toString(){
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < nodes.size(); i++) {
                str.append(nodes.get(i).name +": ");
                for (int j = 0; j < nodes.get(i).neighbors.size(); j++) {
                    if (j == nodes.get(i).neighbors.size() -1 ){
                        str.append(nodes.get(i).neighbors.get(j).name);
                    }
                    else{
                        str.append(nodes.get(i).neighbors.get(j).name + "->");
                    }
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
         TopologicalSortUsingAdjacencyList graphSort = new TopologicalSortUsingAdjacencyList(nodes);
          
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
