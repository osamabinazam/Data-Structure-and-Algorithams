package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFSForSSSPPUsingAdjacencyList {

    //Class Members
    ArrayList<Vertex> vertices ;

    //Constructor
    BFSForSSSPPUsingAdjacencyList(ArrayList<Vertex> vertices){
        this.vertices=vertices;
    }
     
    //Method that build Undirected Graph
    public void addUndirectedGraph(int i , int j){
        Vertex first = vertices.get(i);
        Vertex second = vertices.get(j);
        first.neighbors.add(second);
        second.neighbors.add(first); 
    }
     
    /*************************/
    /*      BFS for SSSPP    */
    /*************************/
    
    //Helper Method
    public void printPath(Vertex vertex) {
        //Base Condition
        if(vertex.getParent() != null)
                printPath(vertex.getParent());

        System.out.print(vertex.getName() + " ");
    }

    //Driver method
    public void bfsForSSSPP(Vertex vertex){
        //Implementing Queue using LinkedList
        LinkedList<Vertex> queue = new LinkedList<>();
        queue.push(vertex);
        while (!queue.isEmpty()){
            Vertex node = queue.remove(0);
            node.setVisited(true);
            System.out.print("Printing path for node " + node.getName() + " : ");
            printPath(node);
            System.out.println("");
            for (Vertex neighbor : node.neighbors) {
                if(!neighbor.getVisited()){
                    queue.add(neighbor);
                    neighbor.setVisited(true);
                    neighbor.setParent(node);
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Vertex> vertices = new ArrayList<>();
        vertices.add(new Vertex("A", 0));
        vertices.add(new Vertex("B", 1));
        vertices.add(new Vertex("C", 2));
        vertices.add(new Vertex("D", 3));
        vertices.add(new Vertex("E", 4));
        vertices.add(new Vertex("F", 5));
        vertices.add(new Vertex("G", 6));

        BFSForSSSPPUsingAdjacencyList graph = new BFSForSSSPPUsingAdjacencyList(vertices);
        graph.addUndirectedGraph(0, 1);
        graph.addUndirectedGraph(0, 2);
        graph.addUndirectedGraph(1, 3);
        graph.addUndirectedGraph(1, 6);
        graph.addUndirectedGraph(2, 3);
        graph.addUndirectedGraph(2, 4);
        graph.addUndirectedGraph(3, 5);
        graph.addUndirectedGraph(4, 5);
        graph.addUndirectedGraph(5, 6);

        //Calling BFS For SSSPP
        graph.bfsForSSSPP(vertices.get(0));

    }



}




//Creating Own Data Type that will repersent a vertex of a graph
class Vertex {

    //Instance Variable
    private String name;
    private int index;
    private boolean isVisited;
    private Vertex parentVertex;
    ArrayList<Vertex> neighbors = new ArrayList<>() ;

    //Constructors
    Vertex(String name, int index){
        this.name = name;
        this.index=index;
        this.isVisited=false;
        this.parentVertex=null;
    }

    //Getter and Setters

    //Get vertex name
    public String getName(){
        return this.name;
    }
    //Set vertex name
    public void setName (String name){
        this.name = name;
    }
    public void setParent(Vertex parenVertex){
        this.parentVertex = parenVertex;
    }
    public Vertex getParent(){
        return this.parentVertex;
    }
    public void setIndex(int index){
        this.index = index;
    }
    public int getIndex (){
        return this.index;
    }
    public void setVisited(Boolean isVisited){
        this.isVisited = isVisited;
    }
    public Boolean getVisited (){
        return this.isVisited;
    }
}
