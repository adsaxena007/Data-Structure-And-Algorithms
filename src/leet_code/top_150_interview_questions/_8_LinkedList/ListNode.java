package leet_code.top_150_interview_questions._8_LinkedList;

public class ListNode {
    int val;
    int key;
    ListNode next;
    ListNode prev;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int key, int val) { this.key = key;this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    // Helper method to create a linked list from an array
    public static ListNode createList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }
}
