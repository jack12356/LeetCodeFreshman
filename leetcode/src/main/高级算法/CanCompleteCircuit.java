public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int []reach = new int[len];     //最远能跑多少个站
        int []lastGas = new int[len];   //剩下多少油 假设为0
        for(int i =0;i<len;i++) reach[i] = -1;
        return farIndex(gas,cost,reach,lastGas);
    }

    public int farIndex(int []gas,int []cost,int []reach,int []lastGas){
        int len = gas.length;
        for(int cur = 0;cur<len;cur++){
            int preGas = 0;
            int next = cur;
            while(next<cur+len){
                if(reach[next%len]>0){    //已经处理过的子问题
                    preGas = preGas + lastGas[next%len];
                    next = reach[next%len]+next;
                    continue;
                }
                int sub = preGas + gas[next%len]-cost[next%len];
                if(sub>=0) {
                    next++;
                    preGas = sub;
                }
                else break;
            }
            lastGas[cur] = preGas;
            if(next>=cur+len){
                reach[cur] = len;
                return cur;             //到达自己
            }else{
                reach[cur] = next-cur;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CanCompleteCircuit test = new CanCompleteCircuit();
        int []gas = new int[]{5,1,2,3,4};
        int cost[] = new int[]{4,4,1,5,1};
        test.canCompleteCircuit(gas,cost);
    }
}
