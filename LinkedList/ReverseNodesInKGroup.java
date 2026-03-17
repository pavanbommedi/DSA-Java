package LinkedList;

import LinkedList.ReverseLinkedListDemo.ListNode;

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;

        while(true){
            ListNode kth = getKth(groupPrev,k);
            if(kth == null) break;
            
            ListNode curr = groupPrev.next;
            ListNode prev = kth.next;

            ListNode groupNext = kth.next;
            while(curr!=groupNext){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            ListNode temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;
        }
        return dummy.next;
    }
    public ListNode getKth(ListNode curr,int k){
        while(curr!=null && k>0){
            curr=curr.next;
            k--;
        }
        return curr;
    }
    
}
