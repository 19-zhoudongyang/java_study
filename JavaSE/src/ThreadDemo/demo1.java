package ThreadDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import static java.lang.Thread.sleep;

public class demo1 {
    public static void main(String[] args) {
        Threadtest1 threadtest1 = new Threadtest1();
        FutureTask futureTask = new FutureTask(threadtest1);
        Thread thread = new Thread(futureTask);
//        Thread thread1 = new Thread(threadtest1);
//        thread.setName("用户A");
//        thread1.setName("用户B");
        thread.start();
//        thread1.start();


    }
}
class Threadtest1 implements Callable{
    private double money = 0;

    @Override
    public Object call() throws Exception {
        return null;
    }
}