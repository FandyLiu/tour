package com.fandy.juc.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Test {


    List<Object> container = Collections.synchronizedList(new LinkedList<>());

    void put(Object o) {
        container.add(o);
    }

    synchronized Object get() {
        if (container.size() > 0) {
            return container.remove(0);
        }
        return null;
    }

    int getCount() {
        return container.size();
    }

    public static void main(String[] args) {
        Long datetime = System.currentTimeMillis();
        System.out.println(datetime);
    }
}
