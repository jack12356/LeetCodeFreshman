public class CopyRandomList {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode st = new RandomListNode(-1);
        RandomListNode rln = st;
        RandomListNode end = head;
        while (end != null) {
            rln.next = new RandomListNode(end.label);
            rln = rln.next;
            end = end.next;
        }
        end = head;
        rln = st.next;
        while (end != null) {
            //如果其random不等于空，说明指向前面或者后面某个节点
            if (end.random != null) {
                RandomListNode findrand = end.random;
                RandomListNode fast = st.next;
                RandomListNode slow = st.next;
                while (findrand!=null&&findrand!=end){
                    findrand = findrand.next;
                    fast = fast.next;
                }
                if(findrand==end) findrand = rln;
                while (fast != findrand) {
                    slow = slow.next;
                    fast = fast.next;
                }
                //此时slow就是之前的random指向的节点
                rln.random = slow;
            }
            end = end.next;
            rln = rln.next;
        }
        return st.next;
    }
}
