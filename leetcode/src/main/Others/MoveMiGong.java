package Others;

import java.util.Scanner;

/*
3
0 1 1
0 1 1
0 1 0
1

7
0 1 1 1 1 1 1
0 0 1 1 1 1 1
1 0 0 1 1 1 1
1 1 1 0 0 1 0
1 1 1 1 1 1 0
0 1 1 1 1 1 0
1 0 1 0 1 1 0

2
 */
public class MoveMiGong {
    int res = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] Q = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Q[i][j] = sc.nextInt();
            }
        }
        int []res = new int[1];
        res[0] = Integer.MAX_VALUE;
        Solve(Q,res,0,0,visited,0);
        System.out.println(res[0]);
    }

    private static void Solve(int[][] Q, int[] res, int i, int j, boolean[][] visited,int preSum) {
        int n = Q.length;
        if(i<0||i>=n||j<0||j>=n||visited[i][j]) return;
        int sum = preSum + Q[i][j] == 0 ? 0 : 1;
        if (i == n - 1 && j == n - 1) {
            res[0] = Math.min(res[0], sum);
            return;
        }
        visited[i][j] = true;
        Solve(Q, res, i-1, j, visited, sum);
        Solve(Q, res, i+1, j, visited, sum);
        Solve(Q, res, i, j-1, visited, sum);
        Solve(Q, res, i, j+1, visited, sum);
        visited[i][j] = false;
    }
}
