package Trees.BinarySearchTree;

public class Node {
    private Node leftNode;
    private int data;
    private Node rightNode;

    public Node(Node leftNode, int data, Node rightNode){
        this.leftNode = leftNode;
        this.data = data;
        this.rightNode = rightNode;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return data + " ";
    }
}
