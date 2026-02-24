import java.util.Stack;

public class RotateList {

	public static void main(String[] args) {
	    ListNode node4 = new ListNode(5);
	    ListNode node3 = new ListNode(4, node4);
	    ListNode node2 = new ListNode(3, node3);
	    ListNode node1 = new ListNode(2, node2);
	    ListNode head = new ListNode(1, node1);

	    int k = 2;
		
//	    ListNode node2 = new ListNode(2);
//	    ListNode node1 = new ListNode(1, node2);
//	    ListNode head = new ListNode(0, node1);
//
//	    int k = 3;
	    
	    ListNode head1 = rotateRight(head, k);
	    
	    ListNode temp = head1;
	    while (temp != null) {
	      System.out.println(temp.val);
	      temp = temp.next;
	    }
	}
	
	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null) return head;

        int length = 1;
        ListNode dummy = head;

        while (dummy.next != null) {
            dummy = dummy.next;
            length++;
        }

        int position = k % length;
        if (position == 0) return head;

        ListNode current = head;
        for (int i = 0; i < length - position - 1; i++) {
            current = current.next;
        }

        ListNode newHead = current.next;
        current.next = null;
        dummy.next = head;

        return newHead;        
    }
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

}
