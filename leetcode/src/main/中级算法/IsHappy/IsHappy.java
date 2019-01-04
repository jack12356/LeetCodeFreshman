package IsHappy;

public class IsHappy {
    public boolean isHappy(int n) {
        while (n!=1){
            int t = 0;
            while (n!=0){
                t += Math.pow((n % 10),2);
                n = n / 10;
            }
            if (t==4) return false;
            n = t;
        }
        return true;
    }

    public static void main(String[] args) {
        IsHappy su = new IsHappy();
        System.out.println(su.isHappy(19));
    }
}
