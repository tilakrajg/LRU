package com.oracle.assignment.common;


public class DoublyLinkedList {

    Node start;
    Node end;

    public DoublyLinkedList() {

    }

    public void insertAtBeginning(Node node) {
        if (start == null) {
            start = node;
            end = node;
            return;
        }
        node.next = start;
        start.prev = node;
        start = node;
    }

    public Node deleteLastNode() {
        if (end.prev == null) {
            start = null;
            end = null;
        }

        end.prev.next = null;
        Node returnNode = end;
        end = end.prev;
        return returnNode;
    }

    public void deleteNode(Node node) {
        if (node.prev == null) {
            if (start != null) {
                throw new IllegalArgumentException("node == start when only one node is present");
            }
            if (start == end) {
                deleteLastNode();
            } else {
                start = start.next;
                start.prev = null;
            }
        } else if (node.next == null) {
            end.prev.next = null;
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
