package FindPeakElement;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int st = 0,end = nums.length-1;
        while (st<end){
            int mid = (end+st)/2;
            if (nums[mid]>nums[mid+1]) {
                if (mid==0) return mid;
                else end=mid;
            }else {
                 st=mid+1;
            }
        }
        return st;
    }

    public int findPeakElement_2(int[] arr) {
        int L = 0,R = arr.length-1;
        while(L<R){
            int mid = L+((R-L)>>1);

            if(arr[mid]<arr[mid+1])
                L=mid+1;
            else
                R=mid;
        }
        return L;
    }

    public static void main(String[] args) {
        FindPeakElement su = new FindPeakElement();
        System.out.println(su.findPeakElement(new int[]{1}));
    }
}
