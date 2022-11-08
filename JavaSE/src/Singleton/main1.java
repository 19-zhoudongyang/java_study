package Singleton;

public class main1 {
    public static void main(String[] args) {
        singleton1 singleton1 = Singleton.singleton1.INSTANCE;
        singleton3 singleton3 = Singleton.singleton3.INSTANCE;
        System.out.println(singleton1);
        System.out.println(singleton3);
    }
}
