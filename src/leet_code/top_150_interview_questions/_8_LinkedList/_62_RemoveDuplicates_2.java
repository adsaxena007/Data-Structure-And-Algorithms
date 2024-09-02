package leet_code.top_150_interview_questions._8_LinkedList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class _62_RemoveDuplicates_2 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return head;

        while (head!=null){
            boolean removeDup=false;
            while(head.next !=null && head.val == head.next.val){
                head = head.next;
                removeDup = true;
            }
            if (removeDup){
                head = head.next;
            }else {
                break;
            }
        }

        ListNode temp = head;
        while (temp!=null){
            ListNode temp2 = temp.next;
            if(temp2!=null && temp2.next !=null && temp2.val == temp2.next.val){
                while(temp2.next !=null && temp2.val == temp2.next.val){
                    temp2.next = temp2.next.next;
                }
                temp.next = temp2.next;
                continue;
            }

            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] values = {1,1,1,1,1,2,2,2,3};
        ListNode head = ListNode.createList(values);
        _62_RemoveDuplicates_2 ob = new _62_RemoveDuplicates_2();
        ListNode.printList(ob.deleteDuplicates(head));
    }
}
