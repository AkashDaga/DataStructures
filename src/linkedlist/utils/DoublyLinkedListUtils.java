package linkedlist.utils;

import linkedlist.nodes.DoublyNode;
import linkedlist.nodes.Node;

public class DoublyLinkedListUtils extends BaseUtils{
    private static DoublyLinkedListUtils doublyLinkedListUtils;
    private DoublyNode head;
    private DoublyNode end;

    static DoublyLinkedListUtils getInstance() {
        if (doublyLinkedListUtils == null) {
            doublyLinkedListUtils = new DoublyLinkedListUtils();
        }
        return doublyLinkedListUtils;
    }

    public DoublyNode addAtFirst(int key) {
        if (head == null) {
            head = new DoublyNode(null, key, null);
            end = head;
            return head;
        }

        head = new DoublyNode(null, key, head);

        return head;
    }

    public DoublyNode addAtLast(int key) {
        if (head == null) {
            head = new DoublyNode(null, key, null);
            end = head;
            return end;
        }

        DoublyNode newEndNode = new DoublyNode(end, key, null);
        end.setNextNode(newEndNode);
        end = newEndNode;
        return end;
    }

    public DoublyNode addAtAnyPosition(int key, int position) {
        System.out.println("position "+position);
        if (position == 1) {
            return addAtFirst(key);
        } else if (position == getCount()+1) {
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

        DoublyNode newHead = head.getNextNode();
        head.setNextNode(null);
        head = newHead;
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
        for (int i = 0; i < count - 1; i++) {
            nodeToDelete = nodeToDelete.getNextNode();
        }

        DoublyNode previousNode = nodeToDelete.getPreviousNode();
        DoublyNode nextNode = nodeToDelete.getNextNode();
        previousNode.setNextNode(nextNode);
        if(nextNode!=null){
            nextNode.setPreviousNode(previousNode);
        }


        if(count == getCount()){
            end = previousNode;
        }
    }

    public void deleteAtAnyPosition(int position){
        if(position > 0 && position <= getCount()){
            if(position == 1){
                deleteAtFirst();
            } else if(position == getCount()) {
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
        while (currentNode!= null){
            size++;
            currentNode = currentNode.getNextNode();
        }
        return size;
    }

    public void print(DoublyNode currentNode) {
        if (currentNode != null) {
            System.out.print(currentNode.getData() + " ");
            print(currentNode.getNextNode());
        }
    }

    public void printThePreviousElement(int position){
        DoublyNode currentNode = head;
        for(int i = 0; i < position - 1; i++){
            currentNode = currentNode.getNextNode();
        }

        DoublyNode previousNode = currentNode.getPreviousNode();
        DoublyNode nextNode = currentNode.getNextNode();
        if(nextNode != null){
            System.out.println("previous Node: "+previousNode.getData()+" current Node : "+currentNode.getData()+" next node"+nextNode.getData() );
        } else{
            System.out.println("previous Node: "+previousNode.getData()+" current Node : "+currentNode.getData()+" next node is null" );
        }
    }


    public DoublyNode getHead() {
        return head;
    }

    public DoublyNode getEnd() {
        return end;
    }

    @Override
    public DoublyNode reverseLinkedList(Node node) {
        DoublyNode currentNode = (DoublyNode) node;
        DoublyNode prevNode = null;
        DoublyNode nextNode = null;

        while(currentNode != null){
            nextNode = currentNode.getNextNode();
            prevNode = currentNode.getPreviousNode();

            currentNode.setPreviousNode(nextNode);
            currentNode.setNextNode(prevNode);

            if(nextNode == null){
                head = currentNode;
            }
            if(prevNode == null){
                end = currentNode;
            }

            currentNode = nextNode;
        }

        print(getHead());
        return head;

    }
}
