package CTCI;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Random;

public class LinkedListsTest {

    @Test
    public void removeDuplicatesTest() {
        LinkedLists.Node head = generateDuplicateList(20);
        LinkedLists.removeDuplicates(head);

        printList(head);
    }

    @Test
    public void returnKthToLastTest() {
        LinkedLists.Node head = generateRandomList(10);

        LinkedLists.Node kNode = LinkedLists.returnKthToLast(head, 3);

        printList(head);
        System.out.println(kNode.data);
    }

    @Test
    public void deleteMiddleNodeTest() {
        LinkedLists.Node head = generateRandomList(10);
        printList(head);
        LinkedLists.deleteMiddleNode(head.next.next);
        printList(head);
    }

    @Test
    public void partitionTest() {
        Random rand = new Random();
        int num = rand.nextInt(10);
        System.out.println(num);

        LinkedLists.Node head = generateRandomList(10);
        printList(head);
        LinkedLists.Node newHead = LinkedLists.partition(head, num);
        printList(newHead);
    }

    @Test
    public void sumListsTest() {
        LinkedLists.Node head1 = generateRandomList(3);
        LinkedLists.Node head2 = generateRandomList(4);
        printList(head1);
        printList(head2);
        LinkedLists.Node result = LinkedLists.sumLists(head1, head2, 0);
        printList(result);
    }

    @Test
    public void loopDetection() {
        LinkedLists.Node head = generateRandomList(10);
        LinkedLists.Node tail = head;
        while(tail.next != null) {
            tail = tail.next;
        }
        tail.next = head.next.next;

        LinkedLists.Node loopStart = LinkedLists.loopDetection(head);
        assertEquals(loopStart, head.next.next);
    }

    // Generates random list of size with numbers from 0 - size
    private LinkedLists.Node generateRandomList(int size) {
        Random rand = new Random();
        LinkedLists.Node head = new LinkedLists.Node(rand.nextInt(size));

        for(int i=1; i<size; i++) {
            head.appendToTail(rand.nextInt(size));
        }

        return head;
    }

    // Generates random list of size with numbers from 0 - size/2
    private LinkedLists.Node generateDuplicateList(int size) {
        Random rand = new Random();
        LinkedLists.Node head = generateRandomList(size/2);

        for(int j=0; j<size/2; j++) {
            head.appendToTail(rand.nextInt(size/2));
        }

        return head;
    }

    private void printList(LinkedLists.Node node) {
        System.out.print("The resulting list is: [ ");
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("]");
    }
}