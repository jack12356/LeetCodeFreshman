import java.util.Scanner;

public class FindPath {
    int res = 0;
    int st_x,st_y,end_x,end_y;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] nums = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        FindPath test = new FindPath();
        test.st_x = sc.nextInt();
        test.st_y = sc.nextInt();
        test.end_x = sc.nextInt();
        test.end_y = sc.nextInt();
        boolean[][] visited = new boolean[N][M];
        test.DFS(nums,visited,test.st_x,test.st_y,Integer.MIN_VALUE);
        System.out.println(test.res);
    }

    private void DFS(int[][] nums,boolean[][]visted,int x ,int y,int prenum) {
        if(x==end_x&&y==end_y&&nums[x][y]>prenum) {
            res+=1;
            res%=1000000000;
            return;
        }
        if(x>=0&&x<nums.length&&y>=0&&y<nums[0].length&&!visted[x][y]&&nums[x][y]>prenum){
            visted[x][y] = true;
            DFS(nums,visted,x-1,y,nums[x][y]);
            DFS(nums,visted,x+1,y,nums[x][y]);
            DFS(nums,visted,x,y-1,nums[x][y]);
            DFS(nums,visted,x,y+1,nums[x][y]);
            visted[x][y] = false;
        }
    }
}
