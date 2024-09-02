package leet_code.top_150_interview_questions._8_LinkedList;

public class _58_MergeTwoList {
     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null)
            return null;

        if(list1==null)
            return list2;

        if(list2 == null)
            return list1;

        ListNode temp;
        if(list1.val >=list2.val) {
            temp = list2;
            list2=list2.next;
        }
        else {
            temp = list1;
            list1=list1.next;
        }
        ListNode head = temp;
        while ((list1!=null && list2!=null)){
            if(list1.val >= list2.val){
                temp.next = list2;
                temp=temp.next;
                list2=list2.next;
            }else {
                temp.next = list1;
                temp=temp.next;
                list1=list1.next;
            }
        }

        while(list1!=null){
            temp.next = list1;
            temp=temp.next;
            list1=list1.next;
        }

        while(list2!=null){
            temp.next = list2;
            temp=temp.next;
            list2=list2.next;
        }

        return head;
    }
}
