package Graphs.DijkstraAlgoritham;

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

    public void dijkstra (WeightedNode sourNode){
        PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
        sourNode.distance=0;
        queue.addAll(nodeList);
        while (!queue.isEmpty()){           // while queue is not empty
            WeightedNode currentNode =  queue.remove(); // remove current node from queue
            for (WeightedNode neighbor : currentNode.neighbors) {
                if (queue.contains(neighbor) ) {        //if the node is already in the queue
                    if(neighbor.distance >currentNode.distance +  currentNode.weightMap.get(neighbor)){
                        neighbor.distance = currentNode.distance +  currentNode.weightMap.get(neighbor);        //update distance
                        neighbor.parent = currentNode;
                        queue.remove(neighbor);
                        queue.add(neighbor);
                    }
                    
                }

            }
        }
        for (WeightedNode nodetoCheck : nodeList) {
            System.out.print("Node " +nodetoCheck +", Distance: " + nodetoCheck.distance+ " Path: "     );
            printPath(nodetoCheck);
            System.out.println();
        }

    }
    public void printPath(WeightedNode nodeToPrint){
        if (nodeToPrint.parent !=null)
            printPath(nodeToPrint.parent);
        System.out.print(nodeToPrint.name + " ");
    }

}
