package Graphs.BellmanFordAlgorithm;

import java.util.ArrayList;

/*
 * Bellman is used to find single shortest path paroblem.
 * If there is a negative cycle it catches it and reports its existence  * But it didn't find a shortest path in case of negative cycle
 * 
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<WeightedNode> graph = new ArrayList<WeightedNode>();
        graph.add(new WeightedNode("A",0));
        graph.add(new WeightedNode("B",1));
        graph.add(new WeightedNode("C",2));
        graph.add(new WeightedNode("D",3));
        graph.add(new WeightedNode("E",4));
        graph.add(new WeightedNode("F",5));
        graph.add(new WeightedNode("G",7));
    }
    
}
