package leet_code.top_150_interview_questions._12_GraphGenral;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
    public int val;
    public int indexI;
    public int indexJ;
    public List<Node> next;
    public List<Node> neighbors;

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int indexI, int indexJ){
        this.indexI = indexI;
        this.indexJ = indexJ;
        neighbors = new ArrayList<Node>();
        next = new ArrayList<>();
    }

    public static Node createGraph(Integer[][] adjList) {
        if (adjList == null || adjList.length == 0) return null;

        // Map to store the nodes with their corresponding values
        Map<Integer, Node> nodesMap = new HashMap<>();

        // Create all nodes
        for (int i = 1; i <= adjList.length; i++) {
            nodesMap.put(i, new Node(i));
        }

        // Connect the nodes based on the adjacency list
        for (int i = 0; i < adjList.length; i++) {
            Node currentNode = nodesMap.get(i + 1);  // Node indices are 1-based
            for (int neighborVal : adjList[i]) {
                currentNode.neighbors.add(nodesMap.get(neighborVal));
            }
        }

        // Return the first node (root of the graph)
        return nodesMap.get(1);
    }
}
