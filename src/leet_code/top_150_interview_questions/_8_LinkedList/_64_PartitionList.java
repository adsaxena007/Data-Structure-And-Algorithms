package leet_code.top_150_interview_questions._8_LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class _64_PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null)
            return head;

        List<ListNode> list = new ArrayList<>();


        while (head!=null && head.val >= x){
            list.add(head);
            head= head.next;
        }

        ListNode temp = head;
        if(head==null){
            ListNode newHead = list.getFirst();
            temp = newHead;
            head = temp;
            newHead.next=null;
            int i=1;
            while (i<list.size()){
                ListNode node = list.get(i);
                temp.next = node;
                node.next=null;
                temp=temp.next;
                i++;
            }
        }else {
            while (temp.next!=null){
                if(temp.next.val >= x){
                    ListNode temp2 = temp;
                    while (temp2.next!=null && temp2.next.val >= x){
                        list.add(temp2.next);
                        temp2= temp2.next;
                    }
                    temp.next=temp2.next;
                }
                if(temp.next!=null)
                    temp=temp.next;
            }

            int i=0;
            while (i<list.size()){
                ListNode node = list.get(i);
                temp.next = node;
                node.next=null;
                temp=temp.next;
                i++;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        _64_PartitionList ob =new _64_PartitionList();
//        int []values = {10,9,8,7,6,5,4,3,2,1,0};
        int []values = {1,1};
        ListNode head = ListNode.createList(values);
        ListNode.printList(ob.partition(head, 0));
    }
}
