package leet_code.top_150_interview_questions._12_GraphGenral;


import java.util.*;

class GraphNode2{
    int val;
    List<GraphNode2> neighbours;

    public GraphNode2(int val){
        this.val = val;
        neighbours = new ArrayList<>();
    }
}

public class _99_CourseSchedule1 {
    Stack<GraphNode2> visited;
    Boolean [] hasLoop;

    boolean doesCurrentNodeHaveLoop;

    Map<Integer, GraphNode2> graph;
    public void traverse(GraphNode2 node){
        if(node==null)
            return;

        if(hasLoop[node.val]!=null && hasLoop[node.val]){
            return;
        }

        if(visited.contains(node)){
            hasLoop[node.val] = true;
            return;
        } else {
            hasLoop[node.val] = false;
        }

        visited.push(node);



        int i = 0;
        while (i < node.neighbours.size()) {
            GraphNode2 n = node.neighbours.get(i);
            if(visited.contains(n) || (hasLoop[n.val] != null && hasLoop[n.val])) {
                hasLoop[node.val] = true;
                return;
            }

            if(hasLoop[n.val] == null)
                traverse(n);
            i++;
        }



        visited.pop();
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new HashMap<>();

        for(int[] prerequisite : prerequisites){
            GraphNode2 n1 = graph.getOrDefault(prerequisite[1],new GraphNode2(prerequisite[1]));
            graph.put(prerequisite[1], n1);
            GraphNode2 n2 = graph.getOrDefault(prerequisite[0],new GraphNode2(prerequisite[0]));
            graph.put(prerequisite[0], n2);

            n2.neighbours.add(n1);
        }

        hasLoop = new Boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(graph.containsKey(i)){
                visited = new Stack<>();
                if(hasLoop[graph.get(i).val] == null ){
                    traverse(graph.get(i));
                }

                if(hasLoop[graph.get(i).val] != null && hasLoop[graph.get(i).val]){
                    return false;
                }
            }
        }

        return true;
    }
}
