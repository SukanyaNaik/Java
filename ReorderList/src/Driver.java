import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
//		ListNode node6 = new ListNode(6, null);
//		ListNode node5 = new ListNode(5, node6);
//		ListNode node4 = new ListNode(4, node5);
//		ListNode node3 = new ListNode(3, node4);
//		ListNode node2 = new ListNode(2, node3);
//		ListNode node1 = new ListNode(1, node2);
//		ListNode head = new ListNode(0, node1);
		
		ListNode node3 = new ListNode(8, null);
		ListNode node2 = new ListNode(6, node3);
		ListNode node1 = new ListNode(4, node2);
		ListNode head = new ListNode(2, node1);
		
		reorderList(head);
		
		ListNode temp = head;
	    while (temp != null) {
	      System.out.print(temp.val + " ");
	      temp = temp.next;
	    }
	}
	
	public static void reorderList(ListNode head) {
        ListNode curr = head;
        List<Integer> nodes = new ArrayList<>();
        while(curr != null) {
        	nodes.add(curr.val);
        	curr = curr.next;
        }
        
        curr = head;
        for(int j = 0, k = nodes.size()-1; j <= (nodes.size()-1) / 2; j++, k--) {
        	if(curr != null)
        		curr.val = nodes.get(j);
        	
        	curr = curr.next;
        	
        	if(curr != null) {
        		curr.val = nodes.get(k);
        		curr = curr.next;
        	}
        }
    }

	static class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}
