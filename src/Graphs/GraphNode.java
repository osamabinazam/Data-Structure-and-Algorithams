package Graphs;

import java.util.ArrayList;

//Class represent the vertex of the graph
public class GraphNode {
    public String name;     //Name of the vertex
    public int index;       //Index of the vertex

    //This is for GraphUsingAdjacencyList Class
    //Hold Other Graph Node That are link
    public ArrayList<GraphNode> neighbors = new ArrayList<>();

    GraphNode(String name, int index){
        this.name = name;
        this.index=index;
    }

}
