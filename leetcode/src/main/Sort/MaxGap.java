package Sort;
import java.util.*;        //leetcode 164

public class MaxGap {
    public int maximumGap(int []nums)
    {
        if(nums==null||nums.length<2)
        {
            return 0;
        }
        int []result=bucketsort(nums);
        int difference=0;
        for(int i=0;i<result.length-1;i++)
        {
            if((result[i+1]-result[i])>difference)
            {
                difference=(result[i+1]-result[i]);
            }
        }
        return difference;
    }

    public int[] bucketsort(int []nums){
        int []result=new int[nums.length];
        int max=nums[0];
        int min=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<min)
            {
                min=nums[i];
            }
            if(nums[i]>max)
            {
                max=nums[i];
            }
        }
        int bucketlength=(max-min)/(nums.length-1)+1;
        int bucketcount=(max-min)/bucketlength+1;   //桶的个数计算是很重要的

        ArrayList<Integer>[] list=new ArrayList[bucketcount]; //建立二维集合List

        for(int i=0;i<nums.length;i++)
        {
            int number=(int)(Math.floor((nums[i]-min)/bucketlength));
            if(list[number]==null)
            {
                list[number]=new ArrayList<>();
            }

            list[number].add(nums[i]);
        }

        for(int i=0;i<bucketcount;i++) //对每个桶使用Collections.sort()方法进行排序
        {
            if(list[i]!=null) {
                Collections.sort(list[i]);
            }
        }

        int k=0;
        for(int i=0;i<bucketcount;i++)
        {
            if(list[i]!=null) {
                for (int j = 0; j < list[i].size(); j++) {
                    result[k] = (int) list[i].get(j);
                    k++;
                }
            }
        }

        return result;

    }


    public static void main(String []agrs)
    {
        MaxGap test=new MaxGap();

        int []nums={5,10,3,2,1,23,21};
        // int []nums={2,99999999};
        //int []nums={1,2,3,4,5,6,7,8,9};
        //int []nums={63,157,189,51,101,47,141,121,157,156,194,117,98,139,67,133,181,13,28,109};
        int max=test.maximumGap(nums);
        System.out.println("max="+max);
    }
}