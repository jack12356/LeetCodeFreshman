package Kuai;

import java.util.*;

public class Rand_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String[] strs = new String[M];
        sc.nextLine();
        for (int i = 0; i < M; i++) {
            strs[i] = sc.nextLine();
        }
        solve(strs, N);
    }
    private static void solve(String []strs, int n) {
        List<String> res = new ArrayList<>();
        Queue<String> qV = new LinkedList<>();
        Queue<String> qP = new LinkedList<>();
        int cnt = n;
        int pre = 0;
        for (String s : strs) if (s.startsWith("V")) qV.add(s);
        for (String s : strs) if (s.startsWith("P")) qP.add(s);
        while (pre<strs.length&&strs[pre].startsWith("V")){
            res.add(strs[pre]);
            qV.poll();
            pre++;
        }
        while (!qV.isEmpty()&&!qP.isEmpty()) {
            if(cnt>=n-1){
                res.add(qP.poll());
                cnt=0;
            }else {
                res.add(qV.poll());
                cnt++;
            }
        }
        while (!qV.isEmpty()){
            res.add(qV.poll());
        }
        if(!qP.isEmpty()&&cnt>=n-1) res.add(qP.poll());
        System.out.println(res.size());
        for (String s : res) {
            System.out.println(s);
        }
    }

//    private static void solve(String []strs, int n) {
//        List<String> list = new ArrayList<>();
//        int cnt = n;
//        int pre = 0;
//        while (pre<strs.length&&strs[pre].startsWith("V")){
//            list.add(strs[pre]);
//            pre++;
//        }
//        int i = pre;
//        while (i<strs.length){
//            if(cnt>=n-1){
//                int j = i;
//                while (j<strs.length&&strs[j].startsWith("V")) j++;
//                if(j>=strs.length) break;
//                String t = strs[i];
//                strs[i] = strs[j];
//                strs[j] = t;
//                list.add(strs[i]);
//                cnt=0;
//                i++;
//            }else if(strs[i].startsWith("V")) {
//                list.add(strs[i]);
//                i++;
//                cnt++;
//            }
//            i++;
//        }
//        System.out.println(list.size());
//        for (String s : list) {
//            System.out.println(s);
//        }
//    }
}
