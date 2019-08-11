package Others;

import java.util.Scanner;

public class Match2 {
    boolean res = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String []strs = line.split(" ");
        Match2 test = new Match2();
        test.solve(strs, 0);
        System.out.println(test.res);
    }

    private void solve(String[] strs,int index) {
        if(res) return;
        if(index==strs.length){
            res = true;
        }
        for(int i = index;i<strs.length;i++){
            swap(index,i,strs);
            if(check(strs,index)) {
                solve(strs,index+1);
            }
            swap(index,i,strs);
        }
    }

    public boolean check(String []strs,int index){
        String cur = strs[index];
        if(index==strs.length-1){
            return cur.charAt(cur.length() - 1) == strs[0].charAt(0);
        }else{
            return cur.charAt(cur.length() - 1) == strs[index+1].charAt(0);
        }
    }
    private void swap(int index, int i, String[] board){
        String t = board[i];
        board[i] =  board[index];
        board[index] =  t;
    }
}
