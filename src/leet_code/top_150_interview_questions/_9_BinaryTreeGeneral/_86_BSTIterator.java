package leet_code.top_150_interview_questions._9_BinaryTreeGeneral;

import java.util.Stack;

public class _86_BSTIterator {

    TreeNode head;

    private TreeNode currentElement;

    private Stack<TreeNode> stack;

    public _86_BSTIterator(TreeNode root) {
        head=root;
        currentElement=root;
        stack=new Stack<>();
    }

    public int next() {
        if(stack.empty()){
            while (currentElement!=null){
                stack.push(currentElement);
                currentElement=currentElement.left;
            }
        }
        TreeNode node = stack.pop();
        int val = node.val;
        if(node.right!=null){
            node=node.right;
            while (node!=null){
                stack.push(node);
                node=node.left;
            }
        }
        return val;
    }

    public boolean hasNext() {
        return !(stack.empty() && currentElement==null);
    }
}
