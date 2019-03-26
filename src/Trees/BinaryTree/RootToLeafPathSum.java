package Trees.BinaryTree;

import java.util.ArrayList;

public class RootToLeafPathSum {
    int sum = 0;
    ArrayList<Integer> pathList = new ArrayList<>();

    public void execute(){
        Node root = new Node(null,1,null);
        root.setleftChild(new Node(null, 2, null ));
        root.setrightChild(new Node(null, 3, null ));
        root.getleftChild().setleftChild(new Node(null, 4, null ));
        root.getleftChild().setrightChild(new Node(null, 5, null ));
        root.getrightChild().setleftChild(new Node(null, 6, null ));
        root.getrightChild().setrightChild(new Node(null, 4, null ));
        root.getleftChild().getleftChild().setleftChild(new Node(null, 8, null ));
        root.getleftChild().getleftChild().setrightChild(new Node(null, 9, null ));
        root.getrightChild().getleftChild().setleftChild(new Node(null, 10, null ));
        root.getrightChild().getleftChild().setrightChild(new Node(null, 11, null ));
        root.getrightChild().getrightChild().setrightChild(new Node(null, 12, null ));


        System.out.println(" root to leaf path sum equals to 20 is ");
        rootToLeafPathSumEqualsToAGivenNumber(root,20);
    }

    public void rootToLeafPathSumEqualsToAGivenNumber(Node node,int key){
        if(node == null)
            return;

        pathList.add(node.getData());

        rootToLeafPathSumEqualsToAGivenNumber(node.getleftChild(),key);
        rootToLeafPathSumEqualsToAGivenNumber(node.getrightChild(),key);

        int sum = 0;
        for( int i = pathList.size() - 1; i >= 0; i-- ){
            sum = sum + pathList.get(i);

            if(sum == key){
                printList(i);
            }
        }
        pathList.remove(pathList.size()-1);
    }

    private void printList(int n) {
        for( int i = n; i <= pathList.size()-1; i++){
            System.out.print(pathList.get(i)+" ");
        }
        System.out.println();
    }
}
