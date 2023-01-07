package Graphs.BFS_For_SSSPP;
import java.util.*;
public class BFSForSSSPPUsingAdjacentMatrix {
    ArrayList<Vertex> nodes;          //Original List of Graph
    ArrayList<Vertex> copiedList;    //Copied Orignal list in it so that I can work on it without destroying the original One
    int [][] adjacencyMatrix;


    //Constructor
    BFSForSSSPPUsingAdjacentMatrix(ArrayList<Vertex> nodes){
        this.nodes=nodes;
        adjacencyMatrix = new int[this.nodes.size()][this.nodes.size()];  //Adjacent Matrix
        // copiedList = copyList(nodes);
    }

     //Method which adds the edges to the node
    // i->index of first node
    // j->index of second node
    public void addUndirectedGraph(int i , int j){
        adjacencyMatrix[i][j] = 1;          //link/edge between i and j
        adjacencyMatrix[j][i] = 1;          //link/edge between j and i
    }
    //1. Getting Neighbors
    public ArrayList<Vertex> getNeighbors (Vertex node){
        ArrayList<Vertex> neighbors = new ArrayList<>();
        int nodeIndex = node.getIndex();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[nodeIndex][i] == 1){
                    neighbors.add(nodes.get(i));
            }
        }
        return neighbors;    
    }

     //Helper Method
     //Print the path between nodes 
     private void printPath(Vertex vertex){
        if(vertex.getParent() != null){
            printPath(vertex.getParent());
        }
        System.out.print(vertex.getName() +" ");
    }


    //Drriver method 
    public void bfsForSSSPP (Vertex vertex){
        LinkedList <Vertex> queue = new LinkedList<>();
        queue.add(vertex);
        while(!queue.isEmpty()){
            Vertex currenVertex = queue.remove(0);
            currenVertex.setVisited(true);
            System.out.print("Printing path for vertex " + currenVertex.getName() +": ");
            printPath(currenVertex);
            System.out.println("");
            ArrayList<Vertex> neighbors =getNeighbors(currenVertex);
            for (Vertex neighbor : neighbors) {
                if(!neighbor.getVisited()){
                queue.add(neighbor);
                neighbor.setVisited(true);
                neighbor.setParent(currenVertex);
                }
            }

        }

    }

    //Extra method
    public ArrayList<Vertex> copyList (ArrayList<Vertex> nodes){
        ArrayList<Vertex> copiedList = new ArrayList<>();

        for (int i =0 ; i< nodes.size();  i++){
            String name = nodes.get(i).getName();
            int index = nodes.get(i).getIndex();
            Vertex newNode = new Vertex(name, index);
            copiedList.add(newNode);
        }
        return copiedList;
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

        BFSForSSSPPUsingAdjacentMatrix graph = new BFSForSSSPPUsingAdjacentMatrix(vertices);
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
