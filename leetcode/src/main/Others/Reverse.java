package Others;

import java.util.Scanner;

public class Reverse {
    //函数Reverse的功能：翻转一段字符串
    public void Reverse(char[] data,int begin,int end)
    {
        if (data==null||data.length==0||begin<0||end>data.length||begin>end) return;
        while (begin<end)
        {
            char temp=data[begin];
            data[begin]=data[end];
            data[end]=temp;
            begin++;
            end--;
        }
    }
    public String ReverseAll(String string)
    {
        char[] data=string.toCharArray();
        if (data.length == 0)
            return null;
        Reverse(data,0,data.length-1);
        //翻转句子中的每个单词
        int begin=0;
        int end=0;
        while (begin<data.length) {
            if (data[begin] == ' '|| data[begin]=='.'||data[begin]==',') {
                begin++;
                end++;
            }
            else if (end == data.length || data[end] == ' '||data[end]=='.'||data[end]==',') {
                Reverse(data, begin, end - 1);
                end++;
                begin = end;
            } else {
                end++;
            }
        }
        return String.valueOf(data);
    }

    //主函数
    public static void main(String[] args) {
//        String str="I am a student,my name is nicco.";
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(new Reverse().ReverseAll(str));
    }
}
