package ExistWord;

public class ExistWord {
    private boolean visited[][];
    private char board[][];
    public boolean exist(char[][] b, String word) {
        board=b;
        visited = new boolean[board.length][board[0].length];
        if (word.length()==0) return true;
        char c = word.charAt(0);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==c){
                    if(search(word,i,j)) return true;
                }
            }
        }
        return false;
    }

    private boolean search(String word, int i, int j) {
        char c = word.charAt(0);
        if (i<board.length && j <board[0].length && i>=0 && j>=0 && board[i][j] == c&&!visited[i][j]){
            if (word.length()==1) return true;
            visited[i][j]=true;
            if (search(word.substring(1), i - 1,j)) return true;
            if (search(word.substring(1), i + 1,j)) return true;
            if (search(word.substring(1), i,j - 1)) return true;
            if (search(word.substring(1), i,j + 1)) return true;
            visited[i][j]=false;
        }
        return false;
    }

    public static void main(String[] args) {
        char [][]board = new char[][]{
                                        {'A','B','C','E'},
                                        {'S','F','C','S'},
                                        {'A','D','E','E'}
        };
        ExistWord su = new ExistWord();
        System.out.println(su.exist(board, "ABFE"));
    }
}
