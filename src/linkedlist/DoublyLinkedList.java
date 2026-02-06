package linkedlist;

public class DoublyLinkedList {

    /**
     * Node definition for Doubly Linked List
     */
    static class Node {
        int value;
        Node prev;
        Node next;

        Node(int value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    /**
     * Insert at beginning
     *
     * Time Complexity: O(1)
     */
    public void insertAtBeginning(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    /**
     * Insert at end
     *
     * Time Complexity: O(1)
     */
    public void insertAtEnd(int value) {
        Node newNode = new Node(value);

        if (tail == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    /**
     * Insert at given position (0-based index)
     *
     * Time Complexity: O(n)
     */
    public void insertAtPosition(int index, int value) {
        if (index < 0) {
            return;
        }

        if (index == 0) {
            insertAtBeginning(value);
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) {
                return;
            }
            current = current.next;
        }

        if (current == null || current.next == null) {
            insertAtEnd(value);
            return;
        }

        Node newNode = new Node(value);
        newNode.next = current.next;
        newNode.prev = current;

        current.next.prev = newNode;
        current.next = newNode;
    }

    /**
     * Delete at beginning
     *
     * Time Complexity: O(1)
     */
    public void deleteAtBeginning() {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        head = head.next;
        head.prev = null;
    }

    /**
     * Delete at end
     *
     * Time Complexity: O(1)
     */
    public void deleteAtEnd() {
        if (tail == null) {
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        tail = tail.prev;
        tail.next = null;
    }

    /**
     * Delete at given position (0-based index)
     *
     * Time Complexity: O(n)
     */
    public void deleteAtPosition(int index) {
        if (index < 0 || head == null) {
            return;
        }

        if (index == 0) {
            deleteAtBeginning();
            return;
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            if (current == null) {
                return;
            }
            current = current.next;
        }

        if (current == null) {
            return;
        }

        if (current == tail) {
            deleteAtEnd();
            return;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
    }

    /**
     * Search a value
     *
     * Time Complexity: O(n)
     */
    public boolean search(int value) {
        Node current = head;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void printForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void printBackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.value + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertAtBeginning(2);
        list.insertAtBeginning(1);
        list.insertAtEnd(4);
        list.insertAtPosition(2, 3);

        list.printForward();   // 1 <-> 2 <-> 3 <-> 4 <-> null
        list.printBackward();  // 4 <-> 3 <-> 2 <-> 1 <-> null

        list.deleteAtBeginning();
        list.printForward();   // 2 <-> 3 <-> 4 <-> null

        list.deleteAtEnd();
        list.printForward();   // 2 <-> 3 <-> null

        list.deleteAtPosition(1);
        list.printForward();   // 2 <-> null

        System.out.println(list.search(2));  // true
        System.out.println(list.search(10)); // false
    }
}
