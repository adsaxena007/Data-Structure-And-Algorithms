package leet_code.top_150_interview_questions._12_GraphGenral;


import java.util.*;

class GraphNode{
    public String val;
    public List<Double> weight;
    public List<GraphNode> neighbours;

    public GraphNode(String val){
        this.val = val;
        weight = new ArrayList<>();
        neighbours = new ArrayList<>();
    }
}

public class _98_EvaluateDivision {


    boolean reached = false;
    double answer;
    List<GraphNode> visited;
    public void traverse(GraphNode startNode, double sum , GraphNode targetNode){
        if(startNode==null)
            return;

        if(startNode == targetNode){
            answer = sum;
            reached = true;
        }


        if(reached)
            return;

        visited.add(startNode);

        int i = 0;
        while (i<startNode.neighbours.size()){
            GraphNode n = startNode.neighbours.get(i);
            if(!visited.contains(n)){
                traverse(n, sum*startNode.weight.get(i), targetNode);
            }
            i++;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, GraphNode> map = new HashMap<>();
        int i=0;
        for(List<String> var : equations){
            GraphNode n1 = map.getOrDefault( var.getFirst(), new GraphNode(var.getFirst()));
            GraphNode n2 = map.getOrDefault( var.get(1), new GraphNode(var.get(1)));

            n1.weight.add(values[i]);
            n1.neighbours.add(n2);

            n2.weight.add(1/values[i]);
            n2.neighbours.add(n1);

            map.put(var.getFirst(), n1);
            map.put(var.get(1), n2);
            i++;
        }
        double [] result= new double[queries.size()];
        i=0;

        for(List<String> query : queries){
            GraphNode n1 = map.getOrDefault( query.getFirst(), null);
            GraphNode n2 = map.getOrDefault( query.get(1), null);
            if(n1 == null || n2 == null){
                result[i] = -1;
                i++;
                continue;
            }

            reached = false;
            answer = 0;
            visited = new ArrayList<>();
            traverse(n1,1,n2);
            if(reached){
                result[i] = answer;
            }else {
                result[i] = -1;
            }
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(List.of(new String[]{"a","b"}));
        equations.add(List.of(new String[]{"b","c"}));


        double[] values = {2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(List.of(new String[]{"a","c"}));
        queries.add(List.of(new String[]{"b","a"}));
        queries.add(List.of(new String[]{"a","e"}));
        queries.add(List.of(new String[]{"a","a"}));
        queries.add(List.of(new String[]{"x","x"}));

        _98_EvaluateDivision ob = new _98_EvaluateDivision();

        System.out.println(Arrays.toString(ob.calcEquation(equations, values, queries)));
    }

}
