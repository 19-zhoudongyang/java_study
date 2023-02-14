package JUC;

import java.util.concurrent.atomic.AtomicInteger;

public class test {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.getAndIncrement();
    }
}
