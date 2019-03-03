public class TotalNQueens {
    public int totalNQueens(int n) {
        if(n==0) return 0;
        int []board = new int[n];
        for(int i = 0;i<n;i++) board[i] = i;
        int res = NumQueens(board,0,n);
        return res;
    }
    public int NumQueens(int []board,int index,int n){
        if(index==n){
            return 1;
        }
        int num = 0;
        for(int i = index;i<n;i++){
            swap(index,i,board);
            if(check(board,index,n)) {
                num+=NumQueens(board,index+1,n);
            }
            swap(index,i,board);
        }
        return num;
    }
    public boolean check(int []board,int index,int n){
        int cur = board[index];
        for(int i =0;i<index;i++){
            int pre = board[i];
            if((cur-pre == index-i)||(index-i==pre-cur)){
                return false;
            }
        }
        return true;
    }
    public void swap(int index,int i,int []board){
        int t = board[i];
        board[i] =  board[index];
        board[index] =  t;
    }
}
