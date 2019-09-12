package Others;

public class JophfCycle {

        public void way1(int n, int m){
            int r = 0;
            for (int i = 2; i <= n; i++) {
                r = (r + m) % i;
            }
            System.out.println(r+1);
        }

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            JophfCycle t = new JophfCycle();
            t.way1(2, 1);
        }

        private int josphus(int n, int m){
            if(n==1){return 0;}
            return (josphus(n-1,m)+m)%n;
        }
}
