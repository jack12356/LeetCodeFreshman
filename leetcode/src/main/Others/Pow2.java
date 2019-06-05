public class Pow2 {
    public static void main(String[] args) {
        int n = 128;
        String res = get_pow2(n);
        System.out.println(res);
    }

    private static String get_pow2(int n) {
        if(n<32) return String.valueOf(1 << n);
        String res1 = get_pow2(n/2);
        String res = multi(res1, res1);
        if((n&0x1)==1) res = multi(res, "2");
        return res;
    }

    private static String multi(String x1, String x2){
        return x1+"*"+x2;
    }
}
