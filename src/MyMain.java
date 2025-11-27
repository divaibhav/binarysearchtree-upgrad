public class MyMain {
    public static void main(String[] args) {
        MyBinarySearchTree bst = new MyBinarySearchTree();
        // 50, 45, 95, 75, 100, 20, 47
        System.out.println(bst.insert(50));
        System.out.println(bst.insert(45));
        System.out.println(bst.insert(95));
        System.out.println(bst.insert(75));
        System.out.println(bst.insert(110));
        System.out.println(bst.insert(20));
        System.out.println(bst.insert(47));
        System.out.println(bst.insert(105));
        System.out.println(bst.insert(100));
        System.out.println(bst.insert(96));
        System.out.println(bst.insert(98));

        System.out.println("bst.search(75) = " + bst.search(75));
        System.out.println("bst.search(80) = " + bst.search(80));

        bst.levelOrderTraversal();

        System.out.println("InOrder");
        bst.inOrder(bst.getRoot());
        System.out.println();

        System.out.println("Pre Order");
        bst.preOrder(bst.getRoot());
        System.out.println();

        System.out.println("Post Order");
        bst.postOrder(bst.getRoot());
        System.out.println();

        System.out.println("bst.findMin() = " + bst.findMin());
        System.out.println("bst.findMax() = " + bst.findMax());

        MyBinarySearchTree bst1 = new MyBinarySearchTree();
        //bst1.insert(100);
        System.out.println("bst1.findMax() = " + bst1.findMax());
        System.out.println("bst1.findMin() = " + bst1.findMin());

       // System.out.println("bst.getInOrderSuccessor(bst.getRoot().getRight()) = "
       //         + bst.getInOrderSuccessor(bst.getRoot().getRight()));
        System.out.println(bst.getInOrderSuccessor(bst.getRoot().getLeft()));

        System.out.println("-".repeat(80));
        System.out.println("deleting leaf");
        System.out.println("bst.delete(20) = " + bst.delete(20));
        System.out.println("bst.delete(20) = " + bst.delete(20));
        System.out.println("deleting node with single right child");
        System.out.println("bst.delete(45) = " + bst.delete(45));
        bst.insert(25);
        System.out.println("deleting node with single left child");
        System.out.println("bst.delete(47) = " + bst.delete(47));
        System.out.println("level order");
        bst.levelOrderTraversal();
        System.out.println("deleting ");
        System.out.println("bst.delete(95) = " + bst.delete(95));
        bst.levelOrderTraversal();

        System.out.println("bst.delete(50) = " + bst.delete(50));
        bst.levelOrderTraversal();



    }
}
