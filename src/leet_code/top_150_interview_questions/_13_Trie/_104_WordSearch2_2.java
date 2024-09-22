package leet_code.top_150_interview_questions._13_Trie;

import leet_code.top_150_interview_questions._9_BinaryTreeGeneral.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _104_WordSearch2_2 {
    TrieNode trie;
    List<String> result;

    public void insertIntoTrie(TrieNode root, char[] word, int i){
        if(i >= word.length || root == null)
            return;

        if(root.child[word[i]-'a'] == null){
            root.child[word[i]-'a'] = new TrieNode(word[i]);
        }

        if(i == word.length-1)
            root.child[word[i]-'a'].wordEnd = true;

        insertIntoTrie(root.child[word[i]-'a'], word, i+1);
    }

    public void traverse(TrieNode root, char [][] board, int i, int j, int m, int n, StringBuilder sb, int [][] visited ){
        if(i<0 || i>=m || j<0 || j>=n || visited[i][j] == 1)
            return;

        if(root.child[board[i][j] - 'a'] != null){
            visited[i][j] = 1;

            root = root.child[board[i][j]-'a'];
            sb.append(board[i][j]);


            if(root.wordEnd && !result.contains(sb.toString())){
                result.add(sb.toString());
            }

            traverse(root, board,i+1, j, m, n, sb, visited);
            traverse(root, board,i-1, j, m, n, sb, visited);
            traverse(root, board,i, j+1, m, n, sb, visited);
            traverse(root, board,i, j-1, m, n, sb, visited);

            sb.deleteCharAt(sb.length()-1);
            visited[i][j] = 0;
        }



    }

    public List<String> findWords(char[][] board, String[] words) {
        result = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        trie = new TrieNode();


        for(String w : words){
            TrieNode t = trie;
            insertIntoTrie(t, w.toCharArray(), 0);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                TrieNode t = trie;
                traverse(t, board, i, j, m, n, new StringBuilder(), new int[m][n]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        char [][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
//        char [][] board = {{'a','b','c'},{'a','e','d'},{'a','f','g'}};
//        String [] words = {"abcdefg","gfedcbaaa","eaabcdgfa","befa","dgc","ade"};
//        char [][] board = {{'b'},{'a'},{'b'},{'b'},{'a'}};
//        String [] words = {"baa","abba","baab","aba"};

        char [][] board = {{'a','b'},{'a','a'}};
        String [] words = {"aba","baa","bab","aaab","aaa","aaaa","aaba"};
        _104_WordSearch2_2 ob = new _104_WordSearch2_2();
        System.out.println(ob.findWords(board, words));
    }
}

