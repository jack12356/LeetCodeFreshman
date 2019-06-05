public class ModY {
    public static void main(String[] args) {
        int x = 2;
        int y = 7;
        System.out.println(get_res1(x,y));
    }
    private static int get_res1(int x, int y){
        int count = 1;      //代表2的x次幂
        int res = 1;
        while (x>0){
            while (count < Integer.MAX_VALUE / 2 && x>0) {   //不溢出
                count <<= 1;
                x--;
            }
            if(x==0) {      //求出了 count= 2的x次幂 并且不溢出
                res = (res * get_2_count_mod_y(count, y)) % y;
                return res;
            }
            else{   // 如果count*2会溢出,先处理了count
                res = (res * get_2_count_mod_y(count, y)) % y;      // (k*m)%s = ((k%s)*(m%s))%s, 这里的res代表上一步 k%s
                count = 1;
            }
        }
        return res;
    }
    private static int get_2_count_mod_y(int count, int y) {
        // 返回 (2的count次幂)%y的值 , 如果不考虑count会溢出的话，直接将count赋值为1<<x就可以返回结果
        int res = 1;
        while (count>0){
            while(res<y&&count>0){
                res = res << 1;
                count--;
            }
            if(res<y) {
                return res;
            }else{            //此时m>y
                res = res % y;      // (k*r)%s = [ k*(r/s)*s + k*(r%s) ]  %s = [k*(r%s)] % s ,所以可以 r = r%s
            }
        }
        return res;
    }
}
