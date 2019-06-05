class NumDistinct {
    public int numDistinct(String s, String t) {
        return numDistinct1(s, t,0,0);
    }
    public int numDistinct1(String s, String t,int sst,int tst){
        if(tst>=t.length()) return 1;
        if(sst>=s.length()) return 0;
        char cT = t.charAt(tst);
        int count = 0;
        for(int i = sst;i<s.length();i++){
            if(s.charAt(i)==cT) count+=numDistinct1(s,t,i+1,tst+1);
        }
        return count;
    }

    public static void main(String[] args) {
        NumDistinct numdi = new NumDistinct();
        String s = "bb";
        String t = "bb";
        System.out.println(numdi.numDistinct(s,t));
    }
}