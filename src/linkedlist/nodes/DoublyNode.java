package linkedlist.nodes;

public class DoublyNode {
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

    public void setPreviousNode(DoublyNode previousNode) {
        this.previousNode = previousNode;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DoublyNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(DoublyNode nextNode) {
        this.nextNode = nextNode;
    }
}
