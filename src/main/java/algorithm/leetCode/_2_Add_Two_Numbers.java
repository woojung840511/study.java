package algorithm.leetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _2_Add_Two_Numbers {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1,
            new ListNode(6));


        ListNode l2 = new ListNode(6,
            new ListNode(4,
                new ListNode(1)));


        // 146
        //  61
        // 207

        ListNode listNode = new _2_Add_Two_Numbers().addTwoNumbers(l1, l2);
        System.out.println();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int l1Val = l1.val;
        int l2Val = l2.val;
        int sum = l1Val + l2Val;
        int val;
        boolean gt10;
        List<Integer> list = new ArrayList<>();

        do {
            gt10 = sum >= 10;
            val = (sum >= 10) ? sum % 10 : sum;
            System.out.println("val = " + val); // 7 0 8
            list.add(val);

            if (l1.next != null) {
                l1 = l1.next;
                l1Val = l1.val;
            } else {
                l1Val = 0;
            }

            if (l2.next != null) {
                l2 = l2.next;
                l2Val = l2.val;
            } else {
                l2Val = 0;
            }

            sum = (gt10 ? 1 : 0) + l1Val + l2Val;


        } while (sum > 0 || l1.next != null || l2.next != null);

        return getListNode(list);
    }

    public ListNode getListNode(List<Integer> list) {

        Iterator<Integer> iterator = list.iterator();
        int val = iterator.next();
        iterator.remove();

        if (iterator.hasNext()) {
            return new ListNode(val, getListNode(list));
        } else {
            return new ListNode(val);
        }

    }


}

class ListNode {

    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


