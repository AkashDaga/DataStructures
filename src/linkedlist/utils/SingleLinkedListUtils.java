package linkedlist.utils;

import linkedlist.nodes.SinglyNode;

public class SingleLinkedListUtils {

    private static SingleLinkedListUtils singleLinkedListUtils;
    private SinglyNode head;
    private SinglyNode end;

    static SingleLinkedListUtils getInstance() {
        if (singleLinkedListUtils == null) {
            singleLinkedListUtils = new SingleLinkedListUtils();
        }
        return singleLinkedListUtils;
    }

    public SinglyNode addAtFirst(int key) {
        if (head == null) {
            head = new SinglyNode(key, null);
            end = head;
            return head;
        }

        head = new SinglyNode(key, head);

        return head;
    }

    public SinglyNode addAtLast(int key) {
        if (head == null) {
            head = new SinglyNode(key, null);
            end = head;
            return end;
        }

        SinglyNode newEndNode = new SinglyNode(key, null);
        end.setNextNode(newEndNode);
        end = newEndNode;
        return end;
    }

    public SinglyNode addAtAnyPosition(int key, int position) {
        System.out.println("position "+position);
        if (position == 1) {
            return addAtFirst(key);
        } else if (position == getCount()+1) {
            return addAtLast(key);
        } else {
            SinglyNode currentNode = head;
            for (int i = 0; i < position - 2; i++) {
                currentNode = currentNode.getNextNode();
            }
            System.out.println("currentNode "+currentNode.getData());
            SinglyNode nextNode = currentNode.getNextNode();
            System.out.println("nextNode "+nextNode.getData());
            SinglyNode newNode = new SinglyNode(key, nextNode);
            System.out.println("newNode "+newNode.getData());
            currentNode.setNextNode(newNode);

            return newNode;
        }
    }

    public void deleteAtFirst() {
        if (head == null) {
            System.out.println("There is nothing to delete");
            return;
        }

        SinglyNode newHead = head.getNextNode();
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
        SinglyNode currentNode = head;
        for (int i = 0; i < count - 2; i++) {
            currentNode = currentNode.getNextNode();
        }
        SinglyNode nextNode = currentNode.getNextNode();
        currentNode.setNextNode(nextNode.getNextNode());

        if(count == getCount()){
            end = currentNode;
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
        SinglyNode currentNode = head;
            while (currentNode!= null){
                size++;
                currentNode = currentNode.getNextNode();
            }
        return size;
    }

    public void print(SinglyNode currentNode) {
        if (currentNode != null) {
            System.out.print(currentNode.getData() + " ");
            print(currentNode.getNextNode());
        }
    }

    public SinglyNode getHead() {
        return head;
    }

    public SinglyNode getEnd() {
        return end;
    }
}
