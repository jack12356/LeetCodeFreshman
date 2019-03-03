package Intersect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution{
    public int[] intersect(int []nums1,int []nums2){
        Set<Integer> set1 = new HashSet(Arrays.asList(nums1));
        Set<Integer> set2 = new HashSet(Arrays.asList(nums2));
        set1.retainAll(set2);
        int []result = new int[set1.size()];
        int index=0;
        for(Integer n:set1){
            result[index++] = n;
        }
        return result;
    }
}