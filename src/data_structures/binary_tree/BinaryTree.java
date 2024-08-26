package data_structures.binary_tree;

public class BinaryTree {

    Node root;

    public Node createBinaryTree(){
        root = new Node(1);
        root.setLeft(new Node(2));
        root.setRight(new Node(3));
        root.getLeft().setLeft(new Node(4));
        root.getLeft().setRight(new Node(5));

        return root;
    }
}
