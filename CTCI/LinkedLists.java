package CTCI;

import java.util.HashSet;

/**
 * Created by sammiej on 6/6/18
 */
public class LinkedLists {

    public static class Node {
        Node next = null;
        int data;

        public Node(int d) {
            data = d;
        }

        public void appendToTail(int d) {
            Node end = new Node(d);
            Node n = this;
            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
        }
    }

    public static Node removeDuplicates(Node head) {
        HashSet<Integer> values = new HashSet<>();
        Node n = head;
        values.add(head.data);

        while(n.next != null) {
            if(values.contains(n.next.data)) {
                n.next = n.next.next;
            } else {
                values.add(n.next.data);
                n = n.next;
            }
        }

        return head;
    }

    public static Node returnKthToLast(Node head, int k) {
        Node tail = head;
        Node kNode = head;

        for(int i=0; i<k-1; i++) {
            if(tail == null) return null;
            tail = tail.next;
        }
        while(tail.next != null) {
            tail = tail.next;
            kNode = kNode.next;
        }
        return kNode;
    }

    public static boolean deleteMiddleNode(Node middleNode) {
        if(middleNode == null || middleNode.next == null) return false;

        Node next = middleNode.next;
        middleNode.data = next.data;
        middleNode.next = next.next; 
        return true;
    }
}
