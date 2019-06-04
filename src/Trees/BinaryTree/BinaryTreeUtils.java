package Trees.BinaryTree;

import java.util.*;

public class BinaryTreeUtils {
    private static BinaryTreeUtils binaryTreeUtils;
    int sum = 0;
    private Node head;
    private Stack<Node> pathStack = new Stack<>();
    private Queue<Node> insertionQueue = new LinkedList<>();
    private Queue<Node> orderMaintainQueue = new LinkedList<>();
    private LinkedHashMap<Integer,List<Integer>> verticalOrderMap = new LinkedHashMap<>();
    public static BinaryTreeUtils getInstance(){
        if(binaryTreeUtils == null){
            binaryTreeUtils = new BinaryTreeUtils();
        }
        return binaryTreeUtils;
    }

    public void startExecution(){
        Scanner sc =new Scanner(System.in);
        boolean loopIt = true;
        do {
            System.out.println("press 1 for insert a data");
            System.out.println("press 2 for printing all the values in trversal order");

            int options = sc.nextInt();

            switch (options) {
                case 1: {
                    System.out.println("Enter the value");
                    int data = sc.nextInt();
                    insertNode(insertionQueue.peek(),data);
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

    private Node insertNode(Node node, int data){
        Node newNode = new Node(null, data, null);

        // if node is null create new node and assign it
        if(node == null){
            node = newNode;
        } else if( node.getleftChild() == null){
            // if left address of the node is null then create new node and assign it to the left of root
            node.setleftChild(newNode);
        } else {
            // if right address of the node is null then create new node and assign it to the right of root
            node.setrightChild(newNode);

            // as the root's left is occupied and we have occupied right child also, thus the root should be popped ot
            insertionQueue.remove();
        }

        if(head == null){
            head = newNode;
        }

        // add the new queue into the queue
        insertionQueue.add(newNode);
        System.out.println(insertionQueue);
        return newNode;
    }

    public void preorderTraversal(Node node){
        if(node != null) {
            System.out.print(node.getData() + " ");
            if (node.getleftChild() != null) preorderTraversal(node.getleftChild());
            if (node.getrightChild() != null) preorderTraversal(node.getrightChild());
        }

    }

    public void inorderTraversal(Node node){
        if(node != null){
            if(node.getleftChild() != null) inorderTraversal(node.getleftChild());
            System.out.print(node.getData()+" ");
            if(node.getrightChild() != null) inorderTraversal(node.getrightChild());
        }

    }

    public void postorderTraversal(Node node){
        if(node != null) {
            if (node.getleftChild() != null) postorderTraversal(node.getleftChild());
            if (node.getrightChild() != null) postorderTraversal(node.getrightChild());
            System.out.print(node.getData() + " ");
        }
    }

    public void levelOrderTraversal(){
        if(head == null){
            System.out.println("The tree is empty");
        } else {
            orderMaintainQueue.add(head);

            int size = orderMaintainQueue.size();
            while(size > 0){
                Node node = orderMaintainQueue.remove();
                System.out.print(node.getData()+" ");
                if( node.getleftChild() != null) orderMaintainQueue.add(node.getleftChild());
                if( node.getrightChild() != null) orderMaintainQueue.add(node.getrightChild());

                size = orderMaintainQueue.size();
            }
        }
    }

    public void printNodesLevelByLevel(Node node){
        if(node == null)
            return;

        Queue<Node> levelQueue = new LinkedList<Node>();
        levelQueue.add(node);

        while (true){
            int nodeCount = levelQueue.size();

            if(nodeCount == 0)
                break;

            while (nodeCount > 0){
                Node currentNode = levelQueue.peek();
                System.out.print(currentNode.getData()+ " ");
                levelQueue.remove();

                if(currentNode.getleftChild() != null) levelQueue.add(currentNode.getleftChild());
                if(currentNode.getrightChild() != null) levelQueue.add(currentNode.getrightChild());

                nodeCount --;
            }

            System.out.println();
        }
    }

    public void printNodesInSpiralOrder(Node node){
        if(node == null)
            return;

        Stack<Node> forwardStack = new Stack<>();
        Stack<Node> backwardStack = new Stack<>();

        forwardStack.push(node);

        while(!forwardStack.isEmpty() || !backwardStack.isEmpty()){

            while(!forwardStack.isEmpty()){
                Node currentNode = forwardStack.pop();
                System.out.print(currentNode.getData()+" ");
                if(currentNode.getrightChild()!=null) backwardStack.push(currentNode.getrightChild());
                if(currentNode.getleftChild()!=null) backwardStack.push(currentNode.getleftChild());
            }
            System.out.println();

            while (!backwardStack.isEmpty()){
                Node currentNode = backwardStack.pop();
                System.out.print(currentNode.getData()+" ");
                if(currentNode.getleftChild()!=null) forwardStack.push(currentNode.getleftChild());
                if(currentNode.getrightChild()!=null) forwardStack.push(currentNode.getrightChild());
            }
            System.out.println();
        }
    }

    public LinkedHashMap<Integer, List<Integer>> getVerticalOrderTraversalMap(Node node, int level){

        if(node == null)
            return null;

        List<Integer> list = new ArrayList<>();
        if(verticalOrderMap.containsKey(level)){
            list = verticalOrderMap.get(level);
            list.add(node.getData());
        } else {
            list.add(node.getData());
        }
        verticalOrderMap.put(level,list);

        if(node.getleftChild()!=null){
            getVerticalOrderTraversalMap(node.getleftChild(), level - 1);
        }

        if(node.getrightChild() != null){
            getVerticalOrderTraversalMap(node.getrightChild(), level + 1);
        }

        return verticalOrderMap;
    }

    public void verticalOrderTraversal(Node node, int level){
        LinkedHashMap<Integer,List<Integer>> verticalOrderHashMap = getVerticalOrderTraversalMap(node,level);
        for(Map.Entry<Integer,List<Integer>> entryMap : verticalOrderHashMap.entrySet()){
            for(Integer value : entryMap.getValue()){
                System.out.print(value+" ");
            }
            System.out.println();
        }
    }

    public void printTopViewOfTree(Node node){

        class NodeWithHorizontalDistance{
            public Node node;
            public int horizontalDistance;

            private NodeWithHorizontalDistance(Node node, int horizontalDistance){
                this.node = node;
                this.horizontalDistance = horizontalDistance;
            }
        }

        if(node == null)
            return;

        LinkedHashMap<Integer,Integer> topViewMap = new LinkedHashMap<>();
        Queue<NodeWithHorizontalDistance> orderMaintainQueue = new LinkedList<>();

        orderMaintainQueue.add(new NodeWithHorizontalDistance(node,0));

        while (!orderMaintainQueue.isEmpty()){
            NodeWithHorizontalDistance nodeWithHorizontalDistance = orderMaintainQueue.remove();

            if(!topViewMap.containsKey(nodeWithHorizontalDistance.horizontalDistance)){
                topViewMap.put(nodeWithHorizontalDistance.horizontalDistance, nodeWithHorizontalDistance.node.getData());
            }

            if(nodeWithHorizontalDistance.node.getleftChild()!=null)
            orderMaintainQueue.add(new NodeWithHorizontalDistance(nodeWithHorizontalDistance.node.getleftChild(), nodeWithHorizontalDistance.horizontalDistance-1));

            if(nodeWithHorizontalDistance.node.getrightChild()!=null)
                orderMaintainQueue.add(new NodeWithHorizontalDistance(nodeWithHorizontalDistance.node.getrightChild(), nodeWithHorizontalDistance.horizontalDistance+1));
        }

        for(Map.Entry<Integer,Integer> entryMap : topViewMap.entrySet()){
            System.out.print(entryMap.getValue()+" ");
        }

    }

    public int getHeightOfTheTree(Node node){
        int leftTreeHeight = 0;
        int rightTreeHeight = 0;

        if(node == null)
            return 0;

        if(node.getleftChild() == null && node.getrightChild() == null)
            return 0;

        leftTreeHeight = getHeightOfTheTree(node.getleftChild());
        rightTreeHeight = getHeightOfTheTree(node.getrightChild());

        return 1 + ( leftTreeHeight>rightTreeHeight?leftTreeHeight:rightTreeHeight );

    }

    public int findNumberOfNodes(Node node){
        if(node == null)
            return 0;
        int leftSubTreeNodeCount = findNumberOfNodes(node.getleftChild());
        int rightSubTreeNodeCount = findNumberOfNodes(node.getrightChild());

        return 1+leftSubTreeNodeCount+rightSubTreeNodeCount;
    }

    public int findNumberOfLeafNodes(Node node){
        if(node == null)
            return 0;

        if(node.getleftChild() == null && node.getrightChild() == null)
            return 1;

        return findNumberOfLeafNodes(node.getleftChild()) + findNumberOfLeafNodes(node.getrightChild());
    }

    public int findNumberOfNonLeafNodes(Node node){
        if(node == null)
            return 0;

        if(node.getleftChild() == null && node.getrightChild() == null)
            return 0;

        return 1+findNumberOfNonLeafNodes(node.getleftChild()) + findNumberOfNonLeafNodes(node.getrightChild());
    }

    public Node lowestCommonAncestar(Node root, int firstNdoeData, int secondNodeData){
        if(root == null)
            return null;

        if(root.getData() == firstNdoeData || root.getData() == secondNodeData)
            return root;

        Node left = lowestCommonAncestar(root.getleftChild(), firstNdoeData, secondNodeData);
        Node right = lowestCommonAncestar(root.getrightChild(), firstNdoeData, secondNodeData);

        if(left != null && right != null)
            return root;
        else
            return left != null ? left : right;
    }


    public void printTraversals(){

        new MaximumPathSum().execute();



        System.out.println("Pre Order Traversal ");
        preorderTraversal(head);

        System.out.println("\nIn Order Traversal ");
        inorderTraversal(head);

        System.out.println("\nPost Order Traversal ");
        postorderTraversal(head);

        System.out.println("\nlevel order traversal");
        levelOrderTraversal();

        System.out.println("\nvertical order traversal");
        verticalOrderTraversal(head,0);

        System.out.println("\nprint tree level by level");
        printNodesLevelByLevel(head);

        System.out.println("\nprint in a spiral fashion");
        printNodesInSpiralOrder(head);

        System.out.println("\nprint top view of the tree");
        printTopViewOfTree(head);

        System.out.println("\ntotal number of nodes in the tree : "+findNumberOfNodes(head));

        System.out.println("\nnumber of leaf nodes in the tree : "+findNumberOfLeafNodes(head));

        System.out.println("\nnumber of non leaf nodes in the tree : "+findNumberOfNonLeafNodes(head));

        System.out.println("\nlowest common ancestar of Binary Tree : " + lowestCommonAncestar(head, 4,5));

        System.out.println("\nHeight of the tree "+getHeightOfTheTree(head));
    }


    public Node getHead(){
        return this.head;
    }

}
