package FirstBadVersion;

public class FirstBadVersion {
    private int firstBadVersion(int n) {
        return isBinaryTrue(0,n);
    }
    private int isBinaryTrue(int st, int end){
        if(st==end)
            return st;
        int mid = st+(end-st)/2;
        int result = isBadVersion(mid)?isBinaryTrue(st,mid):isBinaryTrue(mid+1,end);
        return result;
    }
    private boolean isBadVersion(int n){
        return n >= 4;
    }

    public static void main(String[] args) {
        FirstBadVersion solution = new FirstBadVersion();
        System.out.println(solution.firstBadVersion(5));
    }
}
