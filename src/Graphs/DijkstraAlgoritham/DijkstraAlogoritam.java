package Graphs.DijkstraAlgoritham;

import java.util.ArrayList;

public class DijkstraAlogoritam {
    public static void main(String[] args) {
        ArrayList<WeightedNode> graph = new ArrayList<WeightedNode>();
        graph.add(new WeightedNode("A",0));
        graph.add(new WeightedNode("B",1));
        graph.add(new WeightedNode("C",2));
        graph.add(new WeightedNode("D",3));
        graph.add(new WeightedNode("E",4));
        graph.add(new WeightedNode("F",5));
        graph.add(new WeightedNode("G",7));
        WeightedGraph weightedGraph = new WeightedGraph(graph);
        weightedGraph.addWeightedNode(0,1,2);
        weightedGraph.addWeightedNode(0,2,5);
        weightedGraph.addWeightedNode(1,2,6);
        weightedGraph.addWeightedNode(1,3,1);
        weightedGraph.addWeightedNode(1,4,3);
        weightedGraph.addWeightedNode(2,5,8);
        weightedGraph.addWeightedNode(2,4,4);
        weightedGraph.addWeightedNode(4,6,9);
        weightedGraph.addWeightedNode(5,6,7);
        System.out.println("Printing Dijkstra's Algorithm");
        weightedGraph.dijkstra(graph.get(0));

    }
}