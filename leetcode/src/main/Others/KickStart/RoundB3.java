package KickStart;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RoundB3 {
    int max = Integer.MIN_VALUE;
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        RoundB3 test = new RoundB3();
        int T = input.nextInt();
        for (int i = 0; i < T; i++) {
            int N = input.nextInt();
            int S = input.nextInt();
            int []nums = new int[N];
            for (int j = 0; j < N; j++) {
                nums[j] = input.nextInt();
            }
            test.max=Integer.MIN_VALUE;
            test.solve(nums,S,0,0,new HashMap<>(),0);
            System.out.println("Case"+" #"+i+": "+test.max);
        }
    }
    public void solve(int []nums, int S, int st,int left,Map<Integer,Integer> map,int count){
        if(left>=nums.length) return;
        int cur = nums[left];
        map.put(cur,map.getOrDefault(cur,0)+1);
        Map<Integer, Integer> map0 = copy(map);
        Map<Integer, Integer> map1 = copy(map);
        Map<Integer, Integer> map2 = copy(map);
        if(map.get(cur)<=S){
            count++;
            max = Math.max(max, count);

            solve(nums,S,st,left+1,map0,count);
        }else{
            solve(nums,S,st,left+1,map,sum(map1,S));

            while (map2.get(cur)>S){
                map2.put(nums[st],map2.get(nums[st])-1);
                st++;
            }
            count = sum(map2, S);
            max = Math.max(max, count);
            solve(nums,S,st,left+1,map2,count);
        }

    }

    public Map<Integer,Integer> copy(Map<Integer,Integer> map){
        Map<Integer, Integer> map2 = new HashMap<>();
        for (Integer key : map.keySet()) {
            map2.put(key, map.get(key));
        }
        return map2;
    }

    public int sum(Map<Integer,Integer>map,int S){
        int sum = 0;
        for (Integer n :map.values()) {
            sum+=n>S?0:n;
        }
        return sum;
    }
}
