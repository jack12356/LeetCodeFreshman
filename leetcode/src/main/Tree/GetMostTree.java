package Tree;

import java.util.*;

class MultiTreeNode{
    MultiTreeNode parent;
    List<MultiTreeNode> childs;
    int val;
    MultiTreeNode(int x){
        val = x;
        childs = new ArrayList<>();
        parent = null;
    }
}

public class GetMostTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, MultiTreeNode> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int st = sc.nextInt();
            int end = sc.nextInt();
            if(map.containsKey(st)&&map.containsKey(end)){
                map.get(st).childs.add(map.get(end));
                map.get(end).parent = map.get(st);
            }else if(map.containsKey(st)&&!map.containsKey(end)){
                MultiTreeNode endNode = new MultiTreeNode(end);
                endNode.parent = map.get(st);
                map.get(st).childs.add(endNode);
                map.put(end, endNode);
            }else if(!map.containsKey(st)&&map.containsKey(end)){
                MultiTreeNode stNode = new MultiTreeNode(st);
                stNode.childs.add(map.get(end));
                map.get(end).parent = stNode;
                map.put(st, stNode);
            }else {
                MultiTreeNode stNode = new MultiTreeNode(st);
                MultiTreeNode endNode = new MultiTreeNode(end);
                stNode.childs.add(endNode);
                endNode.parent = stNode;
                map.put(st, stNode);
                map.put(end, endNode);
            }
        }
        int max = 0;
        int res = -1;
        for (MultiTreeNode node :map.values()) {
            if(node.parent==null){
                int nn = getNum(node);
                if(nn>max||(nn==max&&node.val>res)){
                    max = nn;
                    res = node.val;
                }
            }
        }
        System.out.println(res);
    }

    private static int getNum(MultiTreeNode node) {
        Queue<MultiTreeNode> queue = new LinkedList<>();
        queue.add(node);
        int cnt = 0;
        while (!queue.isEmpty()){
            MultiTreeNode cur = queue.poll();
            queue.addAll(cur.childs);
            cnt++;
        }
        return cnt;
    }
}
