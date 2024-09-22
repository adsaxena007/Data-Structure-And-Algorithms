package leet_code.top_150_interview_questions._13_Trie;

public class _103_WordDictionary {
    TrieNode root;

    public _103_WordDictionary() {
        root = new TrieNode();
    }

    public void insert(TrieNode root, char[] word, int i){
        if(root == null  || i >= word.length){
            return;
        }


        TrieNode n = root.child[word[i] - 'a'];
        if(n == null){
            n = new TrieNode();
            n.val = word[i];
            if(i==word.length-1)
                n.wordEnd=true;

            root.child[word[i] - 'a'] = n;
            insert(n, word, i+1);
        }else {
            if(i==word.length-1)
                n.wordEnd=true;
            insert(n, word, i+1);
        }
    }

    public void addWord(String word) {
        TrieNode temp = root;
        insert(temp, word.toCharArray(), 0);
    }


    public boolean search(TrieNode root, char[] word, int i) {
        if(root == null || (!root.wordEnd && i == word.length)){
            return false;
        }

        if(root.wordEnd && i == word.length)
            return true;

        if(word[i] == '.'){
            boolean matched = false;
            for(TrieNode n : root.child){
                if(n!=null) {
                    matched = search(n, word, i + 1);
                    if (matched)
                        return true;
                }
            }
            return matched;
        }

        if(root.child[word[i]-'a'] == null)
            return false;

        return search(root.child[word[i]-'a'], word, i+1);
    }

    public boolean search(String word) {
        TrieNode temp = root;
        return search(temp, word.toCharArray(), 0);
    }
}
