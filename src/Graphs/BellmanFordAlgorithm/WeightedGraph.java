package Graphs.BellmanFordAlgorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class WeightedGraph {
    public ArrayList<WeightedNode> nodeList = new ArrayList<>();

    public WeightedGraph(ArrayList<WeightedNode> nodesList){
        this.nodeList=nodesList;
    }


    public void addWeightedNode(int i, int j , int distance){
        WeightedNode first = nodeList.get(i);
        WeightedNode second = nodeList.get(j);
        first.neighbors.add(second);
        first.weightMap.put(second, distance);
    }

    //Bellman Ford Algoritham Implementation
    public void bellmanFord(WeightedNode sourcNode){
        sourcNode.distance=0;
        //Looping Vertex-1
        for(int i=0; i<nodeList.size(); i++){
            for (WeightedNode currentNode : nodeList) {
                for (WeightedNode neighbor : currentNode.neighbors) {
                    if(neighbor.distance> currentNode.distance + currentNode.weightMap.get(neighbor)){
                        neighbor.distance = currentNode.distance + currentNode.weightMap.get(neighbor);
                        neighbor.parent=currentNode;
                    }
                    
                }
                
            }
        }
        System.out.println("Checking For Negative Cycle: ");
        for (WeightedNode currentNode : nodeList) {
            for (WeightedNode neighbor : currentNode.neighbors) {
                if(neighbor.distance> currentNode.distance + currentNode.weightMap.get(neighbor)){
                    System.out.println("Negative Cycle Found :");
                    System.out.println("Vertex Name is : " +neighbor.name);
                    System.out.println("Old Cost is : "+ neighbor.distance);
                    int newDistance = currentNode.distance + currentNode.weightMap.get(neighbor);
                    System.out.println("New Cost is  : " +newDistance);
                    return;
                }
                
            }
        }
        System.out.println("Negative Cycle Not Found");
        for (WeightedNode nodeToCheck : nodeList) {
            System.out.print("Node " +nodeToCheck+", Distance: " + nodeToCheck.distance +", Path: ");
            printPath(nodeToCheck);
            System.out.println();
            
        }

    }

    
    public void printPath(WeightedNode nodeToPrint){
        if (nodeToPrint.parent !=null)
            printPath(nodeToPrint.parent);
        System.out.print(nodeToPrint.name + " ");
    }

}
