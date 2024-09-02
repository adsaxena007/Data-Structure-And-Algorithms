package leet_code.top_150_interview_questions._8_LinkedList;

public class _61_ReverseNodeInGroup {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null || left == right)
            return head;

        if(left==1 && right==2){
            ListNode temp = head.next;
            head.next = head.next.next;
            temp.next = head;
            return temp;
        }

        ListNode temp = head;
        while(left<right){
            int i=1;
            temp = head;
            while (i<left-1){
                temp = temp.next;
                i++;
            }
            ListNode leftNode = temp;
            i=1;
            temp = head;
            while (i<right-1){
                temp = temp.next;
                i++;
            }
            ListNode rightNode = temp;
            if(left>1){
                ListNode tempNode1 = leftNode.next;
                ListNode tempNode2 = rightNode.next;

                rightNode.next = tempNode1;
                ListNode tempNode3 = tempNode1.next;
                tempNode1.next = tempNode2.next;
                tempNode2.next = tempNode3;
                leftNode.next = tempNode2;
            }else{
//              "" 1, 2, "3", 4, 5,6,7,8,9,10
                ListNode tempNode2 = rightNode.next;    // 4
                ListNode tempNode3 = rightNode.next.next;   //5
                tempNode2.next = head.next;
                rightNode.next = head;
                head.next = tempNode3;

                head = tempNode2;


            }
            left++;
            right--;
        }

        return head;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int length=0;
        ListNode temp = head;
        while (temp!=null){
            length++;
            temp=temp.next;
        }
        int i=1;
        while ((i+k-1)<=length){
            head = reverseBetween(head, i, i+k-1);
            i = i+k;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] values = {1,2,3};
        ListNode head = ListNode.createList(values);
        _61_ReverseNodeInGroup ob = new _61_ReverseNodeInGroup();
        ListNode.printList(ob.reverseKGroup(head,2));
    }
}
