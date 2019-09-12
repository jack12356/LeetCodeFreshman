public class Test {
//    public static void main(String[] args) {
//        int n = 6;
////        int[] a = new int[]{5,1,3,0,1,4};
//        int[] a = new int[]{6,2,4,1,2,5};
//        int i = 0;
//
////        while (i<n){
////            int temp = a[i] - 1;
////            if(a[temp]!=temp){
////                i++;
////                continue;
////            }else if(a[temp]<=0){
////                a[temp] = -1;
////            }else {
////                a[i] = 0;
////
////            }
////        }
//
//        while (i<n){
//            int temp = a[i] - 1;
//            if(temp<0){
//                i++;
//                continue;
//            }else if(a[temp]<=0){
//                a[temp]--;
//                i++;
//                continue;
//            }if(a[temp]>0){
//                swap(a,i,temp);
//                a[temp] = 0;
//            }
//        }
//
////        int[] r = new int[a.length];
////        for (int j = 0; j < a.length; j++) {
////            r[j] = a[j];
////        }
////        for (int value : a) {
////            if (r[value - 1] <= 0) {
////                r[value - 1]--;
////            } else {
////                r[value - 1] = 0;
////            }
////        }
////        for (int j = 0; j < n; j++) {
////            System.out.println((j+1) +" repeated : "+(-r[j]>0?-r[j]:0));
////        }
//        for (int j = 0; j < n; j++) {
//            System.out.println((j+1) +" repeated : "+(-a[j]>=0?-a[j]+1:0));
//        }
//    }
    public static void main(String[] args) {
        int [] a = new int[]{6, 2, 4, 1, 2, 5};
        int n = a.length;
        // add n on it's location
        for (int index : a) {
            a[(index - 1) % n] += n;
        }
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + " repeated : " +  (a[i] - 1) / n);
        }
    }
}
