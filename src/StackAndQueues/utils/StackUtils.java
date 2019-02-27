package StackAndQueues.utils;

import java.util.Scanner;

public class StackUtils {
    private static StackUtils stackUtils;
    private int top = -1;
    Scanner scanner = null;

    public static StackUtils getInstance(){
        if(stackUtils == null){
            stackUtils = new StackUtils();
        }

        return stackUtils;
    }

    private StackUtils(){
        scanner = new Scanner(System.in);
    }


    public void createStack(){
        System.out.println("Enter the Size of the stack");
        int size = scanner.nextInt();

        int arr[] = new int[size];

        boolean loopIt = true;
        do {
            System.out.println("press 1 for push");
            System.out.println("press 2 for pop");
            System.out.println("press 3 for printing all the values");

            int options = scanner.nextInt();

            switch (options) {
                case 1: {
                    if(top == size-1){
                        System.out.println("Overflow condition reached");
                    } else {
                        System.out.println("Enter the value ");
                        arr[++top] = scanner.nextInt();
                        printTheStack(top, arr);
                    }
                    break;
                }
                case 2: {
                    if(top < 0){
                        System.out.println("underflow condition reached");
                    } else {
                        System.out.println("popped value is "+arr[top--]);
                        printTheStack(top, arr);
                    }
                    break;
                }
                case 3: {
                    printTheStack(top, arr);
                    break;
                }
            }

            System.out.println("Do you want to continue yes/no?");
            String operateAgain = scanner.next();
            loopIt = operateAgain.toLowerCase().charAt(0) == 'y';
        } while (loopIt);


    }

    private void printTheStack(int top, int[] arr) {
        System.out.println("stack");
        for(int i = top; i >= 0; i--){
            System.out.println(arr[i]);
        }
    }
}
