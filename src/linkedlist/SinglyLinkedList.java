package linkedlist;

public class SinglyLinkedList {

    /**
     * Node definition
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

    /**
     * Insert at beginning
     *
     * Time Complexity: O(1)
     */
    public void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    /**
     * Insert at end
     *
     * Time Complexity: O(n)
     * (must traverse to last node)
     */
    public void insertAtEnd(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
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

        if (current == null) {
            return;
        }

        Node newNode = new Node(value);
        newNode.next = current.next;
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
        head = head.next;
    }

    /**
     * Delete at end
     *
     * Time Complexity: O(n)
     * (must find node before last)
     */
    public void deleteAtEnd() {
        if (head == null) {
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;
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
            if (current.next == null) {
                return;
            }
            current = current.next;
        }

        if (current.next == null) {
            return;
        }

        current.next = current.next.next;
    }

    /**
     * Search value
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

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtBeginning(3);
        list.insertAtBeginning(1);
        list.insertAtEnd(5);
        list.insertAtPosition(1, 2);

        list.printList(); // 1 -> 2 -> 3 -> 5 -> null

        list.deleteAtBeginning();
        list.printList(); // 2 -> 3 -> 5 -> null

        list.deleteAtEnd();
        list.printList(); // 2 -> 3 -> null

        list.deleteAtPosition(1);
        list.printList(); // 2 -> null

        System.out.println(list.search(2)); // true
        System.out.println(list.search(10)); // false
    }
}
