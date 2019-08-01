import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        Deque<int[]> queue = new LinkedList<>();
        Collections.addAll(queue, matrix);
        while (queue.size()!=1){
            int[] nums1 = queue.poll();
            int[] nums2 = queue.poll();
            queue.add(merge(nums1, nums2));
        }
        return queue.poll()[k-1];
    }
    public int[] merge(int[]nums1,int[]nums2){
        int[]res = new int[nums1.length+nums2.length];
        int st1=0,st2=0,i=0;
        while(st1<nums1.length&&st2<nums2.length){
            if(nums1[st1]>nums2[st2]) res[i++] = nums2[st2++];
            else res[i++] = nums1[st1++];
        }
        if(st1==nums1.length) for (int j = st2; j < nums2.length; j++) res[i++] = nums2[j];
        else for (int j = st1; j < nums1.length; j++) res[i++] = nums1[j];
        return res;
    }

    public static void main(String[] args) {
        KthSmallest su = new KthSmallest();
        int [] nums1 = new int[]{1,2,3,4,5};
        int [] nums2 = new int[]{6,7,8,9,10};
        int [] nums3 = new int[]{11,12,13,14,15};
        int [] nums4 = new int[]{16,17,18,19,20};
        int [] nums5 = new int[]{21,22,23,24,25};
        int[][]matrix = new int[5][];
        matrix[0] = nums1;
        matrix[1] = nums2;
        matrix[2] = nums3;
        matrix[3] = nums4;
        matrix[4] = nums5;
        System.out.println(su.kthSmallest(matrix, 25));
    }
}
