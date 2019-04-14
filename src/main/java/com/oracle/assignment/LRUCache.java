package com.oracle.assignment;

import com.oracle.assignment.common.DoublyLinkedList;
import com.oracle.assignment.common.Node;
import com.oracle.assignment.common.Cache;

import java.util.Map;
import java.util.HashMap;

public class LRUCache implements Cache {
    Map<Object, Node> nodeAccessMap;
    DoublyLinkedList priorityList;
    int currentSize;
    int maxSize;

    public LRUCache(int maxSize) {
        this.maxSize = maxSize;
        this.nodeAccessMap = new HashMap<Object, Node>(maxSize );
        this.priorityList = new DoublyLinkedList();
        this.currentSize = 0;
    }

    private void updateLL(Node node) {
        this.priorityList.deleteNode(node);
        this.priorityList.insertAtBeginning(node);
    }

    public Object get(Object key) {
        if (this.nodeAccessMap.get(key) == null) {
            return null;
        }
        Node node = this.nodeAccessMap.get(key);
        updateLL(node);
        return node.getValue();
    }

    public void put(Object key, Object value) {
        if (this.nodeAccessMap.get(key) != null){
            throw new IllegalArgumentException("Key already present");
        }
        Node newNode = new Node(key,value);
        if (this.currentSize == this.maxSize) {
            Node oldestNode =
                    this.priorityList.deleteLastNode();
            this.nodeAccessMap.remove(oldestNode.getKey());
        } else {
            this.currentSize++;
        }
        this.priorityList.insertAtBeginning(newNode);
        this.nodeAccessMap.put(key, newNode);
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void printPriotiyList() {
        this.priorityList.printLL();
    }
}
