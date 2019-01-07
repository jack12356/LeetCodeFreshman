package MergeTwoList;

public class MergeTwoList {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j=n-1;
        int n1,n2;
        while(i>=0&&j>=0){
            n1 = nums1[i];
            n2 = nums2[j];
            if(n1>n2){
                nums1[i+j+1]=n1;
                i--;
            }else{
                nums1[i+j+1]=n2;
                j--;
            }
        }
        if(i<0){
            while(j>=0){
                nums1[j]=nums2[j];
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int []nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int []nums2 = new int[]{2,5,6};
        int n = 3;

        MergeTwoList solution = new MergeTwoList();
        solution.merge(nums1,m,nums2,n);
    }
}
