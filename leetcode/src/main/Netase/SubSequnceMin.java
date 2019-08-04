import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class SubSequnceMin {
    public static void main(String[] args) {
        int b = 6;
        int a = 4;
        System.out.printf("a is : %d\n",a);
        System.out.printf("b is : %d\n",b);
        System.out.printf("%3f",(double)a/(double)b);
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();
//        }
//        for (int i = 1; i < n+1; i++) {
//            int min = MinInSubSequence(nums, i);
//            System.out.print(min + " ");
//        }
    }

    private static int MinInSubSequence(int[] nums, int K) {
        int min = Integer.MAX_VALUE;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < K-1; i++) {
            int n = nums[i];
            while (!deque.isEmpty() && n > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.add(i);
        }
        for (int i = K-1; i < nums.length; i++) {
            if (!deque.isEmpty() && i - deque.peekFirst() >= K) {
                deque.pollFirst();
            }
            int n = nums[i];
            while (!deque.isEmpty() && n > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.add(i);
            min = Math.min(min, nums[deque.peekFirst()]);
        }
        return min;
    }
}
