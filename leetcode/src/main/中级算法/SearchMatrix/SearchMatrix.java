package SearchMatrix;

import BinarySearch.BinarySearch;

public class SearchMatrix {
    public boolean searchMatrix(int [][] matrix, int target) {
        int size = matrix.length;
        if (size == 0) return false;
        int len = matrix[0].length;
        if (len == 0) return false;
        int i = size - 1, j = 0;
        while (i >= 0 && j < len) {
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] < target)
                j++;
            else
                i--;
        }
        return false;
    }


    public static void main(String[] args) {
        SearchMatrix su = new SearchMatrix();
        int [][]matrix = new int [][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,26,30}};
        System.out.println(su.searchMatrix(matrix, -5));
    }
}
