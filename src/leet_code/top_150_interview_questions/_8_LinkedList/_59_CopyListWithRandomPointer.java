package leet_code.top_150_interview_questions._8_LinkedList;


import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class _59_CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        Map<Node, Node> map = new IdentityHashMap<>();
        Node temp = new Node(head.val);
        Node temp2;
        Node oldHead = head.next;
        temp2 = temp;
        map.put(head, temp);
        while (oldHead!=null){
            Node temp1 = new Node(oldHead.val);
            map.put(oldHead, temp1);
            temp.next = temp1;
            temp = temp.next;
            oldHead = oldHead.next;
        }

        Node newHead = temp2;
        oldHead = head;
        while (oldHead!=null){
            if(oldHead.random!=null){
                temp2.random = map.get(oldHead.random);
            }else{
                temp2.random = null;
            }
            temp2=temp2.next;
            oldHead = oldHead.next;
        }
        return newHead;
    }
}
