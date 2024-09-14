package leet_code.top_150_interview_questions._10_BinaryTreeBFS;

import leet_code.top_150_interview_questions._9_BinaryTreeGeneral.TreeNode;


public class Data{
    int level;
    TreeNode node;

    public Data(TreeNode node, int level){
        this.level = level;
        this.node = node;
    }
}
