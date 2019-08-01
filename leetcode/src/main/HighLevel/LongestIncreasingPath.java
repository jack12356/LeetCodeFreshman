public class LongestIncreasingPath {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0) return 0;
        int[][] visited = new int[matrix.length][matrix[0].length];
        int longest = 0;
        for (int i = 0; i <matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int cur_len = longPath(matrix,i,j,visited,Integer.MIN_VALUE);
                if (cur_len>longest) longest = cur_len;
            }
        }
        return longest;
    }

    public int longPath(int[][]matrix,int i,int j,int[][]visited,int oldVal){
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= oldVal) return 0;
        if (visited[i][j] != 0) return visited[i][j];
        int cur_num = matrix[i][j];
        int upLen = longPath(matrix, i - 1, j, visited,cur_num); //上面
        int dnLen = longPath(matrix, i + 1, j, visited,cur_num); //下面
        int lfLen = longPath(matrix, i, j - 1, visited,cur_num); //左面
        int rtLen = longPath(matrix, i, j + 1, visited,cur_num); //右面
        upLen = Math.max(upLen,dnLen);
        rtLen = Math.max(lfLen,rtLen);
        visited[i][j] = Math.max(upLen,rtLen) + 1;
        return visited[i][j];
    }
}
