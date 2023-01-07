package Graphs.TopologicalSort;

import java.util.ArrayList;

//Class represent the vertex of the graph
public class GraphNode {
    public String name;     //Name of the vertex
    public int index;       //Index of the vertex

    //This is for GraphUsingAdjacencyList Class
    //Hold Other Graph Node That are link
    public ArrayList<GraphNode> neighbors = new ArrayList<>();

    //Property Used to Keep Track of Search
    public boolean isVisited;

    GraphNode(String name, int index){
        this.name = name;
        this.index=index;
        this.isVisited=false;
    }

}
