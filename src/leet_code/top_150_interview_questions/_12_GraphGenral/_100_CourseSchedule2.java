package leet_code.top_150_interview_questions._12_GraphGenral;

import java.util.*;

public class _100_CourseSchedule2 {
    Stack<GraphNode2> visited;
    Boolean [] hasLoop;

    boolean doesCurrentNodeHaveLoop;

    Map<Integer, GraphNode2> graph;
    List<Integer> result;
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

        int var = visited.pop().val;
        if(!result.contains(var))
            result.add(var);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0){
            int [] res = new int[numCourses];
            for(int i=0;i<numCourses;i++){
                res[i]=i;
            }
            return res;
        }

        graph = new HashMap<>();
        result = new ArrayList<>();
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
                    return new int [0];
                }
            }
        }

        if(result.size() != numCourses){
            for(int i=0;i<numCourses;i++){
                if(!result.contains(i))
                    result.add(i);
            }
        }

        int [] res = new int[result.size()];
        int i=0;
        for(int var : result){
            res[i] = var;
            i++;
        }



        return res;
    }

    public static void main(String[] args) {
        _100_CourseSchedule2 ob =new _100_CourseSchedule2();
        int [][] preq = {{1,0}};
        System.out.println(Arrays.toString(ob.findOrder(2, preq)));
    }
}
