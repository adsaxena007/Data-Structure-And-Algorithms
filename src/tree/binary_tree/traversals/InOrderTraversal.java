package tree.binary_tree.traversals;

import tree.binary_tree.BinaryTree;
import tree.binary_tree.Node;

public class InOrderTraversal {

    public void inOrder(Node root){
        if(root == null)
            return;


        inOrder(root.getLeft());
        System.out.print(root.getData() + " ");
        inOrder(root.getRight());
    }

    public static void main(String[] args) {

        Node binaryTree = new BinaryTree().createBinaryTree();
        InOrderTraversal inOrder  = new InOrderTraversal();
        inOrder.inOrder(binaryTree);


    }
}
