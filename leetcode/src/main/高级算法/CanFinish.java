import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses]; // i -> j //邻接矩阵存储图
        int[] indegree = new int[numCourses]; // 统计每个节点的入度

        for (int i = 0; i < prerequisites.length; i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (matrix[pre][ready] == 0)
                indegree[ready]++;
            matrix[pre][ready] = 1;
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[course][i] != 0) {// 节点 i 与该节点相连
                    indegree[i]--; // 与刚出队的节点相连的节点，入度减一
                    if (indegree[i] == 0) { // 如果为0，说明没有前驱，可以访问
                        queue.offer(i);
                    }
                }
            }
        }
        return count == numCourses; // 如果所有节点是否都访问了，如果是说明成功
    }

    public static void main(String[] args) {
        CanFinish su = new CanFinish();
        int[][] prerequisites = new int[1][];
        prerequisites[0] = new int[]{1,0};
        System.out.println(su.canFinish(2, prerequisites));
    }
}
