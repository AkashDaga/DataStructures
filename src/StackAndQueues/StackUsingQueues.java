package StackAndQueues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackUsingQueues {
    public static void main(String args[]){
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        boolean loopIt = true;
        while (loopIt){
            System.out.println("Press 1 for push");
            System.out.println("Press 2 for pop");
            System.out.println("Press 3 Continue yes/no");

            int x = sc.nextInt();

            switch (x){
                case 1: {
                    System.out.println("Enter the value");
                    ((LinkedList<Integer>) q1).add(sc.nextInt());

                    System.out.println("Queue ---> "+q1);
                    break;
                }
                case 2: {
                    while(q1.size() > 1){
                        ((LinkedList<Integer>) q2).add(((LinkedList<Integer>) q1).pop());
                    }

                    System.out.println("popped element "+((LinkedList<Integer>) q1).pop());

                    Queue<Integer> temp = q1;
                    q1 = q2;
                    q2 = temp;

                    System.out.println("Queue ---> "+q1);
                    break;
                }
            }

            System.out.println("Do you want to continue yes/no?");
            String operateAgain = sc.next();
            loopIt = operateAgain.toLowerCase().charAt(0) == 'y';
        }

    }
}
