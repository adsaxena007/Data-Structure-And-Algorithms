package leet_code.top_150_interview_questions._12_GraphGenral;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _97_CloneGraph {
    Map<Integer, Node> nodes;
    Node[] clonedNodes;
    public void traverse(Node node){
        if(node==null)
            return;

        nodes.put(node.val, node);
        int i = 0;
        while (i<node.neighbors.size()){
            Node n = node.neighbors.get(i);
            if(!nodes.containsKey(n.val))
                traverse(node.neighbors.get(i));
            i++;
        }
    }

    public Node cloneGraph(Node node) {
        if(node==null)
            return null;

        nodes = new HashMap<>();
        traverse(node);
        clonedNodes = new Node[nodes.size()+1];

        for(Node n : nodes.values()){
            clonedNodes[n.val] = new Node(n.val);
        }


        for( int i = 1; i<clonedNodes.length;i++){
            Node oldNode = nodes.get(i);
            int j=0;
            while (j<oldNode.neighbors.size()){
                Node neighbour = oldNode.neighbors.get(j);
                clonedNodes[i].neighbors.add(clonedNodes[neighbour.val]);
                j++;
            }
        }

        return clonedNodes[node.val];
    }

    public static void main(String[] args) {
        Integer[][] adjList = {
                {2, 4},  // Neighbors of node 1
                {1, 3},  // Neighbors of node 2
                {2, 4},  // Neighbors of node 3
                {1, 3}   // Neighbors of node 4
        };

        Node n = Node.createGraph(adjList);
        _97_CloneGraph ob = new _97_CloneGraph();
        System.out.println(ob.cloneGraph(n).val);
    }


}
