package PinDuoDuo;

import java.util.*;

/*
每次更新一对起点和终点，然后计算移动次数；
比如1 2 995 998，先拿1~998，计算都往1~998的某个区间移动步数，
然后把998变为-2，计算-2~995的区间移动步数，
每次计算移动步数时间为O(n)，一共更新比较n次，然后就O(n^2)
 */
public class MoveDiamond {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int res = solve(L, nums);
        System.out.println(res);
    }

    private static int solve(int L, int []nums) {
        Arrays.sort(nums);
        List<Integer> list = new LinkedList<>();
        for (int num : nums) list.add(num);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int last = list.get(list.size()-1);
            list.remove(list.size() - 1);
            last = last - L;
            list.add(0,last);
            min = Math.min(min, getMove(list));
//            System.out.print(list.toString()+" -> "+min+"\n");
        }
        return min;
    }

    private static int getMove(List<Integer> nums) {
        int st = 0;
        int end = nums.size()-1;
        int res = 0;
        int cnt = 0;
        while (st<end){
            int move = nums.get(end) - nums.get(st) - (nums.size() - 2 - cnt) - 1;
            res += move;
            cnt += 2;
            st++;
            end--;
        }
        return res;
    }
}