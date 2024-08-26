package data_structures.linked_list;

public class Main {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList(10);
        ll.append(20);
        ll.append(30);
        ll.append(40);
        ll.append(50);

        ll.printList();

        ll.removeLast();
        ll.removeLast();

        ll.printList();

        ll.prepend(60);
        ll.prepend(80);

        ll.removeFirst();

        ll.printList();
        System.out.println("reverse");
        ll.reverse();

        ll.printList();

        System.out.println(ll.findMiddleNode());
    }
}
