public class MaxArea {
    public int maxArea(int[] height) {
        int left = 0, rt = height.length - 1;
        int lf_max = height[0];
        int rt_max = height[height.length - 1];
        int res = Math.min(rt_max,lf_max)*(height.length-1);
        while (left<rt){
            while (lf_max >= rt_max && left < rt) {
                rt--;
                if (height[rt] > rt_max) {
                    rt_max = height[rt];
                    res = Math.max((rt - left) * Math.min(rt_max, lf_max), res);
                }
            }
            while (lf_max < rt_max && left < rt) {
                left++;
                if (height[left]>lf_max){
                    lf_max = height[left];
                    res = Math.max((rt - left) * Math.min(rt_max, lf_max), res);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxArea su = new MaxArea();
        int[] heights = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(su.maxArea(heights));
    }
}
