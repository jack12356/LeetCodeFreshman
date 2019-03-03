import java.util.Arrays;
import java.util.Collections;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        if (board.length==0||board[0].length==0) return;
        int height = board.length;
        int wide = board[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < wide; j++) {
                int count = count_1(board,i,j);
                if ((count<2||count>3) && (board[i][j] == 1)) board[i][j]=2;
                if ((count==3) && (board[i][j]==0)) board[i][j]=-3;
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < wide; j++) {
                if (board[i][j] == -3) board[i][j]=1;
                if (board[i][j] == 2) board[i][j]=0;
            }
        }
    }


    private int count_1(int[][] board, int i, int j) {
        int count = 0;
        count+=add(board,i-1,j-1);
        count+=add(board,i-1,j);
        count+=add(board,i-1,j+1);
        count+=add(board,i,j-1);
        count+=add(board,i,j+1);
        count+=add(board,i+1,j-1);
        count+=add(board,i+1,j);
        count+=add(board,i+1,j+1);
        return count;
    }

    private int add(int[][] board, int i, int j) {
        return (i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] > 0) ? 1 : 0;
    }

    public static void main(String[] args) {
        int[][] board = new int [][]{
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
        GameOfLife su = new GameOfLife();
        su.gameOfLife(board);
    }
}
