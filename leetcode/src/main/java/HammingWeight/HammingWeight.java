package HammingWeight;

public class HammingWeight {
    public int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            count+=n%2;
            n=n>>1;
        }
        return count;
    }

    public static void main(String[] args) {
        HammingWeight solution = new HammingWeight();
        System.out.println(solution.hammingWeight(31));
    }
}
