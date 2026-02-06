package linkedlist;

public class CircularLinkedList {

    /**
     * Node definition for Circular Linked List
     */
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
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
            newNode.next = newNode; // circular link
            return;
        }

        newNode.next = head;
        tail.next = newNode;
        head = newNode;
    }

    /**
     * Insert at end
     *
     * Time Complexity: O(1)
     */
    public void insertAtEnd(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = tail = newNode;
            newNode.next = newNode;
            return;
        }

        tail.next = newNode;
        newNode.next = head;
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
            current = current.next;
            if (current == head) {
                return; // index out of bounds
            }
        }

        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;

        if (current == tail) {
            tail = newNode;
        }
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
        tail.next = head;
    }

    /**
     * Delete at end
     *
     * Time Complexity: O(n)
     */
    public void deleteAtEnd() {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }

        current.next = head;
        tail = current;
    }

    /**
     * Delete at given position (0-based index)
     *
     * Time Complexity: O(n)
     */
    public void deleteAtPosition(int index) {
        if (head == null || index < 0) {
            return;
        }

        if (index == 0) {
            deleteAtBeginning();
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
            if (current.next == head) {
                return;
            }
        }

        if (current.next == tail) {
            deleteAtEnd();
            return;
        }

        current.next = current.next.next;
    }

    /**
     * Search for a value
     *
     * Time Complexity: O(n)
     */
    public boolean search(int value) {
        if (head == null) {
            return false;
        }

        Node current = head;
        do {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        } while (current != head);

        return false;
    }

    public void print() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.value + " -> ");
            current = current.next;
        } while (current != head);

        System.out.println("(back to head)");
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtBeginning(1);
        list.insertAtPosition(3, 4);

        list.print(); // 1 -> 2 -> 3 -> 4 -> (back to head)

        list.deleteAtBeginning();
        list.print(); // 2 -> 3 -> 4 -> (back to head)

        list.deleteAtEnd();
        list.print(); // 2 -> 3 -> (back to head)

        list.deleteAtPosition(1);
        list.print(); // 2 -> (back to head)

        System.out.println(list.search(2));  // true
        System.out.println(list.search(10)); // false
    }
}
