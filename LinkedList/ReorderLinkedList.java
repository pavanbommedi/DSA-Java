package LinkedList;

import LinkedList.ReverseLinkedListDemo.ListNode;

public class ReorderLinkedList {

    public void reorderList(ListNode head) {
        ListNode slow  = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        while(slow!= null){
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        ListNode left = head;
        ListNode right = prev;
        while(right.next!=null ){
            ListNode temp_left =left.next;
            ListNode temp_right = right.next;

            left.next = right;
            right.next = temp_left;

            left = temp_left;
            right= temp_right;

        }
        
        
    }

}
