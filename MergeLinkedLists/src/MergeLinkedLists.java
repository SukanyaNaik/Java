import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeLinkedLists {

	public static void main(String[] args) {
		ListNode node12 = new ListNode(4, null);
		ListNode node11 = new ListNode(2, node12);
		ListNode head1 = new ListNode(1, node11);
		
		ListNode node22 = new ListNode(5, null);
		ListNode node21 = new ListNode(3, node22);
		ListNode head2 = new ListNode(1, node21);
		
		ListNode node31 = new ListNode(6, null);
		ListNode head3 = new ListNode(3, node31);
		//[[1,4,5],[1,3,4],[2,6]]
//		ListNode node12 = new ListNode(5, null);
//		ListNode node11 = new ListNode(4, node12);
//		ListNode head1 = new ListNode(1, node11);
//		
//		ListNode node22 = new ListNode(4, null);
//		ListNode node21 = new ListNode(3, node22);
//		ListNode head2 = new ListNode(1, node21);
//		
//		ListNode node31 = new ListNode(6, null);
//		ListNode head3 = new ListNode(2, node31);
		
		ListNode [] lists = {head1, head2, head3};
		
		ListNode result = mergeKLists(lists);
		
		ListNode temp = result;
	    while (temp != null) {
	      System.out.print(temp.val + " ");
	      temp = temp.next;
	    }
	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
		List<Integer> nodes = new ArrayList<>();
        for (ListNode lst : lists) {
            while (lst != null) {
                nodes.add(lst.val);
                lst = lst.next;
            }
        }
        Collections.sort(nodes);
        
        ListNode head = new ListNode(0);
        ListNode curr = head;
        ListNode temp = null;
        for(int i = 0; i < nodes.size(); i++) {
        	curr.val = nodes.get(i);
        	if(i < nodes.size()-1) {
	        	temp = new ListNode();
	        	curr.next = temp;
	        	curr = temp;
        	}
        }
        
        return head;
	}
	
//	public static ListNode mergeKLists(ListNode[] lists) {
//		ListNode head = null, prev1 = null, prev2 = null;
//		
//		for(int l = 0; l < lists.length-1; l++) {
//			ListNode head1 = lists[l];
//			ListNode head2 = lists[l+1];
//			
//			if(head == null) {
//				head = head1;
//			}
//			
//			prev1 = head1;
//			prev2 = head2;
//			
//			if(head1.next == null) {
//				if(head1.val <= head2.val) {
//					prev1.next = head2;
//					return head;
//				}
//				else {
//					if(head2.next == null && head2.val < head1.val) {
//						head = head2;
//						head2.next = head1;
//						return head;
//					}
//					ListNode curr2 = head2.next;
//					while(curr2 != null && curr2.val < head1.val) {
//						prev2 = curr2;
//						curr2 = curr2.next;
//					}
//					
//					prev2.next = head1;
//					head1.next = curr2;
//				}
//			} else if(head2.next == null) {
//				if(head2.val <= head1.val) {
//					prev2.next = head1;
//					head = head2;
//				}
//				else {
//					if(head1.next == null && head1.val < head2.val) {
//						head = head1;
//						head1.next = head2;
//						return head;
//					}
//					ListNode curr1 = head1.next;
//					while(curr1 != null && curr1.val < head2.val) {
//						prev1 = curr1;
//						curr1 = curr1.next;
//					}
//					
//					prev1.next = head2;
//					head2.next = curr1;
//				}
//			} else {
//				ListNode curr1 = null;
//				ListNode curr2 = null;
//				
//				if(prev1.val > prev2.val) {
//					head = head2;
//				} else {
//					head = head1;
//				}
//				
//				if(head1.next != null) {
//					curr1 = head1.next;
//				}
//				if(head2.next != null) {
//					curr2 = head2.next;
//				}
//				while(prev1 != null && prev2 != null) {
//					if(prev1.val > prev2.val) {
//						if(prev2.next != null && prev1.val < prev2.next.val ) {
//							prev2.next = prev1;
//							prev1.next = curr2;
//							prev2 = curr2;
//							//if(curr2.next != null)
//								curr2 = curr2.next;
//							prev1 = curr1;
//							//if(curr1.next != null)
//								curr1 = curr1.next;
//						} else {
//							while(curr2 != null && curr2.val > prev1.val) {
//								prev2 = curr2;
//								curr2 = curr2.next;
//							}
//							
//							ListNode temp = null;
//							if(prev1.next != null)
//								temp = prev1.next;
//							
//							prev2.next = prev1;
//							//prev1.next = curr2; //*//
//							prev1 = temp;
//							curr1 = prev1.next;
//						}
//					} else if(prev1.val <= prev2.val) {
//						if(prev1.next != null && prev2.val < prev1.next.val ) {
//							prev1.next = prev2;
//							prev2.next = curr1;
//							prev1 = prev2;
//							//if(curr1.next != null)
//								//curr1 = curr1.next; //&//
//							prev2 = curr2;
////							if(curr2.next != null)
//								curr2 = curr2.next;
//						} else {
//							while(curr1 != null && curr1.val <= prev2.val) {
//								prev1 = curr1;
//								curr1 = curr1.next;
//							}
//							
//							ListNode temp = null;
//							if(prev1.next != null)
//								temp = prev2.next;
//							
//							prev1.next = prev2;
//							prev2.next = curr1; //*//
//							prev2 = temp;
//							prev1 = prev2;
//
//						}
//					} else if(prev1.val == prev2.val) {
//						prev1 = curr1;
//						curr1 = curr1.next;
//						prev2 = curr2;
//						curr2 = curr2.next;
//					}
//				}
//				
//			}
//			
//			ListNode []lists1 = new ListNode[lists.length-1];
//			lists1[0] = head;
//			for (int j = 1, l1 = l+2; l1 < lists.length; j++, l1++) {
//				lists1[j] = lists[l1];
//			}
//			lists = lists1;
//			l = -1;
//		}
//		return head;
//    }
	
	static class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}
