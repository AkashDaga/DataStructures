package linkedlist.utils;

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

    public void whichTypeOfLinkedList() {
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
                break;
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
                break;
            }
            case 3: {
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
                    }

                    System.out.println("Do you want to continue yes/no?");
                    String operateAgain = scanner.next();
                    loopIt = operateAgain.toLowerCase().charAt(0) == 'y';
                } while (loopIt);
                break;
            }
            case 4: {
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
                    System.out.println("press 8 print the array");

                    int options = scanner.nextInt();

                    switch (options) {
                        case 1: {
                            break;
                        }
                        case 2: {

                            break;
                        }
                        case 3: {

                            break;
                        }
                        case 4: {

                            break;
                        }
                    }

                    System.out.println("Do you want to continue yes/no?");
                    String operateAgain = scanner.nextLine();
                    loopIt = operateAgain.toLowerCase().charAt(0) == 'y';
                }
                while (loopIt);
                break;
            }
        }
    }
}
