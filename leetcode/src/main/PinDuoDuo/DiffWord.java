package PinDuoDuo;
import java.util.Scanner;

public class DiffWord {
    public static void main(String[] args) {
        DiffWord test = new DiffWord();
        Scanner sc = new Scanner(System.in);
        String word1 = sc.nextLine();
        String word2 = sc.nextLine();
        System.out.println(test.getRes(word1,word2));
    }

    private int getRes(String word1, String word2) {
        int [][]dp = new int[word1.length()+1][word2.length()+1];   // word1 i to word12 j
        for (int i = 1; i <= word1.length(); i++) dp[i][0]=i;
        for (int i = 1; i <= word2.length(); i++) dp[0][i]=i;
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else{
                    dp[i][j] = Math.min(Math.min(dp[i][j-1]+1,dp[i-1][j]+1),dp[i-1][j-1]+1);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
