package Trees.BinaryTree;

public class MirrorImageOfBinaryTree {

    public void execute(){
        Node root = new Node(null, 1, null);
        root.setleftChild(new Node(null,3,null));
        root.setrightChild(new Node(null,2,null));
//        root.getleftChild().setleftChild(new Node(null,4,null));
//        root.getleftChild().setrightChild(new Node(null,5,null));
        root.getrightChild().setleftChild(new Node(null,5,null));
        root.getrightChild().setrightChild(new Node(null,4,null));

        printTree(root);
        System.out.println();

        makeMirrorImage(root);
        printTree(root);
    }

    private void printTree(Node node) {
        if(node == null)
            return;

        printTree(node.getleftChild());
        System.out.print(node.getData()+" ");
        printTree(node.getrightChild());

    }

    private void makeMirrorImage(Node node) {

        if(node == null)
            return;

        makeMirrorImage(node.getleftChild());
        makeMirrorImage(node.getrightChild());

        Node temp = node.getleftChild();
        node.setleftChild(node.getrightChild());
        node.setrightChild(temp);
    }
}
