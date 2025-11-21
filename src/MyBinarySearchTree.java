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

    //traverse

    // delete
}
