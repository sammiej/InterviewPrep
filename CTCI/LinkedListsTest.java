package CTCI;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Random;

public class LinkedListsTest {

    @Test
    public void removeDuplicates() {
        LinkedLists.Node head = generateDuplicateList(20);
        LinkedLists.removeDuplicates(head);

        assertEquals(getListSize(head), 10);
    }

    @Test
    public void returnKthToLast() {
        // Linked list of 0-9
        LinkedLists.Node head = new LinkedLists.Node(0);

        for(int i=1; i<10; i++) {
            head.appendToTail(i);
        }

        LinkedLists.Node kNode = LinkedLists.returnKthToLast(head, 3);

        assertEquals(kNode.data, 7);
    }

    @Test
    public void deleteMiddleNode() {
        // Linked list of 0-9
        LinkedLists.Node head = new LinkedLists.Node(0);

        for(int i=1; i<10; i++) {
            head.appendToTail(i);
        }

        LinkedLists.deleteMiddleNode(head.next);

        assertEquals(getListSize(head), 9);
        assertEquals(head.next.data, 2);
    }

    // Generates a list of numbers that include the values 0-9 as well as random duplicates
    private LinkedLists.Node generateDuplicateList(int size) {
        Random rand = new Random();
        LinkedLists.Node head = new LinkedLists.Node(0);

        for(int i=1; i<10; i++) {
            head.appendToTail(i);
        }
        for(int j=0; j<size-10; j++) {
            head.appendToTail(rand.nextInt(10));
        }

        return head;
    }

    // Returns the length of the linked list
    private int getListSize(LinkedLists.Node head) {
        int count = 1;
        LinkedLists.Node current = head;

        while(current.next != null) {
            current = current.next;
            count++;
        }

        return count;
    }
}