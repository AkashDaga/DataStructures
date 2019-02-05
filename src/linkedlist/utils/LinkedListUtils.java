package linkedlist.utils;

import java.util.Scanner;

public class LinkedListUtils {
    LinkedListTypes linkedListType;
    Scanner scanner;
    private static LinkedListUtils linkedListUtils;

    public static LinkedListUtils getInstance(){
        if(linkedListUtils == null){
            linkedListUtils = new LinkedListUtils();
        }

        return linkedListUtils;
    }

    private LinkedListUtils(){
        scanner = new Scanner(System.in);
    }

    public void whichTypeOfLinkedList(){
        System.out.println("Which type of linkedlist you want to create");

        System.out.println("press 1 for single linked list");
        System.out.println("press 2 for double linked list");
        System.out.println("press 3 for single circular linked list");
        System.out.println("press 4 for double circular linked list");
        int choice = scanner.nextInt();

        switch(choice){
            case 1:{
                linkedListType = LinkedListTypes.SINGLE_LINKED_LIST;
                break;
            }
            case 2:{
                linkedListType = LinkedListTypes.DOUBLY_LINKED_LIST;
                break;
            }
            case 3:{
                linkedListType = LinkedListTypes.CIRCULAR_SINGLE_LIKED_LIST;
                break;
            }
            case 4:{
                linkedListType = LinkedListTypes.CIRCULAR_DOUBLE_LIKED_LIST;
                break;
            }
        }
    }

    public void askForInputs(){
        boolean loopIt = true;
        do{
            System.out.println("press 1 for insertion at first");
            System.out.println("press 2 for insertion at last");
            System.out.println("press 3 for insertion at any place");
            System.out.println("press 4 for delete the node at first position");
            System.out.println("press 5 for delete the node at last position");
            System.out.println("press 6 for delete the node at any position");
            System.out.println("press 7 for the size of the array");
            System.out.println("press 8 print the array");

            int choice = scanner.nextInt();

            switch(choice){
                case 1:{

                    break;
                }
                case 2:{

                    break;
                }
                case 3:{

                    break;
                }
                case 4:{

                    break;
                }
            }

            System.out.println("Do you want to continue yes/no?");
            String operateAgain = scanner.nextLine();
            loopIt = operateAgain.toLowerCase().charAt(0) == 'y';
        }
        while (loopIt);
    }
}
