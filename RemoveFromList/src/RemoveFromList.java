/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import java.util.HashMap;
import java.util.Map;

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
    while (temp.next != null) {
      System.out.println(temp.val);
    }

  }

  public static ListNode deleteDuplicates(ListNode head) {
    ListNode temp = head;
    Map <Integer, Integer> valueMap = new HashMap<>();

    while(temp.next != null) {
      if (valueMap.containsKey(temp.val)) {
        valueMap.put(temp.val, valueMap.get(temp.val) + 1);
      } else {
        valueMap.put(temp.val, 1);
      }
    }


    ListNode prev = head;
    temp = head.next;
    if (temp != null) {
      while(temp.next != null) {
        for (Map.Entry <Integer, Integer> entry : valueMap.entrySet())
        {
          if(entry.getKey() == temp.val){
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
              temp = temp.next;
            }
            prev.next = temp;
          }
        }
        prev = temp;
        temp = temp.next;
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

/*
for(Integer key : value.keySet())
            {
                if(key == temp.val)
                {
                    value.put()
                    //ListNode temp1 = temp.next;
                    //temp.next = temp1.next;
                    break;
                }
            }
            if(found == false)
            {
                value.put(temp.val, 1);
            }
            temp = temp.next;

*/


//1 2 3 4
//temp = 1
//temp1 = temp.next = 2