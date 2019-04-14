package com.oracle.assignment.common;

public class Node {
    Object value;
    Object key;
    Node prev;
    Node next;

    public Node(Object key, Object value) {
        this.value = value;
        this.key = key;
        this.prev = null;
        this.next = null;
    }

    public Object getValue() {
        return value;
    }

    public Object getKey() {
        return key;
    }
}