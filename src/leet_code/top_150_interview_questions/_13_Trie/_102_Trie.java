package leet_code.top_150_interview_questions._13_Trie;



public class _102_Trie {
    TrieNode root;

    public _102_Trie() {
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
    
    public void insert(String word) {
        TrieNode temp = root;
        insert(temp, word.toCharArray(), 0);
    }


    public boolean search(TrieNode root, char[] word, int i) {
        if(root == null || (!root.wordEnd && i == word.length)){
            return false;
        }

        if(root.wordEnd && i == word.length)
            return true;

        if(root.child[word[i]-'a'] == null)
            return false;

        return search(root.child[word[i]-'a'], word, i+1);
    }
    
    public boolean search(String word) {
        TrieNode temp = root;
        return search(temp, word.toCharArray(), 0);
    }


    public boolean startsWith(TrieNode root, char[] word, int i) {
        if(root == null || i > word.length){
            return false;
        }

        if(i == word.length)
            return true;

        if(root.child[word[i]-'a'] == null)
            return false;

        return startsWith(root.child[word[i]-'a'], word, i+1);
    }


    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        return startsWith(temp, prefix.toCharArray(), 0);
    }

    public static void main(String[] args) {
        _102_Trie t = new _102_Trie();
        t.insert("ab");

        System.out.println(t.search("ab"));

        t.insert("abc");
        System.out.println(t.search("abc"));
        System.out.println(t.startsWith("abc"));
    }
}