package Trees.BinaryTree;

class MinMax{
    Node node;
    boolean isBst;
    int min;
    int max;
    int size;

    MinMax(Node node){
        this.node = node;
        this.isBst = true;
        this.min = Integer.MAX_VALUE;
        this.max = Integer.MIN_VALUE;
        this.size = 0;
    }
}

public class LargestBst {
    public void exceute(){
        Node root = new Node(null,60,null);
        root.setleftChild(new Node(null, 65, null));
        root.setrightChild(new Node(null, 70, null));
        root.getleftChild().setleftChild(new Node(null, 50, null));
        largestBst(root);
    }

    public void largestBst(Node node){
        MinMax minMaxObj = largest(node);

        if(minMaxObj.size == 0){
            System.out.println("BST is not there inside this Binary Tree");
        } else {
            System.out.println("The Size of the BST inside BT is "+ minMaxObj.size);
            printTheTree(minMaxObj.node);
        }

    }

    private void printTheTree(Node node) {
        if(node == null)
            return;

        printTheTree(node.getleftChild());
        System.out.print(node.getData()+ " ");
        printTheTree(node.getrightChild());
    }

    private MinMax largest(Node node) {
        if(node == null){
            return new MinMax(node);
        }

        // do the post order traversal
        MinMax leftMinMax = largest(node.getleftChild());
        MinMax righttMinMax = largest(node.getrightChild());

        MinMax obj = new MinMax(node);

        if(!leftMinMax.isBst || !righttMinMax.isBst || (leftMinMax.max > node.getData() || righttMinMax.min <= node.getData())){
            obj.isBst = false;
            obj.size = Math.max(leftMinMax.size,righttMinMax.size);

            return obj;
        }

        obj.isBst = true;
        obj.size = leftMinMax.size + righttMinMax.size + 1;

        obj.min = node.getleftChild() != null ? leftMinMax.min : node.getData();
        obj.max = node.getrightChild() != null ? righttMinMax.max : node.getData();

        return obj;
    }
}
