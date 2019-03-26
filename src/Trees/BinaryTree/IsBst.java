package Trees.BinaryTree;

public class IsBst {

    public void execute(){
        Node root = new Node(null,4,null);
        root.setleftChild(new Node(null, 2, null ));
        root.setrightChild(new Node(null, 5, null ));
        root.getleftChild().setleftChild(new Node(null,1 , null ));
        root.getleftChild().setrightChild(new Node(null, 3, null ));
//        root.getrightChild().setleftChild(new Node(null,1 , null ));

        System.out.println(" is the given Binary Tree, Binary Search Tree : "+ isBst(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
    }

    private Boolean isBst(Node node, int minValue, int maxValue) {
        if(node == null)
        return true;

        if(node.getData() < minValue || node.getData() > maxValue)
            return false;

        return isBst(node.getleftChild(),minValue, node.getData()) && isBst(node.getrightChild(),node.getData(),maxValue);
    }
}
