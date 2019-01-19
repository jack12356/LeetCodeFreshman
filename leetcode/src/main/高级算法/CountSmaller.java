import java.util.*;

public class CountSmaller {
    public List<Integer> countSmaller(int[] nums) {
        //排序数组
        List<Integer> temp = new ArrayList<>();
        //结果数组
        Integer[] res = new Integer[nums.length];

        //原数组从后向前遍历，根据二分法升序插入到新数组
        for(int i=nums.length-1;i>=0;i--){
            int left = 0,right = temp.size();
            while(left<right){
                int mid =left+(right-left)/2;
                if(temp.get(mid)>=nums[i]){
                    right = mid;
                }else{
                    left = mid+1;
                }
            }
            //新数组对应位置的下标即为原数组右侧小于该数的个数
            res[i] = left;
            temp.add(left,nums[i]);
        }
        return Arrays.asList(res);
    }

    public List<Integer> countSmaller_insert(int[] nums) {
        //排序数组
//        List<Integer> temp = new ArrayList<>();
        int []temp = new int[nums.length];
        //结果数组
        Integer[] res = new Integer[nums.length];
        int size = 0;
        //原数组从后向前遍历，根据二分法升序插入到新数组
        for(int i=nums.length-1;i>=0;i--){
            int insert_num = nums[i];
            int index = size-1;
            for (; index >=0 ; index--) {
                if (insert_num<=temp[index]) temp[index+1] = temp[index];
                else break;
            }
            temp[index+1] = insert_num;
            size++;
            //新数组对应位置的下标即为原数组右侧小于该数的个数
            res[i] = index + 1;
        }
        return Arrays.asList(res);
    }
}
