package Graph;

public class NumOfIsland {
    private char [][]grid;
    private int [][]visited;
    public int numIslands(char[][] g) {
        grid=g;
        if(grid.length==0||grid[0].length==0) return 0;
        visited = new int [grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j]==0&&grid[i][j]=='1'){
                    count++;
                    search_1(i,j);
                }
            }
        }
        return count;
    }

    private void search_1(int i, int j) {
        if (i<grid.length && j <grid[0].length && i>=0 && j>=0 && grid[i][j] == '1'&&visited[i][j]==0){
            visited[i][j]=1;
            search_1(i - 1,j);
            search_1(i + 1,j);
            search_1(i,j - 1);
            search_1(i,j + 1);
        }
    }
}