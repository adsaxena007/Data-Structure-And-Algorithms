package leet_code.top_150_interview_questions._13_Trie;

import java.util.ArrayList;
import java.util.List;

public class Node {
    char val;
    int i;
    int j;
    List<Node> neighbours;

    public Node(char val, int i, int j){
        this.val = val;
        this.i = i;
        this.j = j;
        neighbours = new ArrayList<>();
    }
}
