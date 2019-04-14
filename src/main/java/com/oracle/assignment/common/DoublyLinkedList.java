package com.oracle.assignment.common;


public class DoublyLinkedList {

    Node start;
    Node end;

    public DoublyLinkedList() {

    }

    public void insertAtBeginning(Node node) {
        // node is first node inserted into the list
        if (start == null) {
            start = node;
            end = node;
        } else {
            node.prev = null;
            node.next = start;
            start.prev = node;
            start = node;
        }
    }

    public Node deleteLastNode() {
        // List is empty
        if (start == null)
            return null;
        // Only One node present
        if (end.prev == null) {
            start = null;
        } else {
            end.prev.next = null;
        }
        Node returnNode = end;
        end = end.prev;
        return returnNode;
    }

    public void deleteNode(Node node) {
        // When deleted node is start
        if (node.prev == null) {
            if (start != null) {
                throw new IllegalArgumentException("node == start when only one node is present");
            }
            // When only node present which needs to be deleted
            if (start == end) {
                deleteLastNode();
            } else {
                start = start.next;
                start.prev.next = null;
                start.prev = null;
            }
        } else if (node.next == null) { // Last node is to be deleted
            deleteLastNode();
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }
    }

    public void printLL() {
        Node curr = start;
        while (curr != null) {
            System.out.print(curr.value + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

}
