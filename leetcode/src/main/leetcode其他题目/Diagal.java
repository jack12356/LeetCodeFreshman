package leetcode其他题目;

import java.util.Arrays;

class Diagal {
    public static void main(String[] args) {
        int [][]nums = new int[][]{new int[]{1,2,3},new int[]{4,5,6},new int[]{7,8,9}};
        int[] res = findDiagonalOrder(nums);
        System.out.println(Arrays.toString(res));
    }
    private static int[] findDiagonalOrder(int[][] matrix) {
        int h = matrix.length;
        if(h==0) return new int[]{};
        int w = matrix[0].length;
        int []res = new int[h*w];
        int r = 0;
        int c = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = matrix[r][c];
            if ((r + c) % 2 == 0) {
                if (r == 0 && c != w - 1) { //元素在第一行，往右走
                    c++;
                } else if (c == w - 1) { // 元素在最后一列，往下走
                    r++;
                } else { //其他情况，往右上走
                    r--;
                    c++;
                }
            } else {
                if (c == 0 && r != h - 1) { //元素在第一列，往下走
                    r++;
                } else if (r == h - 1) { //元素在最后一行，往右走
                    c++;
                } else { //其他情况，往左下走
                    r++;
                    c--;
                }
            }
        }
        return res;
    }
}