package data_structures.trees.binary_tree.traversals;

import data_structures.trees.binary_tree.BinaryTree;
import data_structures.trees.binary_tree.Node;

public class PreOrderTraversal {

    public void preOrder(Node root){
        if(root == null)
            return;

        System.out.print(root.getData() + " ");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public static void main(String[] args) {

        Node binaryTree = new BinaryTree().createBinaryTree();
        PreOrderTraversal preOrder  = new PreOrderTraversal();
        preOrder.preOrder(binaryTree);


    }
}
