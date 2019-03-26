package Trees.BinaryTree;

public class MaximumPathSum {
    public void execute(){
        Node root = new Node(null,-15,null);
        root.setleftChild(new Node(null,5,null));
        root.setrightChild(new Node(null,6,null));
        root.getleftChild().setleftChild(new Node(null,-8,null));
        root.getleftChild().setrightChild(new Node(null,1,null));
        root.getleftChild().getleftChild().setleftChild(new Node(null,2,null));
        root.getleftChild().getleftChild().setrightChild(new Node(null,6,null));
        root.getrightChild().setleftChild(new Node(null, 3, null));
        root.getrightChild().setrightChild(new Node(null,9,null));
        root.getrightChild().getrightChild().setrightChild(new Node(null, 0, null));
        root.getrightChild().getrightChild().getrightChild().setleftChild(new Node(null, 4, null));
        root.getrightChild().getrightChild().getrightChild().setrightChild(new Node(null,-1,null));
        root.getrightChild().getrightChild().getrightChild().getrightChild().setleftChild(new Node(null, 10, null));

        System.out.println("\nmaximum sum path of from a node to leaf node "+ maximumPathSum(root));
    }

    public int maximumPathSumHelper(Node node, UserResource resource){
        if(node ==  null) {
            System.out.println("Current Node is null returning 0");
            return 0;
        }

        System.out.println("Calculate left subtree of node "+node.getData()+" whose left child is "+node.getleftChild()+" resource file values is "+resource.value);
        int leftSubTreeSum = maximumPathSumHelper(node.getleftChild(),resource);
        System.out.println("leftSubTreeSum for node "+ node.getData()+" is "+leftSubTreeSum);

        System.out.println("Calculate right subtree of node "+node.getData()+" whose right child is "+node.getrightChild()+" resource file values is "+resource.value);
        int rightSubTreeSum = maximumPathSumHelper(node.getrightChild(),resource);
        System.out.println("rightSubTreeSum for node "+ node.getData()+" is "+rightSubTreeSum);

        boolean isBothTheChildIsNotNull = node.getleftChild() != null && node.getrightChild() != null;
        System.out.println("is both the child is not null "+isBothTheChildIsNotNull);

        if(isBothTheChildIsNotNull){

            System.out.println("resource value is "+resource.value);
            System.out.println("sum of leftSubTreeSum "+ leftSubTreeSum+" rightSubTreeSum "+rightSubTreeSum+" node.getData() "+node.getData());

            System.out.println("resource updating resource value taking max of resource value or leftSubTreeSum+rightSubTreeSum+node.getData()"+
                    Math.max(resource.value, leftSubTreeSum+rightSubTreeSum+node.getData()));
            resource.value = Math.max(resource.value, leftSubTreeSum+rightSubTreeSum+node.getData());

            return Math.max(leftSubTreeSum,rightSubTreeSum) + node.getData();
        }


        if(node.getleftChild() == null){
            int returnedValue = rightSubTreeSum + node.getData();
            System.out.println("left child is null so returning sum of rigtSUbTreeSum and node.getData() "+returnedValue);
            return returnedValue;
        } else {
            int returnedValue = leftSubTreeSum + node.getData();
            System.out.println("right child is null so returning sum of leftSUbTreeSum and node.getData() "+returnedValue);
            return returnedValue;
        }
    }

    public int maximumPathSum(Node node){
        UserResource resource = new UserResource();
        resource.value = Integer.MIN_VALUE;
        maximumPathSumHelper(node,resource);
        return resource.value;
    }
}
