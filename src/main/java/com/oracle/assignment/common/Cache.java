package com.oracle.assignment.common;

public interface Cache {
    Object get(Object key);
    void put(Object key, Object value);
    int getMaxSize();
}
