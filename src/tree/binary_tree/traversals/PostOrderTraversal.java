package tree.binary_tree.traversals;

import tree.binary_tree.BinaryTree;
import tree.binary_tree.Node;

public class PostOrderTraversal {

    public void postOrder(Node root){
        if(root == null)
            return;


        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getData() + " ");
    }

    public static void main(String[] args) {

        Node binaryTree = new BinaryTree().createBinaryTree();
        PostOrderTraversal postOrder  = new PostOrderTraversal();
        postOrder.postOrder(binaryTree);


    }
}
