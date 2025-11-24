import java.util.LinkedList;
import java.util.Queue;

public class MyBinarySearchTree {
    private TreeNode root;
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
        Queue<TreeNode> queue = new LinkedList<>();
        // add root to queue
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.println(temp.getData());
            if(temp.getLeft() != null) {
                queue.offer(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.offer(temp.getRight());
            }
        }
    }

    // delete
}
