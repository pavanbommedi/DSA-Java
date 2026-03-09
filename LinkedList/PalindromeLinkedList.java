package LinkedList;

import LinkedList.ReverseLinkedListDemo.ListNode;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //Slow - fast pointer to find middle element
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //Reverse 2nd half of Linkedlist
        ListNode prev = null;
        while(slow!=null){
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        ListNode right = prev;
        ListNode left = head;
        while(right!=null){
            if(left.val!=right.val) return false;
            left = left.next;
            right = right.next;
        }
        return true;
        
    }
}
