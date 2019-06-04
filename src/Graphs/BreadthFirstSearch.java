package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    boolean[] visited;
    ArrayList<LinkedList<Integer>> adjacencyList;
    Queue<Integer> queue;


    public BreadthFirstSearch(){
        /*
         * create an adjacency list
         *  0 --> [1,2]
         *  1 --> [0,2]
         *  2 --> [0,1]
         */

        System.out.println("==============BFS==============");
        int sizeOfAdjacencyList = 8;

        visited = new boolean[sizeOfAdjacencyList];
        adjacencyList = new ArrayList<>(sizeOfAdjacencyList);
        queue = new LinkedList<Integer>();

        for(int i = 0 ; i < sizeOfAdjacencyList; i++){
            adjacencyList.add(i,new LinkedList<Integer>());
            visited[i] = false;
        }

        adjacencyList.get(0).add(1);
        adjacencyList.get(0).add(2);

        adjacencyList.get(1).add(0);
        adjacencyList.get(1).add(3);
        adjacencyList.get(1).add(4);

        adjacencyList.get(2).add(0);
        adjacencyList.get(2).add(5);
        adjacencyList.get(2).add(6);

        adjacencyList.get(3).add(7);
        adjacencyList.get(3).add(1);

        adjacencyList.get(4).add(1);
        adjacencyList.get(4).add(7);

        adjacencyList.get(5).add(2);
        adjacencyList.get(5).add(7);

        adjacencyList.get(6).add(2);
        adjacencyList.get(6).add(7);

        adjacencyList.get(7).add(3);
        adjacencyList.get(7).add(4);
        adjacencyList.get(7).add(5);
        adjacencyList.get(7).add(6);

        for(int i = 0; i< adjacencyList.size(); i++){
            System.out.println(i+" ---> "+adjacencyList.get(i));
        }

        System.out.println("The Breadth First Search of The Adjacency List is");
    }

    public void execute(int v){
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()){
            int visitedNode = queue.poll();
            System.out.print(visitedNode+" ");
            for(int n : adjacencyList.get(visitedNode)){
                if(!visited[n])
                    queue.add(n);

                visited[n] = true;
            }
        }
    }
}
