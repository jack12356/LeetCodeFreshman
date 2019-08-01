import java.util.Arrays;

public class Solve {
    private int height, wide;
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        height = board.length;
        wide = board[0].length;

        for (int i = 0; i < height; i++) {
            dfs(board, i, 0);
            dfs(board, i, wide - 1);
        }
        for (int i = 0; i < wide; i++) {
            dfs(board, 0, i);
            dfs(board, height - 1, i);
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < wide; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= height || j < 0 || j >= wide || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'T';
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
    }

    public static void main(String[] args) {
        char [][]board = new char[][]{
                new char[]{'O','O','O','O','X','X'},
                new char[]{'O','O','O','O','O','O'},
                new char[]{'O','X','O','X','O','O'},
                new char[]{'O','X','O','O','X','O'},
                new char[]{'O','X','O','X','O','X'},
                new char[]{'O','X','O','O','O','O'}};
        new Solve().solve(board);
        for (char[]cs:board) {
            System.out.println(Arrays.toString(cs));
        }
    }

//            [
//            {"O","O","O","O","X","X"},
//            {"O","O","O","O","O","O"},
//            {"O","X","O","X","O","O"},
//            {"O","X","O","O","X","O"},
//            {"O","X","O","X","O","O"},
//            {"O","X","O","O","O","O"}
//            ]

}
