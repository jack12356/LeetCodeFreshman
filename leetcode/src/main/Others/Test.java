import java.util.*;
public class Test{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []nums = new int[n];
        for(int i=0;i<n;i++) nums[i] = sc.nextInt();
        Test ma = new Test();
        System.out.println(ma.getRes(nums));
        StringBuilder stb = new StringBuilder();

    }
    public int getRes(int []nums){
        if(nums.length<3) return -1;
        int max3 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int n:nums){
            if(n>max3){
                max1 = max2;
                max2 = max3;
                max3 = n;
            }else if(n>max2){
                max1 = max2;
                max2 = n;
            }else if(n>max1) max1=n;


            if(n<min1) {
                min2 = min1;
                min1 = n;
            }else if(n<min2) min2 = n;
        }
        int maxt1 = max1*max2*max3;
        int maxt2 = min1*min2*max3;
        return Math.max(maxt1,maxt2);
    }
}