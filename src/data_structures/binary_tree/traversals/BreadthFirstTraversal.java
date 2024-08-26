package data_structures.binary_tree.traversals;

import data_structures.binary_tree.BinaryTree;
import data_structures.binary_tree.Node;

public class BreadthFirstTraversal {

    public int getHeight(Node root){
        if(root == null)
             return 0;

        return Math.max(getHeight(root.getLeft()) +1, getHeight(root.getRight())+1);
    }

    public void printBreadthFirstTraversal(Node root){
        if(root == null )
            return;

        int height = getHeight(root);

        for(int i =1 ; i<=height; i++){
            printCurrentLevel(root, i);
        }

    }

    public void printCurrentLevel(Node root, int level){
        if(root  == null)
            return;

        if(level==1){
            System.out.println(root.getData() + " ");
        }
        if(level>1){
            printCurrentLevel(root.getLeft(), level-1);
            printCurrentLevel(root.getRight(), level-1);
        }

    }

    public static void main(String[] args) {

        Node binaryTree = new BinaryTree().createBinaryTree();
        BreadthFirstTraversal bsf = new BreadthFirstTraversal();

        bsf.printBreadthFirstTraversal(binaryTree);



    }
}
