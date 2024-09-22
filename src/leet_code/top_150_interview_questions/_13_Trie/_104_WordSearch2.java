package leet_code.top_150_interview_questions._13_Trie;

import java.util.*;

public class _104_WordSearch2 {
    Map<Character, TrieNode> map;
    Map<Character, Integer> count;
    int [] letterCount;

    public boolean search(TrieNode root, char[] word, int i) {
        if( root == null || ( i >= word.length) ){
            return false;
        }

        letterCount[word[i]-'a']++;

        if(letterCount[word[i]-'a'] > count.getOrDefault(word[i],-1)){
            return false;
        }

        if(i == word.length-1 && root.child[word[i]-'a'] != null)
            return true;

        if(root.child[word[i]-'a'] == null)
            return false;

        return search(root.child[word[i]-'a'], word, i+1);
    }


    public List<String> findWords(char[][] board, String[] words) {
        if(words.length==0)
            return new ArrayList<>();

        map = new HashMap<>();
        count = new HashMap<>();
        int m = board.length;
        int n = board[0].length;

        for(int i =0; i<m; i++){
            for(int j=0;j<n;j++){
                TrieNode node = map.getOrDefault(board[i][j], new TrieNode());
                count.put( board[i][j] , count.getOrDefault(board[i][j],0) + 1 );
                map.put(board[i][j], node);
                if(j+1<n){
                    TrieNode node2 = map.getOrDefault(board[i][j+1], new TrieNode());
                    map.put(board[i][j+1], node2);
                    node.child[board[i][j+1] - 'a'] = node2;
                }

                if(j-1>=0){
                    TrieNode node2 = map.getOrDefault(board[i][j-1], new TrieNode());
                    map.put(board[i][j-1], node2);
                    node.child[board[i][j-1] - 'a'] = node2;
                }

                if(i-1>=0){
                    TrieNode node2 = map.getOrDefault(board[i-1][j], new TrieNode());
                    map.put(board[i-1][j], node2);
                    node.child[board[i-1][j] - 'a'] = node2;
                }

                if(i+1<m){
                    TrieNode node2 = map.getOrDefault(board[i+1][j], new TrieNode());
                    map.put(board[i+1][j], node2);
                    node.child[board[i+1][j] - 'a'] = node2;
                }
            }
        }
        List<String> result = new ArrayList<>();
        for(String word : words){
            char [] str = word.toCharArray();
            if(str.length == 1 && map.containsKey(str[0])){
                result.add(word);
                continue;
            }

            if(map.containsKey(str[0])){
                letterCount = new int[26];
                letterCount[str[0] - 'a']++;
                boolean isPresent = search(map.get(str[0]), str, 1);
                if(isPresent)
                    result.add(word);
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        char [][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        char [][] board = {{'b'},{'a'},{'b'},{'b'},{'a'}};
        String [] words = {"baa","abba","baab","aba"};
        _104_WordSearch2 ob = new _104_WordSearch2();
        System.out.println(ob.findWords(board, words));
    }
}
