package StackAndQueues.main_app;
import java.util.*;

public class CircularQueueUtils {
    private static CircularQueueUtils circularQueueUtils;
    private int[] queue;
    int size;
    int front = -1;
    int rear = -1;

    public static CircularQueueUtils getInstance(int size) {
        if (circularQueueUtils == null) {
            circularQueueUtils = new CircularQueueUtils(size);
        }
        return circularQueueUtils;
    }

    private CircularQueueUtils(int size){
        this.size = size;
        queue = new int[size];
    }

    public void executeProgram() {
        Scanner sc = new Scanner(System.in);
        boolean loopIt = true;
        while (loopIt) {
            System.out.println("Press 1 for enqueue");
            System.out.println("Press 2 for dequeue");
            System.out.println("Press 3 Continue yes/no");

            int x = sc.nextInt();

            switch (x) {
                case 1: {
                    System.out.println("Enter the value");
                    enqueue(sc.nextInt());
                    break;
                }
                case 2: {
                    dequeue();
                    break;
                }
            }

            System.out.println("Do you want to continue yes/no?");
            String operateAgain = sc.next();
            loopIt = operateAgain.toLowerCase().charAt(0) == 'y';
        }
    }

    private void enqueue(int data) {
        System.out.println("before enqueue front : "+front+" rear : "+rear+" size : "+size);
        if((front == 0 && rear == size -1) || (front == rear+1)){
            System.out.println("Overflow condition reached");
            return;
        } else if(front == -1){
            front = 0;
            rear = 0;
        } else if(rear == size -1){
            rear = 0;
        } else {
            rear = rear + 1;
        }
        System.out.println("aftre enqueue front : "+front+" rear : "+rear+" size : "+size);
        queue[rear] = data;
    }

    private void dequeue() {
        System.out.println("before dequeue front : "+front+" rear : "+rear+" size : "+size);
        if(front == -1){
            System.out.println("Underflow condition reached");
            return;
        }

        System.out.println(queue[front]+" is popped out");

        if(front == rear){
            front = -1;
            rear = -1;
        } else if(front == size-1){
            front = 0;
        } else {
            front++;
        }

        System.out.println("after dequeue front : "+front+" rear : "+rear+" size : "+size);
    }
}
