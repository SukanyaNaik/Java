
public class RemoveFromList {

  public static void main(String[] args) {
    ListNode node7 = new ListNode(6, null);
    ListNode node6 = new ListNode(5, node7);
    ListNode node5 = new ListNode(4, node6);
    ListNode node4 = new ListNode(4, node5);
    ListNode node3 = new ListNode(3, node4);
    ListNode node2 = new ListNode(3, node3);
    ListNode node1 = new ListNode(2, node2);
    ListNode head = new ListNode(1, node1);

    ListNode head1 = deleteDuplicates(head);
    ListNode temp = head1;
    while (temp != null) {
      System.out.println(temp.val);
      temp = temp.next;
    }

  }

  public static ListNode deleteDuplicates(ListNode head) {
	  ListNode prev = head;
	  ListNode curr = null;
	  
	  if(prev.next != null) {
		curr = prev.next;
		
		while (curr != null && prev.val == curr.val) {
			prev = curr;
			curr = curr.next;
		}
		if(prev != head) {
			head = curr;
		}
		
		while (curr.next != null) {
			if (curr.val != curr.next.val) {
				prev = curr;
				curr = curr.next;
			}
			else {
				while (curr != null && curr.val == curr.next.val) {
					curr = curr.next;
				}
				if(curr.next != null) {
					prev.next = curr.next;
					curr = curr.next;
				} else {
					prev.next = null;
				}
			}
		}
		
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
