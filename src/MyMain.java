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
        System.out.println(bst.insert(100));
        System.out.println(bst.insert(97));
        System.out.println(bst.insert(96));

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

    }
}
