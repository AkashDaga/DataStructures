package StackAndQueues.utils;

import java.util.Scanner;

public class QueueUtils {
    private static QueueUtils queueUtils;
    private int front = 0;
    private int rear = -1;
    Scanner scanner = null;

    public static QueueUtils getInstance() {
        if (queueUtils == null) {
            queueUtils = new QueueUtils();
        }

        return queueUtils;
    }

    private QueueUtils() {
        scanner = new Scanner(System.in);
    }

    public void createQueue() {
        System.out.println("Enter the Size of the queue");
        int size = scanner.nextInt();

        int arr[] = new int[size];

        boolean loopIt = true;
        do {
            System.out.println("press 1 for enqueue");
            System.out.println("press 2 for dequeue");
            System.out.println("press 3 for printing all the values");

            int options = scanner.nextInt();

            switch (options) {
                case 1: {
                    enqueue(scanner.nextInt(), size,rear, arr);
                    break;
                }
                case 2: {
                    dequeue(front, rear, arr);
                    printTheQueue(this.front, arr);
                    break;
                }
                case 3: {
                    printTheQueue(this.front, arr);
                    break;
                }
            }

            System.out.println("Do you want to continue yes/no?");
            String operateAgain = scanner.next();
            loopIt = operateAgain.toLowerCase().charAt(0) == 'y';
        } while (loopIt);


    }

    private void dequeue(int front,int rear, int[] arr) {
        if(front > rear){
            System.out.println("queue is empty now");
        } else {
            int dequedValue = arr[this.front];
            this.front = ++front;
            System.out.println("dequed value is : "+ dequedValue);
        }

        printTheQueue(this.front,arr);
    }

    private void enqueue(int key, int size, int rear, int[] arr) {
        if (rear == size - 1) {
            System.out.println("Overflow condition reached");
        } else {
            this.rear = ++rear;
            arr[this.rear] = key;
        }

        printTheQueue(this.front,arr);
    }


    private void printTheQueue(int front, int[] arr) {
        System.out.println("Queue");
        for (int i = front; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }


}
