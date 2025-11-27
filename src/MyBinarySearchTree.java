import java.util.LinkedList;
import java.util.Queue;

public class MyBinarySearchTree {
    private TreeNode root;
    //getter

    public TreeNode getRoot() {
        return root;
    }

    //insert
    public boolean insert(int element){
        TreeNode treeNode = new TreeNode(element);
        if(root == null){
            root = treeNode;
        }else{
            TreeNode temp = root;
            TreeNode parent = null;
            while(temp != null){
                parent = temp;
                if(element < temp.getData()){
                    temp = temp.getLeft();
                }else{
                    temp = temp.getRight();
                }
            }
            if(parent.getData() == element ){
                return false;
            } else if (element < parent.getData()) {
                //set new node as left child of parent
                parent.setLeft(treeNode);
            } else{
                parent.setRight(treeNode);
            }
        }
        return true;
    }
    // search
    public boolean search(int key){
        if(root != null){
            TreeNode temp = root;
            // traverse and check
            while(temp != null){
                if(temp.getData() == key){
                    return true;
                } else if (key < temp.getData()) {
                    temp = temp.getLeft();
                } else{
                    temp = temp.getRight();
                }
            }
        }
       return false;
    }

    //traverse

    //level order
    public void levelOrderTraversal(){
        if(root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            // add root to queue
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                System.out.println(temp.getData());
                if (temp.getLeft() != null) {
                    queue.offer(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    queue.offer(temp.getRight());
                }
            }
        }
    }
    //in order
    public void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        inOrder(node.getLeft());
        System.out.print(node.getData() + ", ");
        inOrder(node.getRight());
    }
    //pre order
    public void preOrder(TreeNode node){
        if(node != null){
            System.out.print(node.getData() + ", ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }
    // post order
    public void postOrder(TreeNode node){
        if(node != null){
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getData() + ", ");
        }
    }

    // delete

    // the findMin minimum and findMax maximum element form bst

    public int findMin(){
        TreeNode temp = root;
        TreeNode previous = null;

        while (temp != null){
            previous = temp ;
            temp = temp.getLeft();
        }
        if(previous != null){
            return previous.getData();
        }
        return 0;
    }

    public int findMax(){
        TreeNode temp = root;
        TreeNode previous = null;
        while (temp != null){
            previous = temp;
            temp = temp.getRight();
        }
        if(previous != null){
            return previous.getData();
        }
        return 0;
    }

    // boolean isLeaf(TreeNode node)
    public boolean isLeaf(TreeNode node){
        if(node == null){
            return false;
        }
        return node.getLeft() == null && node.getRight() == null;

    }
    // boolean hasLeftChild(TreeNode node)
    public boolean hasLeftChild(TreeNode node){
        if(node != null){
            if(node.getLeft() != null){
                return true;
            }
        }
        return false;
    }

    // boolean hasRightChild(TreeNode node)
    public boolean hasRightChild(TreeNode node){
        if(node != null && node.getRight() != null){
            return true;
        }
        return false;
    }
    // boolean hasTwoChildren(TreeNode node)
    public boolean hasTwoChildren(TreeNode node){
        if(node != null) {
            if(node.getLeft() != null && node.getRight() != null){
                return true;
            }
        }
        return false;
    }
    public TreeNode getInOrderSuccessor(TreeNode node){
       if(node != null){
           TreeNode inOrderSuccessor = null;
           if(hasRightChild(node)){
               node = node.getRight();
               while(node != null){
                   inOrderSuccessor = node;
                   node = node.getLeft();
               }
           }
           return inOrderSuccessor;
       }
       return null;
        //check having right child,
        // check having left child
        // check having left child till you found
        // null
    }

    public boolean delete(int value){
        //search the deleting node
        TreeNode deletingNode = root;
        TreeNode parent = null;
        while(deletingNode != null && deletingNode.getData() != value){
            parent = deletingNode;
            if(value < deletingNode.getData()){
                deletingNode = deletingNode.getLeft();
            }else {
                deletingNode = deletingNode.getRight();
            }
        }
        if(deletingNode != null){
            // found the deleting node
            // case 1 leaf node
            if(isLeaf(deletingNode)){
                //if the deleting node is root node
                if(parent != null) {
                    if (isLeftChild(deletingNode, parent)) {
                        parent.setLeft(null);
                    } else {
                        parent.setRight(null);
                    }
                }else{
                    root = null;
                }
                return true;
            } else if (hasTwoChildren(deletingNode)) {
                TreeNode inOrderSuccessor = getInOrderSuccessor(deletingNode);
                //getParent(TreeNode node)
                TreeNode inOrderParent = getParent(inOrderSuccessor);
                //call deletion on in order successor
                if(delete(inOrderSuccessor.getData())){
                    inOrderSuccessor.setLeft(deletingNode.getLeft());
                    inOrderSuccessor.setRight(deletingNode.getRight());
                    //if deleting node is root
                    if(parent != null){
                            if(isLeftChild(inOrderSuccessor, parent)){
                                parent.setLeft(inOrderSuccessor);
                            }else{
                                parent.setRight(inOrderSuccessor);
                            }
                    }else{
                        //root case
                        root = inOrderSuccessor;
                    }
                }
                /*if(isLeftChild(inOrderSuccessor, inOrderParent)){
                    inOrderParent.setLeft(null);
                }else{
                    inOrderParent.setRight(null);
                }
                if(isLeftChild(deletingNode, parent)){
                    parent.setLeft(inOrderSuccessor);
                }else {
                    parent.setRight(inOrderSuccessor);
                }*/
                return true;

                // having right child


            } else if (hasLeftChild(deletingNode)) {
               //check whether deleting node is left child or right child
                //root case
                if(parent != null) {
                    if (isLeftChild(deletingNode, parent)) {
                        //left child of parent
                        parent.setLeft(deletingNode.getLeft());
                    } else {
                        parent.setRight(deletingNode.getLeft());
                    }
                }else{
                   root = deletingNode.getLeft();
                }
               return true;
            } else if (hasRightChild(deletingNode)) {
                if(parent != null) {
                    if (isLeftChild(deletingNode, parent)) {
                        parent.setLeft(deletingNode.getRight());
                    } else {
                        parent.setRight(deletingNode.getRight());
                    }
                }else{
                    root = deletingNode.getRight();
                }
                return true;
            }

        }
        return false;
    }

    private TreeNode getParent(TreeNode node) {
        if(node != null){
            TreeNode temp = root;
            TreeNode parent = null;
            while (temp != null && temp.getData() != node.getData()){
                parent = temp;
                if(node.getData() < temp.getData()){
                    temp = temp.getLeft();
                }else{
                    temp = temp.getRight();
                }
            }
            return parent;
        }
        return null;
    }

    private static boolean isLeftChild(TreeNode deletingNode, TreeNode parent) {
        return deletingNode.getData() < parent.getData();
    }


}
