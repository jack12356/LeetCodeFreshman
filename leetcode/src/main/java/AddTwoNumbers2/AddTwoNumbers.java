package AddTwoNumbers2;

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/

public class AddTwoNumbers {
    public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }
    public static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode startNode = null;
            ListNode endNode = null;
            ListNode tempNode = new ListNode(0);
            int n = 0;
            boolean flag = false;
            while ((l1 != null) || (l2 != null) || (tempNode.val != 0)) {
                //判断首次相加
                if (!flag) {
                    int k = l1.val + l2.val;
                    if (k >= 10) {
                        startNode = new ListNode(k % 10);
                        tempNode = new ListNode(k / 10);
                    } else {
                        startNode = new ListNode(k);
                    }
                    //赋内存地址
                    endNode = startNode;
                    flag = !flag;
                    l1 = l1.next;
                    l2 = l2.next;
                    continue;
                }
                //判断大于10
                if (l1 == null || l2 == null) {
                    if (l1 == null) {
                        if (l2 == null) {
                            n = tempNode.val;
                        }else  n = tempNode.val + l2.val;
                    }else n = tempNode.val + l1.val;
                }else n = tempNode.val + l1.val + l2.val;

                tempNode.val = 0;
                if (n >= 10) {
                    endNode.next = new ListNode(n % 10);
                    tempNode = new ListNode(n / 10);
                } else
                    endNode.next = new ListNode(n);
                //endNode总是为最后一个Node
                endNode = endNode.next;
                if (l1!=null)l1 = l1.next;
                if (l2!=null)l2 = l2.next;
            }
            return  startNode;
        }
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(8);
//        l2.next.next = new ListNode(4);

        Solution solution = new Solution();
        ListNode resultNode = solution.addTwoNumbers(l1,l2);
        while (resultNode!=null){
            System.out.print(resultNode.val+"--->");
            resultNode = resultNode.next;
        }
    }
}
