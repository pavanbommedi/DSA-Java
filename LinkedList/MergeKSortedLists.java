package LinkedList;

import LinkedList.ReverseLinkedListDemo.ListNode;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;

        while(lists.length>1){
            ListNode[] mergedLists = new ListNode[(lists.length+1)/2];
            int index =0;
            for(int i =0;i<lists.length;i+=2){
                ListNode l1 = lists[i];
                ListNode l2;
                if(i+1<lists.length) l2 = lists[i+1];
                else l2 = null;
                mergedLists[index++]=mergeList(l1,l2);
            }
            lists = mergedLists;

        }
        return lists[0];
    }
        public ListNode mergeList(ListNode l1,ListNode l2){
            ListNode dummy = new ListNode();
            ListNode tail = dummy;

            while(l1!=null && l2!=null){
                if(l1.val < l2.val){
                    tail.next = l1;
                    l1 = l1.next;
                }
                else{
                    tail.next = l2;
                    l2 = l2.next;
                }
                tail = tail.next;
            }
            if(l1!=null) tail.next = l1;
            if(l2!=null) tail.next = l2;

            return dummy.next;
        }
}
