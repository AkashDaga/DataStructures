package StackAndQueues.main_app;

import java.util.Scanner;

public class RunCircularQueueApp {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the queue");
        int size = sc.nextInt();

        CircularQueueUtils circularQueueUtils = CircularQueueUtils.getInstance(size);
        circularQueueUtils.executeProgram();
    }
}
