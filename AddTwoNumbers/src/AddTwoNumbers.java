//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class AddTwoNumbers {
    public static void main(String[] args) {
        System.out.println("Test");
        ListNode l1n1 = new ListNode(9);
        //ListNode l1n2 = new ListNode(4);
        //ListNode l1n3 = new ListNode(3);
        l1n1.next = null;
        //l1n1.next = l1n2;
        //l1n2.next = l1n3;

        //[1,9,9,9,9,9,9,9,9,9]
        ListNode l2n1 = new ListNode(1);
        ListNode l2n2 = new ListNode(9);
        ListNode l2n3 = new ListNode(9);
        ListNode l2n4 = new ListNode(9);
        ListNode l2n5 = new ListNode(9);
        ListNode l2n6 = new ListNode(9);
        ListNode l2n7 = new ListNode(9);
        ListNode l2n8 = new ListNode(9);
        ListNode l2n9 = new ListNode(9);
        ListNode l2n10 = new ListNode(9);
        l2n1.next = l2n2;
        l2n2.next = l2n3;
        l2n3.next = l2n4;
        l2n4.next = l2n5;
        l2n5.next = l2n6;
        l2n6.next = l2n7;
        l2n7.next = l2n8;
        l2n8.next = l2n9;
        l2n9.next = l2n10;
        ListNode result = addTwoNumbers(l1n1, l2n1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long val1 = l1.val;
        long factor = 10;
        while (l1.next != null) {
            l1 = l1.next;
            long temp = 0;
            if (val1 != 0)
                temp = l1.val * factor;
            val1 = temp + val1;
            factor = factor * 10;
        }

        long val2 = l2.val;
        factor = 10;
        while (l2.next != null) {
            l2 = l2.next;
            long temp = l2.val * factor;
            val2 = temp + val2;
            factor = factor * 10;
        }

        long val3 = val1 + val2;
        ListNode head = null, n1 = null , n2 = null;
        if (val3 == 0) {
            head = new ListNode(val3);
        }
        while (val3 != 0) {
            long temp = val3 % 10;
            if (n1 == null) {
                n1 = new ListNode(temp);
                head = n1;
            }
            else {
                n2 = new ListNode(temp);
                n1.next = n2;
                n1 = n2;
            }
            val3 = val3 / 10;
        }
        return head;
    }
}

class ListNode {
     long val;
     ListNode next;
     ListNode() {}
     ListNode(long val) { this.val = val; }
     ListNode(long val, ListNode next) { this.val = val; this.next = next; }
}
