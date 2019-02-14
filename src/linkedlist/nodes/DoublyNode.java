package linkedlist.nodes;

public class DoublyNode extends Node{
    private DoublyNode previousNode;
    private int data;
    private DoublyNode nextNode;

    public DoublyNode(DoublyNode previousNode, int data, DoublyNode nextNode) {
        this.previousNode = previousNode;
        this.data = data;
        this.nextNode = nextNode;
    }

    public DoublyNode getPreviousNode() {
        return previousNode;
    }

    public int getData() {
        return data;
    }

    @Override
    public void setNextNode(Node nextNode) {
        this.nextNode = (DoublyNode) nextNode;
    }

    @Override
    public void setPreviousNode(Node prevNode) {
            this.previousNode = (DoublyNode) prevNode;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DoublyNode getNextNode() {
        return nextNode;
    }
}
