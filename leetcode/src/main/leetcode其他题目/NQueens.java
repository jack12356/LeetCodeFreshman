package leetcode其他题目;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    List<List<String>> res = new ArrayList<>();
    int [][]board;
    public List<List<String>> solveNQueens(int n) {
        board = new int[n][n];
        NQueens(0,n);
        return res;
    }
    public void NQueens(int row,int n){
        if(row>=n){       //已经全部摆放
            List<String> list = new ArrayList<>();
            for(int i = 0;i<n;i++){
                StringBuilder str = new StringBuilder();
                for(int j=0;j<n;j++){
                    String t = board[i][j]==1?"Q":".";
                    str.append(t);
                }
                list.add(str.toString());
            }
            res.add(list);
            return;
        }

        for(int i = 0;i<n;i++){         //依次在第row行i位置摆放皇后
            // System.out.println("row is :"+row);
            // System.out.println("index is :"+i);

            board[row][i] = 1;
            if(check(row,i))  NQueens(row+1,n);
            board[row][i] = 0;
        }
    }
    public boolean check(int row,int i){        //判断是否可以放置
        int curRow = row - 1;
        while(curRow>=0){               //上方
            if(board[curRow][i]==1) return false;
            curRow--;
        }
        curRow = row - 1;
        int curIndex = i - 1;
        while(curRow>=0&&curIndex>=0){      //左上方
            if(board[curRow][curIndex]==1) return false;
            curRow--;
            curIndex--;
        }
        curRow = row - 1;
        curIndex = i + 1;
        while(curRow>=0&&curIndex<board.length){      //右上方
            if(board[curRow][curIndex]==1) return false;
            curRow--;
            curIndex++;
        }
        return true;
    }
}