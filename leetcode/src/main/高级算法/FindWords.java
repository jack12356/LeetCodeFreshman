import java.util.*;

public class FindWords {
    public List<String> findWords(char[][] board, String[] words) {

        List<String> res = new ArrayList<>();
        if (words.length==0||board.length==0) return res;
        for (String word :new HashSet<>(Arrays.asList(words))) {
            boolean[][] visited = new boolean[board.length][board[0].length];
            if (inBoard(word,board,visited)) res.add(word);
        }
        return res;
    }

    private boolean inBoard(String word, char[][] board, boolean[][] visited) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (equalAllLetter(word,board,i,j,visited)) return true;
            }
        }
        return false;
    }

    private boolean equalAllLetter(String word, char[][] board, int i, int j, boolean[][]visited) {
        if (i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!=word.charAt(0)||visited[i][j]) return false;
        visited[i][j] = true;
        if (word.length()==1) return true;
        if (equalAllLetter(word.substring(1),board,i-1,j, visited)) return true;   //上边
        if (equalAllLetter(word.substring(1),board,i+1,j, visited)) return true;   //下边
        if (equalAllLetter(word.substring(1),board,i,j-1, visited)) return true;   //左边
        if (equalAllLetter(word.substring(1),board,i,j+1, visited)) return true;   //右边
        visited[i][j] = false;
        return false;
    }





    public static void main(String[] args) {
        FindWords su = new FindWords();
        String[] words = new String[]{"a","a"};
        char[][]board = new char[1][1];
        board[0][0] = 'a';
        System.out.println(su.findWords(board, words).toString());
    }
}
