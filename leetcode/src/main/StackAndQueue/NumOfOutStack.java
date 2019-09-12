package StackAndQueue;


import java.util.*;

public class NumOfOutStack {
    /**
 * 入栈序列1、2、3、4、5，所有的出栈序列
 * 每一次递归的时候有入栈和出栈两个选择，当所有的数都已经入栈后，打印序列，
 */
    public Vector<String> vector = new Vector<>();//用vector代替栈，方便打印
    public final int N = 5;
    public static int total = 0;

    /**
     * count 下一个要入栈的数
     * vector 当前栈内数字
     * outSer 中间弹出序列
     */
    public void recur(int count, Vector<String> vector, String outSer) {
        if (count <= N) {//仍然有没有入栈的数字，入栈
            String str = count + "";
            vector.add(str);
            count++;
            recur(count, vector, outSer);
            vector.remove(str);//回溯栈的状态
            count--;//回溯计数器
        }
        if (count <= N && !vector.isEmpty()) {//出栈
            String last = vector.lastElement();
            outSer = outSer + " " + last;//修改中间弹出序列

            vector.remove(last);//出栈
            recur(count, vector, outSer);
            vector.add(last);//回溯
        }
        if (count > N) {
            total++;
            printPath(outSer, vector);
        }
    }

    public void printPath(String out, Vector<String> vector) {//倒序打印Vector
        Iterator<String> iter = vector.iterator();
        String str = "";
        while (iter.hasNext()) {
            str = iter.next() + " " + str;
        }
        System.out.println(out + " " + str);
    }

    public static void inStack(List<List<Integer>> res,Stack<Integer> in, Stack<Integer> out, List<Integer> state){
        if(out.isEmpty()){
            List<Integer> curState = new ArrayList<>(state);
            while (!in.isEmpty()){
                curState.add(in.pop());
            }
            res.add(curState);
            return;
        }
        Stack<Integer> in2 = new Stack<>();
        in2.addAll(in);
        Stack<Integer> out2 = new Stack<>();
        out2.addAll(out);
        List<Integer> state2 = new ArrayList<>(state);

        state2.add(out2.pop());
        inStack(res,in2,out2,state2);

        in.add(out.pop());
        inStack(res,in,out,state);
    }


    public static void main(String[] args) {
        Stack<Integer> out = new Stack<>();
        for (int i = 0; i < 3; i++) {
            out.add(i + 1);
        }
        List<List<Integer>> res = new ArrayList<>();
        inStack(res, new Stack<>(), out, new ArrayList<>());
        System.out.println(res.size());
        for (List<Integer> list:
        res){
            System.out.println(list.toString());
        }
    }
}