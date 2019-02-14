package linkedlist.nodes;

public abstract class Node {
    private Node nextNode;
    private Node previousNode;
    private int data;

    public abstract Node getNextNode();

    public abstract Node getPreviousNode();

    public abstract  int getData();

    public abstract void setNextNode(Node nextNode);

    public abstract void setPreviousNode(Node prevNode);

    public abstract void setData(int data);
}
