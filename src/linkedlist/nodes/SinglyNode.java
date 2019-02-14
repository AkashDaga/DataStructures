package linkedlist.nodes;

public class SinglyNode extends Node{

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

    @Override
    public void setNextNode(Node nextNode)  {
        this.nextNode = (SinglyNode) nextNode;
    }

    @Override
    public Node getPreviousNode() {
        return null;
    }

    @Override
    public void setPreviousNode(Node prevNode) {

    }
}
