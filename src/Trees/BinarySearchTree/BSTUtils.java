package Trees.BinarySearchTree;

import java.net.ServerSocket;
import java.util.Scanner;

public class BSTUtils {
    private static BSTUtils bstUtils;
    private Node head;
    private Scanner sc = null;

    public static BSTUtils getInstance(){
        if(bstUtils == null){
            bstUtils = new BSTUtils();
        }

        return bstUtils;
    }

    private BSTUtils(){
        sc =new Scanner(System.in);
    }


    public void startExecution(){
        boolean loopIt = true;
        do {
            System.out.println("press 1 for insert a data");
            System.out.println("press 2 for printing all the values in trversal order");

            int options = sc.nextInt();

            switch (options) {
                case 1: {
                    System.out.println("Enter the value");
                    int data = sc.nextInt();
                    insertNode(head,data);
                    break;
                }
                case 2: {
                    printTraversals();
                    break;
                }
            }

            System.out.println("Do you want to continue yes/no?");
            String operateAgain = sc.next();
            loopIt = operateAgain.toLowerCase().charAt(0) == 'y';
        } while (loopIt);
    }

    public Node insertNode(Node node, int data){

        if(node == null){
            node = new Node(null, data, null);
            if(head == null)
                head = node;
            return node;
        }

        if(data <= node.getData()){
            node.setLeftNode(insertNode(node.getLeftNode(), data));
        } else {
            node.setRightNode(insertNode(node.getRightNode(), data));
        }

        return node;
    }

    public void inOrderTraversal(Node node){
        if(node == null)
            return;

        if(node.getLeftNode() != null) inOrderTraversal(node.getLeftNode());
        System.out.print(node.getData()+" ");
        if(node.getRightNode() != null) inOrderTraversal(node.getRightNode());
    }

    public void preOrderTraversal(Node node){
        if(node == null)
            return;


        System.out.print(node.getData()+" ");
        if(node.getLeftNode() != null) preOrderTraversal(node.getLeftNode());
        if(node.getRightNode() != null) preOrderTraversal(node.getRightNode());
    }

    public void postOrderTraversal(Node node){
        if(node == null)
            return;

        if(node.getLeftNode() != null) postOrderTraversal(node.getLeftNode());
        if(node.getRightNode() != null) postOrderTraversal(node.getRightNode());
        System.out.print(node.getData()+" ");
    }

    public Node findKey(Node node, int data){
        if(node == null)
            return node;

        if(node.getData() == data){
            return node;
        }

        if(node.getLeftNode() != null && data < node.getData()){
            return findKey(node.getLeftNode(), data);
        } else if(node.getRightNode() != null && data >= node.getData()){
            return findKey(node.getRightNode(), data);
        }else{
            return node;
        }
    }

    public Node deleteKey(Node root, int data) {
        Node node = root;
        if (node == null) {
            return node;
        } else if (data < node.getData()) {
            node.setLeftNode(deleteKey(node.getLeftNode(), data));
        } else if (data > node.getData()) {
            node.setRightNode(deleteKey(node.getRightNode(), data));
        } else {
            if (node.getLeftNode() == null && node.getRightNode() == null) {
                return null;
            } else if (node.getLeftNode() == null && node.getRightNode() != null) {
                node = node.getRightNode();
                return node;
            } else if (node.getRightNode() == null && node.getLeftNode() != null) {
                node = node.getLeftNode();
                return node;
            } else {
                Node newHeadOfSubTree = findMin(node.getRightNode());
                node.setData(newHeadOfSubTree.getData());
                newHeadOfSubTree.setRightNode(deleteKey(node.getRightNode(), data));

                return node;
            }
        }

        return null;
    }


    private Node findMin(Node node) {
        int minValue = node.getData();
        while(node.getLeftNode()!=null){
            node = node.getLeftNode();
            minValue = node.getData();
        }

        return node;
    }

    public void printTraversals(){
        System.out.println("Inorder traversal ");
        inOrderTraversal(head);
        System.out.println("\npreorder traversal ");
        preOrderTraversal(head);
        System.out.println("\npost order traversal ");
        postOrderTraversal(head);

        System.out.println("\nenter a key, to find it");
        Node node = findKey(head,sc.nextInt());
        if(node == null){
            System.out.println("key doesn't exits : ");
        } else{
            System.out.println("Key exists");
        }
    }

}
