package com.hashnet.temp;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomic_Test {

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(0);

        i.accumulateAndGet(5, Integer::sum);
        System.out.println(i);

        i.accumulateAndGet(2, (x, y) -> x - y);
        System.out.println(i);
    }
}
