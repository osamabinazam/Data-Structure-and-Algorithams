package Graphs.DijkstraAlgoritham;

import java.util.ArrayList;
import java.util.HashMap;

public class WeightedNode implements Comparable<WeightedNode>{
    public String name;
    public WeightedNode parent;
    public int distance;
    public int index;
    public boolean isVisited;
    public ArrayList<WeightedNode> neighbors = new ArrayList<>();
    public HashMap<WeightedNode,Integer> weightMap = new HashMap<>(); 
    public WeightedNode(String name , int index){
        this.name=name;
        this.index=index;
        this.distance=Integer.MAX_VALUE;

    }
    public String toString(){
        return this.name;
    }
    @Override
    public int compareTo(WeightedNode node) {
        return this.distance-node.distance;
    }
}