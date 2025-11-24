public class MyMain {
    public static void main(String[] args) {
        MyBinarySearchTree bst = new MyBinarySearchTree();
        // 50, 45, 95, 75, 100, 20, 47
        System.out.println(bst.insert(50));
        System.out.println(bst.insert(45));
        System.out.println(bst.insert(95));
        System.out.println(bst.insert(75));
        System.out.println(bst.insert(100));
        System.out.println(bst.insert(20));
        System.out.println(bst.insert(47));
        System.out.println(bst.insert(100));

        System.out.println("bst.search(75) = " + bst.search(75));
        System.out.println("bst.search(80) = " + bst.search(80));

        bst.levelOrderTraversal();


    }
}
