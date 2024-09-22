package leet_code.top_150_interview_questions._13_Trie;

import leet_code.top_150_interview_questions._9_BinaryTreeGeneral.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class TrieNode {
    char val;
    boolean wordEnd;
    TrieNode []child;
    int i;
    int j;

    public TrieNode(){
        child = new TrieNode[26];
        wordEnd=false;
    }

    public TrieNode(char val){
        this.val = val;
        child = new TrieNode[26];
        wordEnd=false;
    }

    public TrieNode(char val, int i, int j){
        this.val = val;
        this.i = i;
        this.j = j;
        child = new TrieNode[26];
        wordEnd=false;
    }
}
