package linked_list;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int data){
        head = new Node(data);
        head.next = null;
        tail = head;
        length = 1;
    }
    public void printList(){
        Node temp = head;
        while(temp !=null){
            System.out.print(temp.getData() + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void append(int data){
        Node node = new Node(data);
        node.next = null;
        tail.next = node;
        tail = tail.next;
        length++;
    }

    public void removeLast(){
        Node temp = head;
        while(temp.next.next !=null){
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        length--;
    }

    public void prepend(int data){
        Node node = new Node(data);
        node.next = head;
        head = node;
        length++;
    }

    public void removeFirst(){
        Node temp = head;
        head  = head.next;
        temp.next = null;
        length--;
    }

    public int get(int index){
        Node temp = head;
        for(int i=0; i< index;i++)
            temp = temp.next;

        return temp.getData();
    }

    public void set(int index, int data){
        Node temp = head;
        for(int i=0; i< index;i++)
            temp = temp.next;

        temp.setData(data);
    }

    public void insert(int index, int data){
        Node newNode = new Node(data);
        Node temp = head;
        for(int i=0; i< index-1;i++)
            temp = temp.next;

        newNode.next = temp.next;
        temp.next = newNode;
        length++;
    }

    public void remove(int index){

        Node temp = head;
        for(int i=0; i< index-1;i++)
            temp = temp.next;

        temp.next = temp.next.next;
        length--;
    }

    public void reverse(){

        Node temp1 = head;
        Node temp2 = head.next;
        Node temp3;
        tail = temp1;
        while(temp2.next!=null){
            temp3 = temp2.next;
            temp2.next = temp1;
            temp1 = temp2;
            temp2 = temp3;

        }
        temp2.next = temp1;
        tail.next=null;
        head = temp2;
    }

    public Node findMiddleNode(){
        Node temp = head;
        Node temp2 = head;
        while(temp2.next!=null){
            temp = temp.next;
            temp2 = temp2.next;
            if(temp2.next != null){
                temp2 = temp2.next;
            }
        }
        return temp;
    }

    public boolean hasCycle(Node head) {
        if(head==null)
            return false;
        Node temp = head;
        Node temp2 = head;
        boolean loop = false;
        while(temp2.next!=null && temp2.next.next!=null){
            temp = temp.next;
            temp2 = temp2.next.next;
            if(temp == temp2){
                loop = true;
                break;
            }

        }
        return loop;
    }

    public Node removeNthFromEnd(Node head, int n) {
        if(head == null)
            return head;
        if(head.next == null && n ==1){
            head = null;
        }
        Node temp = head;
        Node temp2 = head;

        int i = 0;
        while(i<n && temp2!=null && temp2.next!=null){
            temp2 = temp2.next;
            i++;
        }
        if(temp2!=null){
            while(temp2.next!=null){
                temp = temp.next;
                temp2 = temp2.next;
            }
        }
        if(temp !=null && temp.next!=null)
            temp.next = temp.next.next;

        return head;
    }
}
