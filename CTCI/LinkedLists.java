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

        for(int i=1; i<k; i++) {
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

    public static Node partition(Node head, int x) {
        Node leftHead = new Node(0);
        Node rightHead = new Node(0);

        Node p1 = leftHead;
        Node p2 = rightHead;

        while(head != null) {
            if(head.data < x) {
                p1.next = head;
                p1 = head;
            } else {
                p2.next = head;
                p2 = head;
            }
            head = head.next;
        }

        p2.next = null;
        p1.next = rightHead.next;

        return leftHead.next;
    }

    public static Node sumLists(Node head1, Node head2, int carry) {
        if(head1 == null && head2 == null && carry == 0) {
            return null;
        }

        Node result = new Node(0);
        int value = carry;
        if(head1 != null) {
            value += head1.data;
        }
        if(head2 != null) {
            value += head2.data;
        }

        result.data = value % 10;

        if(head1 != null || head2 != null) {
            Node next = sumLists(head1 == null ? null : head1.next,
                                    head2 == null ? null : head2.next, value / 10);
            result.next = next;
        }
        return result;
    }

    public static Node loopDetection(Node head) {
        if(head.next == null) return head;

        Node slower = head;
        Node faster = head;

        while(faster != null && faster.next != null) {
            faster = faster.next.next;
            slower = slower.next;
            if(slower == faster) break;
        }

        // Sanity check loop exists
        if(faster == null || faster.next == null) {
            return null;
        }

        // At meeting point, both slower and faster nodes are k steps from beginning of loop
        slower = head;
        while(slower != faster) {
            slower = slower.next;
            faster = faster.next;
        }

        return slower;
    }
}
