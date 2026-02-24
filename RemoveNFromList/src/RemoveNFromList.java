public class RemoveNFromList {

	public static void main(String[] args) {
//		ListNode node7 = new ListNode(6, null);
//	    ListNode node6 = new ListNode(5, node7);
//	    ListNode node5 = new ListNode(4, node6);
//	    ListNode node4 = new ListNode(4, node5);
//	    ListNode node3 = new ListNode(3, node4);
//	    ListNode node2 = new ListNode(3, node3);
//	    ListNode node1 = new ListNode(2, node2);
//	    ListNode head = new ListNode(1, node1);
		
//		ListNode node1 = new ListNode(2, null);
//	    ListNode head = new ListNode(1, node1);
	    int n = 1;
	    ListNode node3 = new ListNode(4, null);
	    ListNode node2 = new ListNode(3, node3);
	    ListNode node1 = new ListNode(2, node2);
	    ListNode head = new ListNode(1, node1);
	    
	    ListNode head1 = removeNthFromEnd(head, n);
	    ListNode temp = head1;
	    while (temp != null) {
	      System.out.println(temp.val);
	      temp = temp.next;
	    }
	}
	
	 public static ListNode removeNthFromEnd(ListNode head, int n) {

        	ListNode curr = head;
        	int len = 0;
        	while(curr != null) {
        		curr = curr.next;
        		len++;
        	}
        	
        	if(n > len) {
        		int temp = n - len;
        		n = len - temp;
        	} else if (n < len) {
        		n = len - n;
        	}
        
        	if(n == len){
	            if(head.next != null)
	                head = head.next;
	            else
	                head = null;
	            return head;
        	}
        	ListNode prev = head;
            curr = head.next;
            for(int i = 1; i < n && curr != null; i++) {
                prev = curr;
                curr = curr.next;
            }
            if(curr != null) {
                if(curr.next != null)
                    prev.next = curr.next;
                else
                    prev.next = null;
            } else {
                prev.next = null;
            }

	        return head;
	    }
	
	static class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

}
