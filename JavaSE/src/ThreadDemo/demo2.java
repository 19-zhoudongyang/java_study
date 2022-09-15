package ThreadDemo;

public class demo2 {
    public static void main(String[] args) {
        Thread A = new Thread();
        Thread B = new Thread();
        A.setName("A线程");
        B.setName("B线程");
    }
}

class num extends Thread{
    @Override
    public void run() {
        if (Thread.currentThread().getName()=="A线程"){
        }
    }
}
