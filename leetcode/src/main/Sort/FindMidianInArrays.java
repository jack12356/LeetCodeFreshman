package Sort;

public class FindMidianInArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int st = 0, end = m, halfLen = (m + n + 1) / 2;
        while (st <= end) {
            int mid = (st + end) / 2;
            int j = halfLen - mid;
            if (mid < end && B[j-1] > A[mid]){
                st = mid + 1; // i is too small
            }
            else if (mid > st && A[mid-1] > B[j]) {
                end = mid - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft;
                if (mid == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[mid-1]; }
                else { maxLeft = Math.max(A[mid-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight;
                if (mid == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[mid]; }
                else { minRight = Math.min(B[j], A[mid]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
