class Solution {
    public static int myAtoi(String str) {
        int max = Integer.MAX_VALUE;
        int max_10 = max/10;
        int len = str.length();
        int i=0;
        int n=0;
        int sign=1;

        if(len==0){
            return n;
        }
        //找到首位非空字符
        while(str.charAt(i)==' '){
            i++;
            if(i==len){
                return n;
            }
        }

        //符号位
        switch (str.charAt(i)){
            case '+': {
                sign=1;
                i++;
                break;
            }
            case '-': {
                sign=-1;
                i++;
                break;
            }
            default: {
                if (str.charAt(i)<='9'&&str.charAt(i)>='0'){
                    break;
                }else{
                    return sign*n;
                }
            }
        }
        //找到连续数字
        for (;i< len; i++) {
            char c = str.charAt(i);
            if(c<='9'&&c>='0'){
                if(n>max_10||(n==max_10&&(c-'0')>max%10)){
                    return (sign==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
                n = n*10+c-'0';
            }else{
                return sign*n;
            }
        }
        return sign*n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str="  -0012a42";
        System.out.println(solution.myAtoi(str));
    }
}