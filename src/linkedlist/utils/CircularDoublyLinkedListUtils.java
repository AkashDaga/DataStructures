package linkedlist.utils;

import linkedlist.nodes.DoublyNode;
import linkedlist.nodes.Node;

public class CircularDoublyLinkedListUtils extends BaseUtils{
    private static CircularDoublyLinkedListUtils circularDoublyLinkedListUtils;
    private DoublyNode head;
    private DoublyNode end;

    static CircularDoublyLinkedListUtils getInstance() {
        if (circularDoublyLinkedListUtils == null) {
            circularDoublyLinkedListUtils = new CircularDoublyLinkedListUtils();
        }
        return circularDoublyLinkedListUtils;
    }

    public DoublyNode addAtFirst(int key) {
        if (head == null) {
            head = new DoublyNode(null, key, null);
            head.setPreviousNode(head);
            head.setNextNode(head);
            end = head;
            return head;
        }

        head = new DoublyNode(end, key, head);
        end.setNextNode(head);
        return head;
    }

    public DoublyNode addAtLast(int key) {
        if (head == null) {
            head = new DoublyNode(null, key, null);
            head.setPreviousNode(head);
            head.setNextNode(head);
            end = head;
            return end;
        }

        DoublyNode newEndNode = new DoublyNode(end, key, head);
        end.setNextNode(newEndNode);
        end = newEndNode;
        head.setPreviousNode(end);
        return end;
    }

    public DoublyNode addAtAnyPosition(int key, int position) {
        System.out.println("position " + position);
        if (position == 1) {
            return addAtFirst(key);
        } else if (position == getCount() + 1) {
            return addAtLast(key);
        } else {
            DoublyNode previousNode = head;
            for (int i = 0; i < position - 2; i++) {
                previousNode = previousNode.getNextNode();
            }

            DoublyNode nextNode = previousNode.getNextNode();
            DoublyNode newNode = new DoublyNode(previousNode, key, nextNode);
            previousNode.setNextNode(newNode);
            nextNode.setPreviousNode(newNode);

            return newNode;
        }
    }

    public void deleteAtFirst() {
        if (head == null) {
            System.out.println("There is nothing to delete");
            return;
        }

        head = head.getNextNode();
        head.setPreviousNode(end);
        end.setNextNode(head);
    }

    public void deleteAtLast() {
        if (head == null) {
            System.out.println("There is nothing to delete");
            return;
        }

        deleteNodeFromPosition(getCount());
    }

    private void deleteNodeFromPosition(int count) {

        DoublyNode nodeToDelete = head;
        int size = getCount();

        for (int i = 0; i < count - 1; i++) {
            nodeToDelete = nodeToDelete.getNextNode();
        }

        DoublyNode previousNode = nodeToDelete.getPreviousNode();
        DoublyNode nextNode = nodeToDelete.getNextNode();
        previousNode.setNextNode(nextNode);
        nextNode.setPreviousNode(previousNode);


        if (count == size) {
            end = previousNode;
        }
    }

    public void deleteAtAnyPosition(int position) {
        if (position > 0 && position <= getCount()) {
            if (position == 1) {
                deleteAtFirst();
            } else if (position == getCount()) {
                deleteAtLast();
            } else {
                deleteNodeFromPosition(position);
            }
        } else {
            System.out.println("Please enter a valid position");
        }
    }


    public int getCount() {
        int size = 0;
        DoublyNode currentNode = head;
        while (currentNode != null) {
            size++;
            if(currentNode.getNextNode() == head){
                break;
            }
            currentNode = currentNode.getNextNode();
        }
        return size;
    }

    public void print(DoublyNode currentNode) {
        if (currentNode != null) {
            System.out.print(currentNode.getData() + " ");
            if(currentNode.getNextNode() == head){
                return;
            } else{
                print(currentNode.getNextNode());
            }
        }
    }

    public void test() {
        System.out.println("previous Node: " + head.getPreviousNode().getData() + " current Node : " + head.getData() + " next node "+head.getNextNode().getData());
    }


    public DoublyNode getHead() {
        return head;
    }

    public DoublyNode getEnd() {
        return end;
    }

    @Override
    public DoublyNode reverseLinkedList(Node nodeHead) {
        DoublyNode currentNode = (DoublyNode) nodeHead;

        while(currentNode != null){

            DoublyNode prevNode = currentNode.getPreviousNode();
            DoublyNode nextNode = currentNode.getNextNode();

            currentNode.setPreviousNode(nextNode);
            currentNode.setNextNode(prevNode);

            currentNode = nextNode;

            if(currentNode == head){
                head = prevNode;
                break;
            }
        }

        DoublyNode temp = head;
        head = end;
        end = temp;

        print(getHead());
        return head;
    }
}
