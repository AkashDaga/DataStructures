package linkedlist.utils;

import linkedlist.nodes.Node;

import java.util.HashMap;
import java.util.Scanner;

public class LinkedListUtils {
    LinkedListTypes linkedListType;
    Scanner scanner;
    private static LinkedListUtils linkedListUtils;
    SingleLinkedListUtils singleLinkedListUtils;
    DoublyLinkedListUtils doublyLinkedListUtils;
    CircularSingleLinkedListUtils circularSingleLinkedListUtils;
    CircularDoublyLinkedListUtils circularDoublyLinkedListUtils;

    public static LinkedListUtils getInstance() {
        if (linkedListUtils == null) {
            linkedListUtils = new LinkedListUtils();
        }

        return linkedListUtils;
    }

    private LinkedListUtils() {
        scanner = new Scanner(System.in);
    }

    public BaseUtils whichTypeOfLinkedList() {
        System.out.println("Which type of linkedlist you want to create");

        System.out.println("press 1 for single linked list");
        System.out.println("press 2 for double linked list");
        System.out.println("press 3 for single circular linked list");
        System.out.println("press 4 for double circular linked list");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1: {
                singleLinkedListUtils = SingleLinkedListUtils.getInstance();
                boolean loopIt = true;
                do {
                    System.out.println("press 1 for insertion at first");
                    System.out.println("press 2 for insertion at last");
                    System.out.println("press 3 for insertion at any place");
                    System.out.println("press 4 for delete the node at first position");
                    System.out.println("press 5 for delete the node at last position");
                    System.out.println("press 6 for delete the node at any position");
                    System.out.println("press 7 for the size of the array");
                    System.out.println("press 8 print the list");

                    int options = scanner.nextInt();

                    switch (options) {
                        case 1: {
                            System.out.println("Enter the value ");
                            singleLinkedListUtils.addAtFirst(scanner.nextInt());
                            singleLinkedListUtils.print(singleLinkedListUtils.getHead());
                            break;
                        }
                        case 2: {
                            System.out.println("Enter the value ");
                            singleLinkedListUtils.addAtLast(scanner.nextInt());
                            singleLinkedListUtils.print(singleLinkedListUtils.getHead());
                            break;
                        }
                        case 3: {
                            System.out.println("Enter the value ");
                            int key = scanner.nextInt();
                            System.out.println("Enter the position ");
                            int position = scanner.nextInt();

                            singleLinkedListUtils.addAtAnyPosition(key, position);
                            singleLinkedListUtils.print(singleLinkedListUtils.getHead());
                            break;
                        }
                        case 4: {
                            singleLinkedListUtils.deleteAtFirst();
                            singleLinkedListUtils.print(singleLinkedListUtils.getHead());
                            break;
                        }
                        case 5: {
                            singleLinkedListUtils.deleteAtLast();
                            singleLinkedListUtils.print(singleLinkedListUtils.getHead());
                            break;
                        }
                        case 6: {
                            System.out.println("Enter the position ");
                            singleLinkedListUtils.deleteAtAnyPosition(scanner.nextInt());
                            singleLinkedListUtils.print(singleLinkedListUtils.getHead());

                            break;
                        }
                        case 7: {
                            System.out.println("size of the linked list -> " + singleLinkedListUtils.getCount());
                            break;
                        }
                        case 8: {
                            singleLinkedListUtils.print(singleLinkedListUtils.getHead());
                            break;
                        }
                    }

                    System.out.println("Do you want to continue yes/no?");
                    String operateAgain = scanner.next();
                    loopIt = operateAgain.toLowerCase().charAt(0) == 'y';
                } while (loopIt);

                return singleLinkedListUtils;
            }
            case 2: {
                doublyLinkedListUtils = DoublyLinkedListUtils.getInstance();
                boolean loopIt = true;
                do {
                    System.out.println("press 1 for insertion at first");
                    System.out.println("press 2 for insertion at last");
                    System.out.println("press 3 for insertion at any place");
                    System.out.println("press 4 for delete the node at first position");
                    System.out.println("press 5 for delete the node at last position");
                    System.out.println("press 6 for delete the node at any position");
                    System.out.println("press 7 for the size of the array");
                    System.out.println("press 8 print the list");
                    System.out.println("press 9 for testing Double Linked List");

                    int options = scanner.nextInt();

                    switch (options) {
                        case 1: {
                            System.out.println("Enter the value ");
                            doublyLinkedListUtils.addAtFirst(scanner.nextInt());
                            doublyLinkedListUtils.print(doublyLinkedListUtils.getHead());
                            break;
                        }
                        case 2: {
                            System.out.println("Enter the value ");
                            doublyLinkedListUtils.addAtLast(scanner.nextInt());
                            doublyLinkedListUtils.print(doublyLinkedListUtils.getHead());
                            break;
                        }
                        case 3: {
                            System.out.println("Enter the value ");
                            int key = scanner.nextInt();
                            System.out.println("Enter the position ");
                            int position = scanner.nextInt();

                            doublyLinkedListUtils.addAtAnyPosition(key, position);
                            doublyLinkedListUtils.print(doublyLinkedListUtils.getHead());
                            break;
                        }
                        case 4: {
                            doublyLinkedListUtils.deleteAtFirst();
                            doublyLinkedListUtils.print(doublyLinkedListUtils.getHead());
                            break;
                        }
                        case 5: {
                            doublyLinkedListUtils.deleteAtLast();
                            doublyLinkedListUtils.print(doublyLinkedListUtils.getHead());
                            break;
                        }
                        case 6: {
                            System.out.println("Enter the position ");
                            doublyLinkedListUtils.deleteAtAnyPosition(scanner.nextInt());
                            doublyLinkedListUtils.print(doublyLinkedListUtils.getHead());

                            break;
                        }
                        case 7: {
                            System.out.println("size of the linked list -> " + doublyLinkedListUtils.getCount());
                            break;
                        }
                        case 8: {
                            doublyLinkedListUtils.print(doublyLinkedListUtils.getHead());
                            break;
                        }
                        case 9: {
                            System.out.println("Enter the position ");
                            doublyLinkedListUtils.printThePreviousElement(scanner.nextInt());
                            break;
                        }
                    }

                    System.out.println("Do you want to continue yes/no?");
                    String operateAgain = scanner.next();
                    loopIt = operateAgain.toLowerCase().charAt(0) == 'y';
                } while (loopIt);

                return doublyLinkedListUtils;
            }
            case 3: {
                circularSingleLinkedListUtils = CircularSingleLinkedListUtils.getInstance();
                boolean loopIt = true;
                do {
                    System.out.println("press 1 for insertion at first");
                    System.out.println("press 2 for insertion at last");
                    System.out.println("press 3 for insertion at any place");
                    System.out.println("press 4 for delete the node at first position");
                    System.out.println("press 5 for delete the node at last position");
                    System.out.println("press 6 for delete the node at any position");
                    System.out.println("press 7 for the size of the array");
                    System.out.println("press 8 print the list");
                    System.out.println("press 9 for testing Circular single Linked List");

                    int options = scanner.nextInt();

                    switch (options) {
                        case 1: {
                            System.out.println("Enter the value ");
                            circularSingleLinkedListUtils.addAtFirst(scanner.nextInt());
                            circularSingleLinkedListUtils.print(circularSingleLinkedListUtils.getHead());
                            break;
                        }
                        case 2: {
                            System.out.println("Enter the value ");
                            circularSingleLinkedListUtils.addAtLast(scanner.nextInt());
                            circularSingleLinkedListUtils.print(circularSingleLinkedListUtils.getHead());
                            break;
                        }
                        case 3: {
                            System.out.println("Enter the value ");
                            int key = scanner.nextInt();
                            System.out.println("Enter the position ");
                            int position = scanner.nextInt();

                            circularSingleLinkedListUtils.addAtAnyPosition(key, position);
                            circularSingleLinkedListUtils.print(circularSingleLinkedListUtils.getHead());
                            break;
                        }
                        case 4: {
                            circularSingleLinkedListUtils.deleteAtFirst();
                            circularSingleLinkedListUtils.print(circularSingleLinkedListUtils.getHead());
                            break;
                        }
                        case 5: {
                            circularSingleLinkedListUtils.deleteAtLast();
                            circularSingleLinkedListUtils.print(circularSingleLinkedListUtils.getHead());
                            break;
                        }
                        case 6: {
                            System.out.println("Enter the position ");
                            circularSingleLinkedListUtils.deleteAtAnyPosition(scanner.nextInt());
                            circularSingleLinkedListUtils.print(circularSingleLinkedListUtils.getHead());

                            break;
                        }
                        case 7: {
                            System.out.println("size of the linked list -> " + circularSingleLinkedListUtils.getCount());
                            break;
                        }
                        case 8: {
                            circularSingleLinkedListUtils.print(circularSingleLinkedListUtils.getHead());
                            break;
                        }
                        case 9: {
                            circularSingleLinkedListUtils.test();
                            break;
                        }
                    }

                    System.out.println("Do you want to continue yes/no?");
                    String operateAgain = scanner.next();
                    loopIt = operateAgain.toLowerCase().charAt(0) == 'y';
                } while (loopIt);
                return circularSingleLinkedListUtils;
            }
            case 4: {
                circularDoublyLinkedListUtils = CircularDoublyLinkedListUtils.getInstance();
                boolean loopIt = true;
                do {
                    System.out.println("press 1 for insertion at first");
                    System.out.println("press 2 for insertion at last");
                    System.out.println("press 3 for insertion at any place");
                    System.out.println("press 4 for delete the node at first position");
                    System.out.println("press 5 for delete the node at last position");
                    System.out.println("press 6 for delete the node at any position");
                    System.out.println("press 7 for the size of the array");
                    System.out.println("press 8 print the list");
                    System.out.println("press 9 for testing Circular doubly Linked List");

                    int options = scanner.nextInt();

                    switch (options) {
                        case 1: {
                            System.out.println("Enter the value ");
                            circularDoublyLinkedListUtils.addAtFirst(scanner.nextInt());
                            circularDoublyLinkedListUtils.print(circularDoublyLinkedListUtils.getHead());
                            break;
                        }
                        case 2: {
                            System.out.println("Enter the value ");
                            circularDoublyLinkedListUtils.addAtLast(scanner.nextInt());
                            circularDoublyLinkedListUtils.print(circularDoublyLinkedListUtils.getHead());
                            break;
                        }
                        case 3: {
                            System.out.println("Enter the value ");
                            int key = scanner.nextInt();
                            System.out.println("Enter the position ");
                            int position = scanner.nextInt();

                            circularDoublyLinkedListUtils.addAtAnyPosition(key, position);
                            circularDoublyLinkedListUtils.print(circularDoublyLinkedListUtils.getHead());
                            break;
                        }
                        case 4: {
                            circularDoublyLinkedListUtils.deleteAtFirst();
                            circularDoublyLinkedListUtils.print(circularDoublyLinkedListUtils.getHead());
                            break;
                        }
                        case 5: {
                            circularDoublyLinkedListUtils.deleteAtLast();
                            circularDoublyLinkedListUtils.print(circularDoublyLinkedListUtils.getHead());
                            break;
                        }
                        case 6: {
                            System.out.println("Enter the position ");
                            circularDoublyLinkedListUtils.deleteAtAnyPosition(scanner.nextInt());
                            circularDoublyLinkedListUtils.print(circularDoublyLinkedListUtils.getHead());

                            break;
                        }
                        case 7: {
                            System.out.println("size of the linked list -> " + circularDoublyLinkedListUtils.getCount());
                            break;
                        }
                        case 8: {
                            circularDoublyLinkedListUtils.print(circularDoublyLinkedListUtils.getHead());
                            break;
                        }
                        case 9: {
                            circularDoublyLinkedListUtils.test();
                            break;
                        }
                    }

                    System.out.println("Do you want to continue yes/no?");
                    String operateAgain = scanner.next();
                    loopIt = operateAgain.toLowerCase().charAt(0) == 'y';
                } while (loopIt);

                return circularDoublyLinkedListUtils;
            }

            default: return null;
        }
    }

    public Node reverseLinkedList(){
        BaseUtils baseUtils = whichTypeOfLinkedList();

        if(baseUtils == null){
            System.out.print("Base Utils cant be null");
            return null;
        }

        if(baseUtils instanceof SingleLinkedListUtils){
            return singleLinkedListUtils.reverseLinkedList(singleLinkedListUtils.getHead());
        } else if(baseUtils instanceof DoublyLinkedListUtils){
            return doublyLinkedListUtils.reverseLinkedList(doublyLinkedListUtils.getHead());
        } else if (baseUtils instanceof CircularSingleLinkedListUtils){
            return circularSingleLinkedListUtils.reverseLinkedList(circularSingleLinkedListUtils.getHead());
        } else if(baseUtils instanceof CircularDoublyLinkedListUtils){
            return circularDoublyLinkedListUtils.reverseLinkedList(circularDoublyLinkedListUtils.getHead());
        } else {
            System.out.println("oops... something went wrong ");
            return null;
        }

    }
}
