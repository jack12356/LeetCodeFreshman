import java.util.Scanner;

public class MinProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) nums[i] = sc.nextInt();
        int nA = sc.nextInt();
        int nB = sc.nextInt();
        MinProduct test = new MinProduct();
        System.out.println(test.getRes(nums,nA,nB));

    }

    private Long getRes(int[] nums, int nA, int nB) {
        if(nA>nB){
            int t = nA;
            nA = nB;
            nB = t;
        }
        int i = 0;
        Long A = 0L;
        Long B = 0L;
        // get A
        while(nA>0&&i<10){
            while(nums[i]>0&&nA>0){
                A = A * 10 + i;
                nA--;
                nums[i]--;
            }
            if(nA>0) i++;
        }
        //get B
        while(nB>0&&i<10){
            while(nums[i]>0&&nB>0){
                B = B * 10 + i;
                nB--;
                nums[i]--;
            }
            if(nB>0) i++;
        }
        if(i>10) return -1L;
        return A*B;
    }
}
