package Graph;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Prim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int EdgeNum = sc.nextInt();
        int[][] weight = new int[N+1][N+1];
        for (int i = 0; i < N + 1; i++) for (int j = 0; j < N + 1; j++) weight[i][j] = Integer.MAX_VALUE;
        for (int i = 0; i < EdgeNum; i++) {
            int st = sc.nextInt();
            int end = sc.nextInt();
            weight[st][end] = sc.nextInt();
        }
        int min_cost = prim(weight);
        System.out.println(min_cost);
    }

    private static int prim(int[][] weight) {
        int N = weight.length;
        Set<Integer> got = new HashSet<>();
        Set<Integer> other = new HashSet<>();
        got.add(0);
        for (int i = 1; i < N; i++) {
            other.add(i);
        }
        int cost_sum = 0;
        while (got.size() < N) {
            int min = Integer.MAX_VALUE;
            int node = -1;
            for (int cur :got) {
                for (int next:other) {
                    if (weight[cur][next] < min) {
                        min = weight[cur][next];
                        node = next;
                    }
                }
            }
            if(node==-1) return Integer.MAX_VALUE;
            cost_sum += min;
            got.add(node);
            other.remove(node);
        }
        return cost_sum;
    }
}
