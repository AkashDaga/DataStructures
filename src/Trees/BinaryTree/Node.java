package Trees.BinaryTree;

public class Node {
    private Node leftChild;
    private int data;
    private Node rightChild;

    public Node(Node leftChild, int data, Node rightChild) {
        this.leftChild = leftChild;
        this.data = data;
        this.rightChild = rightChild;
    }

    public Node getleftChild() {
        return leftChild;
    }

    public void setleftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getrightChild() {
        return rightChild;
    }

    public void setrightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return data+"";
    }
}
