package leet_code.top_150_interview_questions._9_BinaryTreeGeneral;

import java.util.Objects;

public class _81_PopulatingNextRightPointersInEachNodeII {
    public Node connect(Node root) {
        if(root==null)
            return null;

        if(root.left != null && root.right != null){
            root.left.next = root.right;
        }

        Node t = root;

        t = t.next;

        if(t != null){
            while (t.next != null && t.left==null && t.right==null){
                t = t.next;
            }
            if(root.right != null && (t.left != null || t.right != null)){
                root.right.next = t.left != null ? t.left:t.right;
            } else if (root.left != null && (t.left != null || t.right != null)) {
                root.left.next = t.left != null ? t.left:t.right;
            }
        }


        connect(root.left);
        connect(root.right);

        return root;
    }

    public static void main(String[] args) {
        Integer[] root = {2,1,3,0,7,9,1,2,null,1,0,null,null,8,8,null,null,null,null,7};
        TreeNode.printCompactTree(TreeNode.createTree(root));
        _81_PopulatingNextRightPointersInEachNodeII ob = new  _81_PopulatingNextRightPointersInEachNodeII();
        ob.connect(Node.createTree(root));
    }
}
