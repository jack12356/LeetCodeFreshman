import java.util.*;

public class FindCircleNum {
    public class Trie{
        String string;
    }
    public int findCircleNum(int[][] M) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        int count = 0;
        boolean []visited = new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) count++;
            dfs(M,visited,i);
        }
        return count;

    }

    private void dfs(int[][] M, boolean[] visited, int i) {
        if(visited[i]) return;
        visited[i] = true;
        for (int j = 0; j < M[0].length; j++) {
            if (M[i][j]==1) {
                dfs(M,visited,j);
            }
        }
    }
}
