package leet_code.top_150_interview_questions._8_LinkedList;

public class _63_RotateList {
    public ListNode rotateRight(ListNode head, int k) {

        if(head==null || head.next==null || k==0)
            return head;

        ListNode temp = head;
        int len = 0;

        while (temp!=null){
            temp=temp.next;
            len++;
        }

        int nodeToRotate = 0;
        if(k<len){
             nodeToRotate=k;
        }else {
            nodeToRotate=k%len;
        }

        if(nodeToRotate==0)
            return head;

        int i=len;
        temp = head;
        ListNode newHead;
        while (i>nodeToRotate+1){
            temp=temp.next;
            i--;
        }
        newHead = temp.next;
        temp.next=null;
        temp=newHead;

        while (temp.next!=null)
            temp=temp.next;

        temp.next=head;

        return newHead;
    }

    public static void main(String[] args) {
        _63_RotateList ob =new _63_RotateList();
        int []values = {0,1};
        ListNode head = ListNode.createList(values);
        ListNode.printList(ob.rotateRight(head, 4));
    }
}
