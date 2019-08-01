public class CopyRandomList {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode st = new RandomListNode(-1);
        RandomListNode rln;
        RandomListNode end = head;
        st.next = head;
        //复制影子节点
        while (end != null) {
            rln = new RandomListNode(end.label);
            rln.next = end.next;
            end.next = rln;
            end = end.next.next;
        }
        st.next = st.next.next;
        //复制random节点
        end = head;
        rln = st.next;
        while (end != null) {
            //如果其random不等于空，说明指向前面或者后面某个节点
            if (end.random != null) rln.random = end.random.next;
            end = end.next.next;
            if (rln.next != null) rln = rln.next.next;
        }
        //去掉影子连接
        end = head;
        rln = st.next;
        while (end != null) {
            end.next = end.next.next;
            if (rln.next != null) rln.next = rln.next.next;
            end = end.next;
            rln = rln.next;
        }
        return st.next;
    }

    public static void main(String[] args) {
        RandomListNode r1 = new RandomListNode(-1);
        RandomListNode r2 = new RandomListNode(1);
        r1.next = r2;
        new CopyRandomList().copyRandomList(r1);
    }
}
