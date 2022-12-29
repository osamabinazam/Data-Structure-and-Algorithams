package Graphs;
import java.util.ArrayList;

public class GraphUsingAdjacencyList {

    //Class Members
    ArrayList<GraphNode> list = new ArrayList<>();

    //Constructor
     GraphUsingAdjacencyList(ArrayList<GraphNode> list){
        this.list=list;
     }
    
    //Method that build Undirected Graph
    public void addUndirectedGraph(int i , int j){
        GraphNode first = list.get(i);
        GraphNode second = list.get(j);
        first.neighbors.add(second);
        second.neighbors.add(first); 

    } 






    //Method to print Graph
    public String toString(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            str.append(list.get(i).name +": ");
            for (int j = 0; j < list.get(i).neighbors.size(); j++) {
                if (j == list.get(i).neighbors.size() -1 ){
                    str.append(list.get(i).neighbors.get(j).name);
                }
                else{
                    str.append(list.get(i).neighbors.get(j).name + "->");
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

    }
    
}
