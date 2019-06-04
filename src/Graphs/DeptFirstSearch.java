package Graphs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class DeptFirstSearch {
    boolean[] visited;
    ArrayList<LinkedList<Integer>> adjacencyList;


    public DeptFirstSearch(){
        /*
         * create an adjacency list
         *  0 --> [1,2]
         *  1 --> [0,2]
         *  2 --> [0,1]
         */
        System.out.println("==============DFS==============");
        int sizeOfAdjacencyList = 8;

        visited = new boolean[sizeOfAdjacencyList];
        adjacencyList = new ArrayList<>(sizeOfAdjacencyList);

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

        System.out.println("The Dept First Search of The Adjacency List is\n");
    }

    public void execute(int v){
        System.out.print(v+" ");

        visited[v] = true;
        for(Integer n : adjacencyList.get(v)){
            if(!visited[n]){
                execute(n);
            }
        }

    }

}
