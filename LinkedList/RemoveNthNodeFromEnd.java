public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy;
        ListNode right = dummy;
        for(int i =0;i<=n;i++){
            right = right.next;
        }
        while(right!=null){
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;

        return dummy.next;

        
    }
}
