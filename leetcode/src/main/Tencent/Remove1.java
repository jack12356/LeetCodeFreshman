package Tencent;

import java.util.*;

public class Remove1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }
            canRemove(nums);
        }
    }

    private static void canRemove(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer n : map.values()) {
            if (n > nums.length / 2) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
