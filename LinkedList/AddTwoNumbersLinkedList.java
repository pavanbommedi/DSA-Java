package LinkedList;

import LinkedList.ReverseLinkedListDemo.ListNode;

public class AddTwoNumbersLinkedList {

    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        int carry = 0;
        while(list1!=null || list2!=null || carry>0){
            int val1;
            if(list1!=null) val1 = list1.val;
            else val1 = 0;
            int val2;
            if(list2!=null) val2 = list2.val;
            else val2 = 0;
            int val  = val1+ val2+ carry;

            carry = val/10;
            val = val%10;
            curr.next = new ListNode(val);

            curr = curr.next;
            if(list1!=null) list1 = list1.next;
            if(list2!=null) list2 = list2.next;
        }
        return dummy.next;
        
    }
}
