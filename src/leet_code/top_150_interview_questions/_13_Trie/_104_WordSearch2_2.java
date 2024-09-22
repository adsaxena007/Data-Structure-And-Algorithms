package leet_code.top_150_interview_questions._13_Trie;

import leet_code.top_150_interview_questions._9_BinaryTreeGeneral.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _104_WordSearch2_2 {
    TrieNode [][] graph;
    Map<Character, List<TrieNode>> map;
    Integer [][] visited;
    public boolean search(TrieNode root, char[] word, int i) {
        if( root == null || ( i >= word.length) || visited[root.i][root.j] != null){
            return false;
        }

        visited[root.i][root.j] = 1;

        if(i == word.length-1 && root.child[word[i]-'a'] != null && visited[root.child[word[i]-'a'].i][root.child[word[i]-'a'].j] == null)
            return true;

        if(root.child[word[i]-'a'] == null)
            return false;


        return search(root.child[word[i]-'a'], word, i+1);
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        graph  = new TrieNode[m][n];
        map = new HashMap<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(graph[i][j] == null)
                    graph[i][j] = new TrieNode(board[i][j],i,j);

                List<TrieNode> list = map.getOrDefault(board[i][j], new ArrayList<>());
                list.add(graph[i][j]);
                map.put(board[i][j], list);

                if(j+1<n){
                    if(graph[i][j+1] == null)
                        graph[i][j+1] = new TrieNode(board[i][j+1],i,j+1);
                    graph[i][j].child[board[i][j+1] - 'a'] = graph[i][j+1];
                }

                if(j-1>=0){
                    if(graph[i][j-1] == null)
                        graph[i][j-1] = new TrieNode(board[i][j-1],i,j-1);
                    graph[i][j].child[board[i][j-1] - 'a'] = graph[i][j-1];
                }

                if(i-1>=0){
                    if(graph[i-1][j] == null)
                        graph[i-1][j] = new TrieNode(board[i-1][j],i-1,j);
                    graph[i][j].child[board[i-1][j] - 'a'] = graph[i-1][j];
                }

                if(i+1<m){
                    if(graph[i+1][j] == null)
                        graph[i+1][j] = new TrieNode(board[i+1][j],i+1,j);
                    graph[i][j].child[board[i+1][j] - 'a'] = graph[i+1][j];
                }
            }
        }
        for(String word : words){
            char [] str = word.toCharArray();
            if(str.length == 1 && map.containsKey(str[0])){
                result.add(word);
                continue;
            }

            if(map.containsKey(str[0])){
                List<TrieNode> list = map.get(str[0]);
                for(TrieNode t : list){
                    visited = new Integer[m][n];
                    boolean isPresent = search(t, str, 1);
                    if(isPresent){
                        result.add(word);
                        break;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        char [][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        char [][] board = {{'a','b','c'},{'a','e','d'},{'a','f','g'}};
        String [] words = {"eaafgdcba","eaabcdgfa"};
        _104_WordSearch2_2 ob = new _104_WordSearch2_2();
        System.out.println(ob.findWords(board, words));
    }
}

