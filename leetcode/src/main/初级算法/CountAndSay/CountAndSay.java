package CountAndSay;

//报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
//
//        1
//        11
//        21
//        1211
//        111221 1 被读作 "one 1" ("一个一") , 即 11。 11 被读作 "two 1s" ("两个一"）, 即 21。 21 被读作 "one 2", "one 1" （"一个二" , "一个一") , 即 1211。
//        给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
//
//        注意：整数顺序将表示为一个字符串。

public class CountAndSay {
    public String countAndSay(int n) {
        int len;
        String result="1";
        for (int m = 0; m < n-1; m++) {
            len = result.length();
            int i=0;
            String t="";
            while (i<len){
                for (int j = i+1; j < len+1; j++) {
                    if(j==len||(result.charAt(i)!=result.charAt(j))){
                        t = t+String.valueOf(j-i)+result.charAt(i);
                        i=j;
                    }
                }
            }
            result = t;
        }
        return result;
    }

    public static void main(String[] args) {
        CountAndSay solution = new CountAndSay();
        int n = 5;
        System.out.println(solution.countAndSay(n));
    }

}

