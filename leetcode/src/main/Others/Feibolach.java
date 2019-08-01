public class Feibolach{
    public static void main(String []args){
        Feibolach feibolach = new Feibolach();
        String str = "ADCSDF";
        str = str.toLowerCase();
        System.out.println(str);
//        feibolach.getNthNumber(12);
    }
    public int getNthNumber(int n) {
            // write code here
            if(n<=2) return 1;
            int pre2 = 1;
            int pre1 = 1;
            int cur = 2;
            for(int i=3;i<=n;i++){
                cur = (pre1+pre2)%1000000007;
                pre2 = pre1;
                pre1 = cur;
            }
            return cur;
    }
}