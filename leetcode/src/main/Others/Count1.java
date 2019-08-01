public class Count1 {
    public static void main(String[] args) {
        int a = 4;
        int b = 2;
        System.out.println(new Count1().solution(a,b));
    }
    public int solution(int a,int b){
        String num1 = Integer.toBinaryString(a);
        String num2 = Integer.toBinaryString(b);
        int []nums1 = new int[num1.length()];
        int []nums2 = new int[num2.length()];
        for(int i = 0;i<num1.length();i++) nums1[i] = num1.charAt(i)-'0';
        for(int i = 0;i<num2.length();i++) nums2[i] = num2.charAt(i)-'0';
        int []res = new int[num1.length()+num2.length()];
        for(int i=nums1.length-1;i>=0;i--){
            for(int j=nums2.length-1;j>=0;j--){
                int temp = res[i+j+1]+nums1[i]*nums2[j];
                res[i+j+1] = temp%2;
                res[i+j] += temp/2;
            }
        }
        int index = 0;
        int cnt1 = 0;
        while(index<res.length) {
            if(res[index]==1) cnt1++;
            index++;
        }
        return cnt1;
    }
}
