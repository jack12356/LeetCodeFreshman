import java.util.*;
public class GetKeys {
    public int res = Integer.MAX_VALUE;
    public static void main(String []args){
            GetKeys test = new GetKeys();
            Scanner sc = new Scanner(System.in);
            int m = sc.nextInt();
            int n = sc.nextInt();
            if(m<=0&&n<=0) System.out.println(-1);
            char [][]chars = new char[m][n];
            int [][]nowKeys = new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++) nowKeys[i][j]=-1;
            }
            int []keys = new int[26];
            for(int i = 0;i<m;i++) chars[i] = sc.nextLine().toCharArray();

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(chars[i][j]=='2') test.DFS(i,j,0,Integer.MAX_VALUE,chars,nowKeys,keys);
                }
            }
            System.out.println(test.res);
    }
        public void DFS(int i,int j,int curSteps, int minSteps,char [][]chars, int [][]nowKeys,int []keys){


            if(i>=0&&i<chars.length&&j>=0&&j<chars[0].length){
                if(chars[i][j]=='3') {
                    res = Math.min(minSteps,curSteps+1);
                    return;
                }
                if(chars[i][j]=='0') return;
                if(nowKeys[i][j]>=0){        //has come in
                    if(sum(keys)==nowKeys[i][j]) return;
                }
                // never come in or keys change
                int tempKeys = nowKeys[i][j];
                nowKeys[i][j]=sum(keys);
                if(chars[i][j]<='z'&&chars[i][j]>='a') keys[chars[i][j]-'a']=1;
                if(chars[i][j]<='Z'&&chars[i][j]>='A'&&keys[chars[i][j]-'A']<1) return;
                DFS(i-1,j,curSteps+1,minSteps,chars,nowKeys,keys);
                nowKeys[i][j]=tempKeys;
                DFS(i+1,j,curSteps+1,minSteps,chars,nowKeys,keys);
                nowKeys[i][j]=tempKeys;
                DFS(i,j-1,curSteps+1,minSteps,chars,nowKeys,keys);
                nowKeys[i][j]=tempKeys;
                DFS(i,j+1,curSteps+1,minSteps,chars,nowKeys,keys);
                nowKeys[i][j]=tempKeys;
            }
        }
        public int sum(int []nums){
            int res = 0;
            for(int n:nums) res+=n;
            return res;
        }
}
