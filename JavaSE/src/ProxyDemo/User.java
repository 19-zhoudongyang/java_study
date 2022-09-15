package ProxyDemo;

public class User implements Person{
    @Override
    public int add() {
        System.out.println("add");
        return 0;
    }

    @Override
    public int user(int i) {
        System.out.println("user");
        return 0;
    }
}
