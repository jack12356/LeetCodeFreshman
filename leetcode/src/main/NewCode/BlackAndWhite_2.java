
public class BlackAndWhite_2 {
    //n行m列，x，y数组代表4个矩形点坐标的x，y位置
    public static int[] nums(int n,int m,int[] x,int[] y){
        int[] res = new int[2];//返回值  res[o]白方块的数量,res[1]为黑的
        int black = n * m / 2;//当总方块数是偶数，黑白各一半；为奇数时，白方块多一个
        int white = n * m - black;
        int a,b,c,d,e;

        //第一步将(x0,y0),(x1,y1)矩形内的方块都涂白，也就是计算出黑方块的个数d，
        // 将白方块个数+d,黑方块-d
        if(((x[0] + y[0]) & 1) == 1)//x，y坐标位置和为奇数，则起始位置是黑方块
            //如果矩形中方块数为奇数，则黑方块多一个
            d = ((x[1] - x[0] + 1) * (y[1] - y[0] + 1) + 1) / 2;
        else
            //否则，黑白个数一样
            d = ((x[1] - x[0] + 1) * (y[1] - y[0] + 1)) / 2;
        white += d;
        black -= d;

        //第二步将(x2,y2),(x3,y3)矩形内的方块都涂黑，也就是计算出白方块的个数d，
        // 将白方块个数-d,黑方块+d
        if(((x[2] + y[2]) & 1) == 0)//x，y坐标位置和为奇数，则起始位置是黑方块
            //如果矩形中方块数为奇数，则白方块多一个
            d = ((x[3] - x[2] + 1) * (y[3] - y[2] + 1) + 1) / 2;
        else
            //否则，白黑个数一样
            d = ((x[3] - x[2] + 1) * (y[3] - y[2] + 1)) / 2;
        white -= d;
        black += d;

        //第三步，找到两个矩形的公共部分，该部分中在第一步将所有方块涂白了，
        // 而第二步计算依然按照没涂白之前的计算，也就是少算了第一步之前的黑方块个数
        //也就是第一步多计算的白方块e，
        //最后白方块个数-e，黑方块个数+e
        a = Math.max(x[0],x[2]);
        b = Math.max(y[0],y[2]);
        c = Math.min(x[1],x[3]);
        d = Math.min(y[1],y[3]);
        if(c < a || d < b)//没有公共部分
            e = 0;
        else{
            if(((a + b) & 1) == 1)//x，y坐标位置和为奇数，则起始位置是黑方块
                //如果矩形中方块数为奇数，则黑方块多一个
                e = ((c - a + 1) * (d - b + 1) + 1) / 2;
            else
                //否则，黑白个数一样
                e = ((c - a + 1) * (d - b + 1)) / 2;
        }
        white -= e;
        black += e;
        res[0] = white;
        res[1] = black;
        return res;
    }

    public static void main(String[] args) {
        int times = 3;
        int[] n = new int[]{1,3,3};
        int[] m = new int[]{3,3,4};
        int[][][] xAndY = new int[][][]{{{1,1,1,1},{1,3,1,3}},{{1,2,2,3},{1,3,1,3}},
                {{2,2,1,3},{1,3,2,3}}};
        for (int i = 0;i < times;i++){
            int[] res = nums(n[i],m[i],xAndY[i][0],xAndY[i][1]);
            System.out.println(res[0]+","+res[1]);
        }
    }

}