package TopKFrequent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i:nums) {
            if (map.containsKey(i)) map.put(i,map.get(i)+1);
            else map.put(i,1);
        }

        //step2—桶排序
        List<Integer>[] bucket=new List[nums.length+1];//定义足够数量的桶
        for(int key:map.keySet())//按“键”遍历
        {
            int count=map.get(key);//获取数值为key的元素出现的频次
            //把出现频次相同的元素“扔”到序号等于频次的桶中
            if(bucket[count]==null)
                bucket[count]=new ArrayList<Integer>();
            bucket[count].add(key);
        }
        //step3—“逆序”取数据
        for(int i=nums.length;i>0;i--)//注意i的起始值，当数组只有一个数据时
        {
            if(bucket[i]!=null&&res.size()<k)
                res.addAll(bucket[i]);
        }
        return res;
    }
}
