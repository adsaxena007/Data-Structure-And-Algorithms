package leet_code.top_150_interview_questions._12_GraphGenral;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _101_SurroundedRegions {
    int [][]visited;
    int [][]visited2;
    boolean doesGraphContainCornerEdge;
    public void traverse(Node node, int m, int n){
        if(node==null || visited[node.indexI][node.indexJ] == 1)
            return;

        visited[node.indexI][node.indexJ] = 1;

        if(node.indexI == m-1 || node.indexJ == n-1 || node.indexI == 0 || node.indexJ == 0){
            doesGraphContainCornerEdge = true;
        }

        for(Node n2 : node.neighbors){
            if(visited[n2.indexI][n2.indexJ] == 0){
                traverse(n2, m, n);
            }
        }
    }

    public void traverseAndCapture(Node n, char[][] board){
        if(n==null || visited2[n.indexI][n.indexJ]==1)
            return;

        visited2[n.indexI][n.indexJ] = 1;
        board[n.indexI][n.indexJ] = 'X';


        for(Node n2 : n.neighbors){
            if(visited2[n2.indexI][n2.indexJ] == 0)
                traverseAndCapture(n2, board);
        }
    }
    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        Node [][] graph = new Node[m][n];
        visited = new int[m][n];
        visited2 = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 'O'){
                    Node node = graph[i][j] != null ? graph[i][j] : new Node(i,j);
                    if(j+1 < n && board[i][j+1] == 'O'){
                        Node node2 = graph[i][j+1] != null ? graph[i][j+1] : new Node(i,j+1);
                        graph[i][j+1] = node2;
                        node.neighbors.add(node2);
                    }

                    if(j-1 >= 0 && board[i][j-1] == 'O'){
                        Node node2 = graph[i][j-1] != null ? graph[i][j-1] : new Node(i,j-1);
                        graph[i][j-1] = node2;
                        node.neighbors.add(node2);
                    }

                    if(i+1 < m && board[i+1][j] == 'O'){
                        Node node2 = graph[i+1][j] != null ? graph[i+1][j] : new Node(i+1,j);
                        graph[i+1][j] = node2;
                        node.neighbors.add(node2);
                    }

                    if(i-1 >=0 && board[i-1][j] == 'O'){
                        Node node2 = graph[i-1][j] != null ? graph[i-1][j] : new Node(i-1,j);
                        graph[i-1][j] = node2;
                        node.neighbors.add(node2);
                    }
                    graph[i][j] = node;
                }
            }
        }

        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                doesGraphContainCornerEdge = false;
                if(visited[i][j] == 0 && graph[i][j] != null){
                    traverse(graph[i][j],m,n);
                    if(doesGraphContainCornerEdge)
                        continue;
                    traverseAndCapture(graph[i][j], board);
                }
            }
        }
    }

    public static void main(String[] args) {
        _101_SurroundedRegions ob = new _101_SurroundedRegions();
        char [][]board = {{'X','O','X','O','X','O','O','O','X','O'},{'X','O','O','X','X','X','O','O','O','X'},{'O','O','O','O','O','O','O','O','X','X'},{'O','O','O','O','O','O','X','O','O','X'},{'O','O','X','X','O','X','X','O','O','O'},{'X','O','O','X','X','X','O','X','X','O'},{'X','O','X','O','O','X','X','O','X','O'},{'X','X','O','X','X','O','X','O','O','X'},{'O','O','O','O','X','O','X','O','X','O'},{'X','X','O','X','X','X','X','O','O','O'}};
        ob.solve(board);
    }
}
