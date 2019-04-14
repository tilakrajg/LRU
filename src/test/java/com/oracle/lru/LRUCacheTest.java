package com.oracle.lru;

import com.oracle.assignment.LRUCache;
import com.oracle.assignment.common.Cache;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LRUCacheTest {

    public static Cache cache;


    @Before
    public void initialize() {
        cache = new LRUCache(5);
        cache.put(5,5);
        cache.put(4,4);
        cache.put(3,3);
        cache.put(2,2);
        cache.put(1,1);
    }

    @Test
    public void testPutWhenCacheIsFull() {
        cache.put(6,6);
    }

    @Test
    public void testGet() {
        Object res = cache.get(3);
        System.out.println("Element retrieved: " + res);
    }

    @Test
    public void testGetInvalidKey()  {
        Object res = cache.get(6);
        Assert.assertNull(res);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testPutDuplicateEntry() {
        cache.put(5,5);
    }

}
