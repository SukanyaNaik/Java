import java.util.HashMap;
import java.util.Map;


public class LinkedListCycle {

	public static void main(String[] args) {
		ListNode node3 = new ListNode(-4);
	    ListNode node2 = new ListNode(0, node3);
	    ListNode node1 = new ListNode(2, node2);
	    //node3.next = node1;
	    ListNode head = new ListNode(3, node1);
	    
	    boolean isCycle = hasCycle(head);
	    
	    System.out.println("Cycles - " + isCycle);
	}
	
	public static boolean hasCycle(ListNode head) {
		boolean isCycle = false;
		Map <ListNode, Integer> listMap = new HashMap<ListNode, Integer>();
		
		ListNode curr = head;
		while(curr != null && !isCycle) {
			if(listMap.containsKey(curr)) {
				isCycle = true;
			} else {
				int freq = listMap.get(curr) == null? 0 : listMap.get(curr);
				listMap.put(curr, freq + 1);
			}
			curr = curr.next;
		}
        return isCycle;
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
