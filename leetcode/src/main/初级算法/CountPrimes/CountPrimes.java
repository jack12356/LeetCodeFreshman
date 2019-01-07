package CountPrimes;

public class CountPrimes {
    public int CountPrimes(int n) {
        if (n <= 1) return 0;
        int count = 0;
        for (int i = 2; i <= n; i++) {
            count=isPrime(i)?count+1:count;
            if (isPrime(i))System.out.println(i);
        }

        return count;
    }

    public boolean isPrime(int num) {
        boolean ret = false;
        if (num == 2) return true;
        if (num % 2 != 0) {
            int ubound = (int) Math.sqrt(num) + 1;
            for (int i = 2; i< ubound; i++) {
                if(num%i==0) return false;
            }
            return true;
        }else return false;
    }

    public static void main(String[] args) {
        CountPrimes solution = new CountPrimes();
        solution.CountPrimes(20);
    }
}