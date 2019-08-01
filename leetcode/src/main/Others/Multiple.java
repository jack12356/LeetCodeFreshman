
import java.util.Scanner;

public class Multiple {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(str);
        String []strs = str.split(" ");
        String num1 = strs[0];
        String num2 = strs[1];
        Multiple ma = new Multiple();
//
        System.out.println(ma.getRes(num1,num2));


    }
    public String getRes(String num1,String num2){
        int []nums1 = new int[num1.length()];
        int []nums2 = new int[num2.length()];
        for(int i = 0;i<num1.length();i++) nums1[i] = num1.charAt(i)-'0';
        for(int i = 0;i<num2.length();i++) nums2[i] = num2.charAt(i)-'0';
        int []res = new int[num1.length()+num2.length()];
        for(int i=nums1.length-1;i>=0;i--){
            for(int j=nums2.length-1;j>=0;j--){
                int temp = res[i+j+1]+nums1[i]*nums2[j];
                res[i+j+1] = temp%10;
                res[i+j] += temp/10;
            }
        }
        StringBuilder stb = new StringBuilder();
        int index = 0;
        while(res[index]==0&&index<res.length-1) index++;
        while(index<res.length) {
            stb.append(res[index]);
            index++;
        }
        return stb.toString();
    }
}
