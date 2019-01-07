import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer>res = new ArrayList<>();
        addElements(matrix, res);
        return res;
    }

    private void addElements(int[][] matrix, List<Integer> res) {
        if(matrix.length==0) return;
        for (int i :matrix[0]) res.add(i);
        if (matrix.length-1==0) return;
        int [][]re_matrix = new int[matrix[0].length][matrix.length-1];
        for (int i = 0; i < re_matrix.length; i++) {
            for (int j = 0; j < re_matrix[0].length; j++) {
                re_matrix[i][j] = matrix[j+1][matrix[0].length-i-1];
            }
        }
        addElements(re_matrix,res);
    }
}
