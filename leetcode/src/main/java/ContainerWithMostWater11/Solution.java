package ContainerWithMostWater11;

public class Solution {
    public int maxArea(int[] height) {
        int maxarea = 0;
        int len = height.length;
        int tempMaxi = height[0];
        for (int i = 0; i < len - 1; i++) {
            if (height[i] < tempMaxi) continue;
            tempMaxi = height[i];
            int tempMaxHeight = height[len - 1];
            int tempCompare = (tempMaxi==0)? i: (maxarea / tempMaxi)+i;
            for (int j = len - 1; j > tempCompare; j--) {
                if (height[j] >= tempMaxHeight) {
                    tempMaxHeight = height[j];
                    maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
                }
            }
        }
        return maxarea;
    }

    public int maxAreaByLeetCode(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            if(height[left] > height[right]){
                if(maxArea < height[right] * (right - left))
                    maxArea = height[right] * (right - left);
                right --;
            }else{
                if(maxArea < height[left] * (right - left))
                    maxArea = height[left] * (right - left);
                left ++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int []height = new int [10];
        for (int i = 0; i < 10; i++) {
            height[i] = 10 - i;
        }
        System.out.println(solution.maxArea(height));
    }
}
