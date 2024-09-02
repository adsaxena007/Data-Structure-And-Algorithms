package leet_code.top_150_interview_questions._8_LinkedList;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    ListNode head;
    ListNode tail;
    private final int capacity;
    private int size = 0;
    private final Map<Integer, ListNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
        this.map = new HashMap<>();
    }

    public void moveNodeToLast(ListNode node){
        if(node==tail) {
            return;
        }

        if(node==head){
            if(head!=tail){
                head = head.next;
                node.prev=tail;
                node.next=null;
                tail.next=node;
                tail=tail.next;
            }
        }else {
            ListNode temp = node.next;
            ListNode temp2 = node.prev;
            temp2.next = temp;
            if(temp!=null)
                temp.prev = temp2;

            tail.next = node;
            node.next=null;
            node.prev=tail;
            tail=tail.next;
        }
    }

    public int get(int key) {
        if(head==null){
            return -1;
        }
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            moveNodeToLast(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            node.val = value;
            moveNodeToLast(node);
        }else {
            ListNode node = new ListNode(key,value);
            if(head==null){
                node.prev=null;
                node.next=null;
                head = node;
                tail = node;
            }else if(map.size() < capacity){
                node.prev = tail;
                node.next=null;
                tail.next = node;
                tail = tail.next;
            }else {
                map.remove(head.key);
                if(head.next==null){
                    node.next=null;
                    node.prev=null;
                    head=node;
                    tail=node;
                }else {
                    head=head.next;
                    tail.next=node;
                    node.prev=tail;
                    node.next=null;
                    tail=tail.next;
                }

            }
            map.put(key, node);
        }
    }
}

public class _65_LeastRecentlyUsed {
    public static void main(String[] args) {
        // Create LRUCache with a capacity of 2
        LRUCache lruCache = new LRUCache(2);

        // Perform the operations according to the input
        System.out.println(lruCache.get(2)); // Returns -1 (cache is empty)

        lruCache.put(2, 6);  // Cache: {2=6}

        System.out.println(lruCache.get(2)); // Returns 6

        lruCache.put(1, 5);  // Cache: {2=6, 1=5}
        lruCache.put(1, 2);  // Cache: {2=6, 1=2}, Updates key 1 to 2

        System.out.println(lruCache.get(1)); // Returns 2

        System.out.println(lruCache.get(2)); // Returns -1 (not found, since it was evicted)
    }
}
