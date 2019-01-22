public class Trap {
    public int trap(int[] height) {
        return trap_index(height,0,height.length-1);
    }
    public int trap_index(int[] height,int l,int r) {
        int left = l, right = r;
        while (left <= r && height[left] == 0) left++;
        while (right >= l && height[right] == 0) right--;
        if (left>=right) return 0;
        int area=0,pl=left;
        while (pl <= right) {
            if (height[pl]>0) height[pl]--;
            else area++;
            pl++;
        }
        area += trap_index(height,left,right);
        return area;
    }

    public int trap_n2(int[] height) {
        int left = 0, right = height.length-1;
        int res = 0;
        int cur = left + 1;

        while (cur<=right){
            if (height[cur]<height[left]) cur++;
            else {
                for (int k = left+1; k < cur; k++) {
                    res += height[left] -  height[k];
                }
                left = cur;
                cur = left + 1;
            }
        }
        if (left<right){
            cur = right-1;
            while (cur>=left){
                if (height[cur]<height[right]) cur--;
                else {
                    for (int k = cur+1; k < right; k++) {
                        res += height[right] -  height[k];
                    }
                    right = cur;
                    cur = right - 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int []height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        Trap su = new Trap();
        su.trap_n2(height);
    }
}
