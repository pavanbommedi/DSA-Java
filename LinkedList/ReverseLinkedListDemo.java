package LinkedList;

public class ReverseLinkedListDemo {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // ---------------- ITERATIVE SOLUTION ----------------
    public static ListNode reverseIterative(ListNode head) {

        ListNode prev = null;
        ListNode temp;

        while (head != null) {
            temp = head.next;   // store next node
            head.next = prev;   // reverse pointer
            prev = head;        // move prev forward
            head = temp;        // move head forward
        }

        return prev;
    }

    // ---------------- RECURSIVE SOLUTION ----------------
    public static ListNode reverseRecursive(ListNode head) {

        // base case
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseRecursive(head.next);

        head.next.next = head; // reverse link
        head.next = null;      // break old link

        return newHead;
    }

    // ---------------- PRINT LIST ----------------
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {

        // Creating linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5)))));

        System.out.println("Original List:");
        printList(head);

        // Iterative reverse
        head = reverseIterative(head);

        System.out.println("Reversed List (Iterative):");
        printList(head);

        // Reverse again using recursion
        head = reverseRecursive(head);

        System.out.println("Reversed Again (Recursive):");
        printList(head);
    }
}