package com.github.marlonflorencio.java8.collections.list;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PerformanceTest {

    private static final int size = 150_000;

    @Test
    public void perform() {

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        // ArrayList add
        Instant start = Instant.now();
        add(arrayList);
        print("ArrayList add:  ", start);

        // LinkedList add
        start = Instant.now();
        add(linkedList);
        print("LinkedList add: ", start);

        // ArrayList get
        start = Instant.now();
        get(arrayList);
        print("ArrayList get:  ", start);

        // LinkedList get
        start = Instant.now();
        get(linkedList);
        print("LinkedList get: ", start);

        // ArrayList get iterated
        start = Instant.now();
        it(arrayList);
        print("ArrayList get iterated:  ", start);

        // LinkedList get iterated
        start = Instant.now();
        it(linkedList);
        print("LinkedList get iterated: ", start);

        // ArrayList get iterated
        start = Instant.now();
        stream(arrayList);
        print("ArrayList stream:  ", start);

        // LinkedList get iterated
        start = Instant.now();
        stream(linkedList);
        print("LinkedList stream: ", start);

        // ArrayList remove
        start = Instant.now();
        remove(arrayList);
        print("ArrayList remove:  ", start);

        // LinkedList remove
        start = Instant.now();
        remove(linkedList);
        print("LinkedList remove: ", start);
    }

    private void add(List<Integer> list) {
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
    }

    private void get(List<Integer> list) {
        for (int i = 0; i < size; i++) {
            list.get(i);
        }
    }

    private void it(List<Integer> list) {
        Iterator<Integer> it  = list.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private void remove(List<Integer> list) {
        for (int i = size - 1; i >= 0; i--) {
            list.remove(i);
        }
    }

    private void stream(List<Integer> list) {
        list.stream().forEach(i -> i.hashCode());
    }

    private void print(String str, Instant start) {
        System.out.println(str + Duration.between(start, Instant.now()).toMillis());
    }
}
