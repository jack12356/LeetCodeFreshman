package ByteDance;

public class LeiJiaNum {
    public static void main(String[] args) {
        String s = "199100199299";
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                boolean res = isLeiJiaNum(s, i, j);
                if (res && j != s.length()) {
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);
    }

    private static boolean isLeiJiaNum(String s,int i,int j) {
        if(j==s.length()) return true;
        String s1 = s.substring(0, i);
        String s2 = s.substring(i, j);
        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s2);

        String s3 = String.valueOf(n1 + n2);
        int k = s3.length() + j;
        if(k>s.length()) return false;
        int n3 = Integer.parseInt(s.substring(j,k));
        if(n1+n2!=n3) return false;
        return isLeiJiaNum(s.substring(i), j - i, k - i);
    }
}
