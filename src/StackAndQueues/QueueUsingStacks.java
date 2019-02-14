package StackAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingStacks {
    public static void main(String args[]){
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        Scanner sc = new Scanner(System.in);
        boolean loopIt = true;
        while (loopIt){
            System.out.println("Press 1 for enqueue");
            System.out.println("Press 2 for dequeue");
            System.out.println("Press 3 Continue yes/no");

            int x = sc.nextInt();

            switch (x){
                case 1: {
                    System.out.println("Enter the value");
                    s1.push(sc.nextInt());
                    break;
                }
                case 2: {
                    if(s2.isEmpty()){
                        if(s1.isEmpty()){
                            System.out.println("Underflow");
                            return;
                        }

                        while(s1.size() > 0){
                            int a = s1.pop();
                            s2.push(a);
                        }
                    }
                    System.out.println("Dequeued element "+ s2.pop());
                    break;
                }
            }

            System.out.println("Do you want to continue yes/no?");
            String operateAgain = sc.next();
            loopIt = operateAgain.toLowerCase().charAt(0) == 'y';
        }
    }
}
