import java.util.HashMap;
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();
        int max = 0;
        for (int n:nums) {
            if (map.containsKey(n)) continue;
            int left = map.getOrDefault(n-1,0);
            int right = map.getOrDefault(n+1,0);
            map.put(n,left+right+1);
            map.put(n-left,left+right+1);
            map.put(n+right,left+right+1);
            max = Math.max(left+1+right,max);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestConsecutive su = new LongestConsecutive();
        int [] nums = new int[]{100, 4, 200, 1, 3, 2,202,201,204,203};
        System.out.println(su.longestConsecutive(nums));
    }
}
