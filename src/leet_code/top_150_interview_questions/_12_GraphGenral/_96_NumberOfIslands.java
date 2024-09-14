package leet_code.top_150_interview_questions._12_GraphGenral;


import java.util.ArrayList;
import java.util.Arrays;



public class _96_NumberOfIslands {
    Integer [][] visited;

    public void dfs(Node node){
        if(node == null)
            return;


        visited[node.indexI][node.indexJ] = 1;

        int i=0;
        while (i<node.next.size()){
            if(visited[node.next.get(i).indexI][node.next.get(i).indexJ] == null)
                dfs(node.next.get(i));
            i++;
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Node[][] graph = new Node[m][n];
        visited = new Integer[m][n];



        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
              if(grid[i][j]=='1'){
                  Node n1 = graph[i][j] == null ? new Node(i,j) : graph[i][j];
                  if(j+1<n && grid[i][j+1]=='1'){
                      if(graph[i][j+1] == null){
                          Node n2 = new Node(i,j+1);
                          graph[i][j+1] = n2;
                      }
                      n1.next.add(graph[i][j+1]);
                  }

                  if(j-1>=0 && grid[i][j-1]=='1'){
                      if(graph[i][j-1] == null){
                          Node n2 = new Node(i,j-1);
                          graph[i][j-1] = n2;
                      }
                      n1.next.add(graph[i][j-1]);
                  }

                  if(i+1<m && grid[i+1][j] == '1'){
                      if(graph[i+1][j] == null){
                          Node n2 = new Node(i+1,j);
                          graph[i+1][j] = n2;
                      }
                      n1.next.add(graph[i+1][j]);
                  }

                  if(i-1>=0 && grid[i-1][j] == '1'){
                      if(graph[i-1][j] == null){
                          Node n2 = new Node(i-1,j);
                          graph[i-1][j] = n2;
                      }
                      n1.next.add(graph[i-1][j]);
                  }

                  graph[i][j] = n1;
              }
            }
        }


        int island=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==null && graph[i][j] !=null){
                    island++;
                    dfs(graph[i][j]);
                }
            }
        }
        return island;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};

        _96_NumberOfIslands ob = new _96_NumberOfIslands();
        System.out.println(ob.numIslands(grid));

    }
}
