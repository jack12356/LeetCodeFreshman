package TreeForTest;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeTest {

    public static class Node {
        int num;
        int value;
        Node lfchild,rtchild;
        Node(int num,int value) {
            this.num = num;
            this.value = value;
        }
    }
    private static Node createTree(List<Integer> randNum, List<Integer> values) {
//        int []randNum = {1,2,3,5,6,7,12,15,25,30,61};
        Node rootNode = new Node(randNum.get(0),values.get(0));
        for (int j = 1;j<randNum.size();j++) {
            int n = randNum.get(j);
            int v = values.get(j);
            Node node = new Node(n, v);
            Node temp = rootNode;
            int height = 0;
            while ((node.num>>height)>0) {
                height++;
            }
            for (int i = height-2; i >0; i--) {
                int is_left = (node.num>>i)%2;
                temp = is_left == 0 ? temp.lfchild : temp.rtchild;
            }
            if (node.num % 2 == 0) {
                temp.lfchild = node;
            } else temp.rtchild = node;
        }
        return rootNode;
    }


    private static boolean compare(Node tree, Node tree_new) {
        if (tree.value!=tree_new.value||tree.num!=tree_new.num||tree==null||tree_new==null) return false;
        if (tree.lfchild!=null)
            if (!compare(tree.lfchild,tree_new.lfchild)) return false;
        if (tree.rtchild!=null)
            if (!compare(tree.rtchild,tree_new.rtchild)) return false;
        return true;
    }

    private static Node recoverTree(String s) {
        File file = new File(s);
        List<Integer> nums=new ArrayList();
        List<Integer> values=new ArrayList();
        try {
            BufferedReader fr = new BufferedReader(new FileReader(file));
            String buf = null;
            buf=fr.readLine();
            String[] datas = buf.split("\\s+");
            for (int i=0;i<datas.length;i++) {
                if (i % 2 == 0) {
                    nums.add(Integer.valueOf(datas[i]));
                } else values.add(Integer.valueOf(datas[i]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return createTree(nums,values);
    }

    private static void TreeStore(File file, Node tree) {
        //以递增顺序存储起来的
        try {
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            String sbuf = tree.num+" "+ tree.value+(" ");
            bw.write(sbuf);
            bw.close();
            if (tree.lfchild != null) {
                TreeStore(file,tree.lfchild);
            }
            if (tree.rtchild != null) {
                TreeStore(file,tree.rtchild);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        List<Integer> randNum = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 6, 7, 12, 15, 30, 61));
        List<Integer> values = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 6, 7, 12, 15, 30, 61));
//        int height = 7, number = 10;
        Node tree = createTree(randNum,values);
        File file = new File("./Tree.xml");
        fileclear(file);
        TreeStore(file, tree);
        Node tree_new = recoverTree("./Tree.xml");
        boolean is_equeal = compare(tree, tree_new);
        System.out.println("是否正确恢复树结构？ "+ (is_equeal?"正确恢复":"无法正确恢复"));
    }

    private static void fileclear(File file) {
        try {
            if(!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter =new FileWriter(file);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
