package linkedlist.nodes;

public class SinglyNode{

    private int data;
    private SinglyNode nextNode;

    public SinglyNode(int data, SinglyNode nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public SinglyNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(SinglyNode nextNode) {
        this.nextNode = nextNode;
    }
}
