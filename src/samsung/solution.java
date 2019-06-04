package samsung;

import java.util.*;

public class solution{

    @SuppressWarnings("unchecked")
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int numberOfTestCases = sc.nextInt();
        System.out.println("numberOfTestCases "+numberOfTestCases);

        for(int k = 0; k < numberOfTestCases; k++){
            int sizeOfChessBoard = sc.nextInt();
            System.out.println("sizeOfChessBoard "+sizeOfChessBoard);

            ArrayList<String>[] adjacencyList = new ArrayList[sizeOfChessBoard];

            for(int i = 0 ; i < sizeOfChessBoard; i++){
                adjacencyList[i] = new ArrayList<>();
                for(int j = 0 ; j < sizeOfChessBoard; j++) {

                    System.out.print(sc.next());
                }



            }
        }
    }
}

class Graph {

    private int numberOfVertices;
    private ArrayList<String>[] adjacencyList;

    public Graph(int numberOfVertices, ArrayList<String>[] adjacencyList) {
        //initialise vertex count
        this.numberOfVertices = numberOfVertices;
        this.adjacencyList = adjacencyList;

        // initialise adjacency list
        initAdjacencyList();
    }

    @SuppressWarnings("unchecked")
    private void initAdjacencyList() {



        for (int i = 0; i < numberOfVertices; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    // add edge from toNode to fromNode
    public void addEdge(String toNode, String fromNode) {
        // Add fromNode to toNode's list.
        adjacencyList[Integer.parseInt(toNode)].add(fromNode);
    }

    public void printAllPaths(String s, String d) {
        boolean[] isVisited = new boolean[numberOfVertices];
        ArrayList<String> pathList = new ArrayList<>();

        //add source to path[]
        pathList.add(s);

        //Call recursive utility
        printAllPathsUtil(s, d, isVisited, pathList);
    }

    // A recursive function to print
    // all paths from 'u' to 'd'.
    // isVisited[] keeps track of
    // vertices in current path.
    // localPathList<> stores actual
    // vertices in the current path
    private void printAllPathsUtil(String u, String d,
                                   boolean[] isVisited,
                                   List<String> localPathList) {

        // Mark the current node
        isVisited[Integer.parseInt(u)] = true;

        if (u.equals(d)) {
            System.out.println(localPathList);
            // if match found then no need to traverse more till depth
            isVisited[Integer.parseInt(u)] = false;
            return;
        }

        // Recur for all the vertices
        // adjacent to current vertex
        for (String i : adjacencyList[Integer.parseInt(u)]) {
            if (!isVisited[Integer.parseInt(i)]) {
                // store current node
                // in path[]
                localPathList.add(i);
                printAllPathsUtil(i, d, isVisited, localPathList);

                // remove current node
                // in path[]
                localPathList.remove(i);
            }
        }

        // Mark the current node
        isVisited[Integer.parseInt(u)] = false;
    }
}